package cn.edu.nju.software.timemachine.action.picture;

import java.text.SimpleDateFormat;
import java.util.Date;

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
public class UpdatePictureAction extends BaseAction{
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
	
	public void updatePicture() throws Exception{
		JSONObject jsonObject = new JSONObject(json);
		Picture picture = pictureService.getPicture(jsonObject.getLong("id"));
		String description = jsonObject.getString("description");
		String customDate = jsonObject.getString("customDate");
		if(description != null && description != ""){
			picture.getPictureMeta().setDescription(description);
		}
		
		if(customDate != null && customDate !=""){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = format.parse(customDate);
			picture.setCustomDate(date);
		}
		
		pictureService.update(picture);
	}

}
