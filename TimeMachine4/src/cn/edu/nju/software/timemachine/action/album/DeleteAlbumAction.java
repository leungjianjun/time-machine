package cn.edu.nju.software.timemachine.action.album;

import java.io.File;

import org.apache.struts2.ServletActionContext;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.nju.software.timemachine.action.BaseAction;
import cn.edu.nju.software.timemachine.entity.Album;
import cn.edu.nju.software.timemachine.service.IAlbumService;

@Controller
@Scope("prototype")
public class DeleteAlbumAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IAlbumService<Album> albumService;
	
	private String json;

	public void setAlbumService(IAlbumService<Album> albumService) {
		this.albumService = albumService;
	}

	public IAlbumService<Album> getAlbumService() {
		return albumService;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String getJson() {
		return json;
	}
	
	public void delete() throws JSONException{
		JSONObject jsonObject = new JSONObject(json);
		String name = jsonObject.getString("name");
		Album album;
		if( (album=albumService.getAlbum(name,(Long)session.get("id"))) != null){
			albumService.delete(album);
			deleteFile(name);
			json = "{\"msg\":\"1\"}";
		}else{
			json = "{\"msg\":\"2\"}";
		}
		sendMsg(json);
	}
	
	private void deleteFile(String name){
		String rootPath = ServletActionContext.getServletContext().getRealPath("/data");
		String filePath = rootPath+"/"+session.get("id")+"/"+name;
		File file = new File(filePath);
		file.delete();
		
	}

}
