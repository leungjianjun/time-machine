package cn.edu.nju.software.timemachine.action.picture;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.nju.software.timemachine.action.BaseAction;
import cn.edu.nju.software.timemachine.entity.Picture;
import cn.edu.nju.software.timemachine.entity.SimpleComment;
import cn.edu.nju.software.timemachine.entity.User;
import cn.edu.nju.software.timemachine.service.ICommentService;
import cn.edu.nju.software.timemachine.service.IPictureService;
import cn.edu.nju.software.timemachine.service.IUserService;

@Controller
@Scope("prototype")
public class CommentPhotoAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String json;
	
	@Autowired
	private ICommentService<SimpleComment> commentService;
	
	@Autowired
	private IUserService<User> userService;
	
	@Autowired
	private IPictureService<Picture> pictureService;

	public IPictureService<Picture> getPictureService() {
		return pictureService;
	}

	public void setPictureService(IPictureService<Picture> pictureService) {
		this.pictureService = pictureService;
	}

	public IUserService<User> getUserService() {
		return userService;
	}

	public void setUserService(IUserService<User> userService) {
		this.userService = userService;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public ICommentService<SimpleComment> getCommentService() {
		return commentService;
	}

	public void setCommentService(ICommentService<SimpleComment> commentService) {
		this.commentService = commentService;
	}
	
	public void comment() throws JSONException{
		JSONObject jsonObject = new JSONObject(json);
		long pictId = jsonObject.getLong("pictureId");
		boolean content = jsonObject.getBoolean("content");
		SimpleComment comment = new SimpleComment();
		comment.setCommentor(userService.getUser((Long)session.get("id")));
		comment.setDateCreated(new Date());
		comment.setPicture(pictureService.getPicture(pictId));
		comment.setType(content?"P":"C");
		commentService.addComment(comment);
	}

}
