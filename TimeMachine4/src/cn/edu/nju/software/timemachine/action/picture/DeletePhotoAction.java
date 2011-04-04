package cn.edu.nju.software.timemachine.action.picture;

import java.io.File;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.nju.software.timemachine.action.BaseAction;
import cn.edu.nju.software.timemachine.entity.Picture;
import cn.edu.nju.software.timemachine.service.IPictureService;

@Controller
@Scope("prototype")
public class DeletePhotoAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String json;
	
	@Autowired
	private IPictureService<Picture> pictureService;

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public IPictureService<Picture> getPictureService() {
		return pictureService;
	}

	public void setPictureService(IPictureService<Picture> pictureService) {
		this.pictureService = pictureService;
	}
	
	public void deletePictureList() throws JSONException{
		JSONArray jArray = (new JSONObject(json)).getJSONArray("pictureList");
		for(int i = 0;i<jArray.length();i++){
			long picId = jArray.getJSONObject(i).getLong("id");
			Picture picture = pictureService.getPicture(picId);
			String albumName = picture.getAlbum().getName();
			String rootPath = ServletActionContext.getServletContext().getRealPath("data");
			String filePath = rootPath+"/"+session.get("id")+"/"+albumName+"/"+picId+"."+picture.getPictureType();
			File file = new File(filePath);
			file.delete();
			pictureService.delete(picture);
		}
	}
}