package cn.edu.nju.software.timemachine.service.impl;

import org.springframework.stereotype.Service;

import cn.edu.nju.software.timemachine.entity.SimpleComment;
import cn.edu.nju.software.timemachine.service.ICommentService;

@Service("commentService")
public class CommentServiceImpl<T extends SimpleComment> extends ServiceImpl<T> implements ICommentService<T> {

	public int getConSum(long pictureId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getProSum(long pictureId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
