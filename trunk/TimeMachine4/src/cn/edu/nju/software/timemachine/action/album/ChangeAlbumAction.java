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
import cn.edu.nju.software.timemachine.service.IAlbumService;

@Controller
@Scope("prototype")
public class ChangeAlbumAction extends BaseAction{
	
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
	
	public void changeAlbum() throws Exception{
		JSONObject jsonObject = new JSONObject(json);
		String oldName = jsonObject.getString("oldName");
		String newName = jsonObject.getString("newName");
		String customDate = jsonObject.getString("customDate");
		String description = jsonObject.getString("description");
		
		
		Album album = albumService.getAlbum(oldName,(Long)session.get("id"));
		if(newName!=null&&newName!=""){
			album.setName(newName);
		}
		
		if(customDate!=null&&customDate!=""){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:s");
			Date newCustomDate = format.parse(customDate);
			album.setCustomDate(newCustomDate);
		}
		
		if(description!=null && description!=""){
			album.getAlbumMeta().setDescription(description);
		}
		
		if(albumService.getAlbum(newName,(Long)session.get("id"))==null){
			albumService.update(album);
			String rootPath = ServletActionContext.getServletContext().getRealPath("/data");
			String oldFilePath = rootPath+"/"+session.get("id")+"/"+oldName;
			File albumFile = new File(oldFilePath);
			String newFilePath = rootPath+"/"+session.get("id")+"/"+newName;
			albumFile.renameTo(new File(newFilePath));
			
			json = "{\"msg\":\"1\"}";
		}else{
			json = "{\"msg\":\"2\"}";
		}
		
		sendMsg(json);
	}

}
