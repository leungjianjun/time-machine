package cn.edu.nju.software.timemachine.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.nju.software.timemachine.entity.SimpleComment;
import cn.edu.nju.software.timemachine.service.ICommentService;

@Service("commentService")
@Transactional
public class CommentServiceImpl<T extends SimpleComment> extends ServiceImpl<T> implements ICommentService<T> {

	/**
	 * comment的类型只有两种，一个是C，一个是P
	 * 
	 */
	public int getConSum(long pictureId) {
		return  dao.createQuery("from SimpleComment as comment where comment.picture.id = :id and comment.type = 'C'")
		                   .setParameter("id",pictureId).list().size();
	}

	public int getProSum(long pictureId) {
		return  dao.createQuery("from SimpleComment as comment where comment.picture.id = :id and comment.type = 'P'")
        .setParameter("id",pictureId).list().size();
	}

	/**
	 * comment中对每一个图片，每个用户只能评论一遍，如果重复评论则返回false<p>
	 * 而且comment的type只能填C或P
	 */
	public boolean addComment(T comment) {
		if(dao.createQuery("from SimpleComment as comment where  comment.commentor.cid = :id and comment.picture.id =:pid ")
				.setParameter("cid", comment.getCommentor().getId()).setParameter("pid", comment.getPicture().getId()).uniqueResult()!=null ||
				 comment.getCommentor() == null ||
				 comment.getPicture() == null){
			return false;
		}else{
			dao.create(comment);
			return true;
		}
		
	}

}
