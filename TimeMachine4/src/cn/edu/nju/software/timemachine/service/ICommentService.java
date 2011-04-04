package cn.edu.nju.software.timemachine.service;

import cn.edu.nju.software.timemachine.entity.SimpleComment;

public interface ICommentService<T extends SimpleComment> extends IService<T> {
	
	/**
	 * 你可以通过 <code>pciture.getCommentList()</code>获取所有的评论，次方法方便你获取支持的评论数
	 * @param pictureId
	 * @return
	 */
	public int getProSum(long pictureId);
	
	public int getConSum(long pictureId);
	
	public boolean addComment(T comment);

}
