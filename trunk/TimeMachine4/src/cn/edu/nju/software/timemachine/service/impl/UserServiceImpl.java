package cn.edu.nju.software.timemachine.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.nju.software.timemachine.entity.Category;
import cn.edu.nju.software.timemachine.entity.Role;
import cn.edu.nju.software.timemachine.entity.User;
import cn.edu.nju.software.timemachine.service.IUserService;
import cn.edu.nju.software.timemachine.util.Constraint;

@Service("userService")
@SuppressWarnings("unchecked")
@Transactional 
public class UserServiceImpl<T extends User> extends ServiceImpl<T> implements IUserService<T> {

	public T getUser(long id) {
		return (T) dao.createQuery("from User as user where user.id= :userId")
		                 .setParameter("userId", id).uniqueResult();
	}

	public T getUser(String email, String password) {
		return (T) dao.createQuery("from User as user where user.email= :email and user.password = :password")
                         .setParameter("email", email).setParameter("password",password).uniqueResult();
	}

	public T searchUserByEmail(String email) {
		return (T) dao.createQuery("from User as user where user.email = :email")
		          .setParameter("email", email).uniqueResult();
		
	}

	public List<T> searchUserByName(String name) {
		return (List<T>)dao.createQuery("from User as user where user.name = :name")
        .setParameter("name", name).list();
	}

	public List<T> serchUser(Constraint constraint) {
		String hql = "from User as user where ";
		boolean flag = false;
		if(constraint.getCity()!=null){
			hql+="user.userMeta.city = :city ";
			flag = true;
		}
		if(constraint.getCountry()!=null){
			hql+=(flag?"and ":"")+"user.userMeta.country = :country ";
			flag = true;
		}
		if(constraint.getMaxBirthday()!=null){
			hql+=(flag?"and ":"")+"user.userMeta.birthday <= :maxbirthday ";
			flag = true;
		}
		if(constraint.getMinBirthday()!=null){
			hql+=(flag?"and ":"")+"user.userMeta.birthday <= :minbirthday ";
			flag = true;
		}
		if(constraint.getSex()!=null){
			hql+=(flag?"and ":"")+"user.userMeta.sex=:sex ";
		}
		
		Query query = dao.createQuery(hql);
		
		if(constraint.getCity()!=null){
			query.setParameter("city", constraint.getCity());
		}
		if(constraint.getCountry()!=null){
			query.setParameter("country",constraint.getCountry());
		}
		if(constraint.getMaxBirthday()!=null){
			query.setParameter("maxbirthday",constraint.getMaxBirthday());
		}
		if(constraint.getMinBirthday()!=null){
			query.setParameter("minbirthday",constraint.getMinBirthday());
		}
		if(constraint.getSex()!=null){
			query.setParameter("sex",constraint.getSex());
		}
		
		List<T> userList = query.list();
		
		if(constraint.getMaxAge()!=null){
			int birthYear = Calendar.getInstance().get(Calendar.YEAR) - constraint.getMaxAge();
			for(int i=0;i<userList.size();i++){
				if(userList.get(i).getUserMeta().getBirthday().get(Calendar.YEAR) < birthYear){
					userList.remove(i);
					i--;
				}
			}
		}
		
		if(constraint.getMinAge()!=null){
			int birthYear = Calendar.getInstance().get(Calendar.YEAR) - constraint.getMinAge();
			for(int i=0;i<userList.size();i++){
				if(userList.get(i).getUserMeta().getBirthday().get(Calendar.YEAR) > birthYear){
					userList.remove(i);
					i--;
				}
			}
		}
		
		return userList;
	}

	/**
	 * 添加用户时，service为user添加role，以及一个名为default的category，<br>
	 * 好友在默认情况下应该添加到default中，当然这是有action决定的
	 */
	public boolean addUser(T user) {
		Role role = (Role) dao.createQuery("from Role as role where role.name = 'user'").uniqueResult();
		user.setRole(role);
		Category category = new Category();
		category.setDateCreated(new Date());
		category.setName("default");
		category.setOwner(user);
		user.getCategoryList().add(category);
		role.getUserList().add(user);
		if(dao.createQuery("from User as user where user.email = :email")
		          .setParameter("email", user.getEmail()).uniqueResult() != null){
			return false;
		}else{
			dao.create(user);
			return true;
		}
	}

	public T getUser(String email) {
		return (T) dao.createQuery("from User as user where user.email= :email")
        .setParameter("email", email).uniqueResult();
	}
}
