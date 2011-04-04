package cn.edu.nju.software.timemachine.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.nju.software.timemachine.entity.Category;
import cn.edu.nju.software.timemachine.entity.Friend;
import cn.edu.nju.software.timemachine.service.IFriendService;

@Service("friendService")
@Transactional
public class FriendServiceImpl<T extends Friend> extends ServiceImpl<T> implements IFriendService<T> {
	/**
	 * fromc 和 toC中只要有id就行
	 */
	public boolean moveUser(T friend,long fromCId,long toCId) {
		Category c1 = (Category)dao.createQuery("from Category as category where category.id = : id").setParameter("id", fromCId).uniqueResult();
		Category c2 = (Category)dao.createQuery("from Category as category where category.id = : id").setParameter("id", toCId).uniqueResult();
		if((c1.getOwner().getId()!=c2.getOwner().getId()) ||
				 (friend.getCategory().getId()!=fromCId)){
			return false;
		}else{
			friend.setCategory(c2);
			dao.save(friend);
			return true;
		}
	}

	/**
	 * friend 如果已经存在则返回错误,由于添加好友是双向的，而friend里只能指定被添加的好友和已添加的好友，<br>
	 * 以及其中一个的category，所以还要增加另外一个catgory，所以friend里要指定<code>friend.category.id</code>,
	 * <code>friend.user.id</code>
	 */
	@SuppressWarnings("unchecked")
	public boolean addFriend(T friend,Category category) {
		if(dao.createQuery("from Friend as friend where friend.user.id = :uid and friend.category.owner.id =:oid")
				 .setParameter("uid", friend.getUser().getId()).setParameter("oid", friend.getCategory().getOwner().getId()).uniqueResult()!=null ||
				 friend.getCategory()==null ||
				 friend.getUser()==null){
			return false;
		}else{
			dao.create(friend);
		    //双向添加
			T friend2 = (T) new Friend();
			friend2.setCategory(category); 
			friend2.setUser(((Category) dao.createQuery("from Category as category where category.id = :id").setParameter("id", friend.getCategory().getId()).uniqueResult()).getOwner());
			dao.create(friend2);
			return true;
		}
	}
}
