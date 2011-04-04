package cn.edu.nju.software.timemachine.action.album;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.nju.software.timemachine.action.BaseAction;
import cn.edu.nju.software.timemachine.entity.Album;
import cn.edu.nju.software.timemachine.entity.User;
import cn.edu.nju.software.timemachine.service.IAlbumService;
import cn.edu.nju.software.timemachine.service.IUserService;

@Controller
@Scope("prototype")
public class CreateAlbumAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IAlbumService<Album> albumService;
	@Autowired
	private IUserService<User> userService;
	
	private String json;

	public IAlbumService<Album> getAlbumService() {
		return albumService;
	}

	public void setAlbumService(IAlbumService<Album> albumService) {
		this.albumService = albumService;
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
	
	public void createAlbum() throws Exception{
		JSONObject jsonObject = new JSONObject(json);
		

			long id = (Long)session.get("id");
			User _user = userService.getUser(id);
			String name = jsonObject.getString("name");
			
			SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:dd:ss");
			Date customDate = simpleFormat.parse((String)jsonObject.get("date"));
			
			String description = jsonObject.getString("description");
			Album album = new Album();
			album.setOwner(_user);
			album.setName(name);
			album.setDateCreated(customDate);
			album.getAlbumMeta().setDescription(description);
			
			if(albumService.addAlbum(album)){
				String realPath = ServletActionContext.getServletContext().getRealPath("/data");
				String filePath = realPath + "/"+id+"/"+name;
				File userFile = new File(filePath);
				userFile.mkdir();
				json = "{\"msg\":\"1\"}";
			}else{
				json = "{\"msg\":\"2\"}";
			}
			sendMsg(json);
		}
	

}
