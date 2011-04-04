package cn.edu.nju.software.timemachine.action.picture;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.nju.software.timemachine.action.BaseAction;
import cn.edu.nju.software.timemachine.entity.Album;
import cn.edu.nju.software.timemachine.entity.Picture;
import cn.edu.nju.software.timemachine.service.IAlbumService;
import cn.edu.nju.software.timemachine.service.IPictureService;

@Controller
@Scope("prototype")
public class AddPhotoAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private File[] uploads;
	private String[] uploadFileNames;
	private String[] uploadContentTypes;
	private String[] dir;
	private String[] targetFileName;
	private String json;
	
	@Autowired
	private IAlbumService<Album> albumService;
	
	@Autowired
	private IPictureService<Picture> pictureService;
	
	//getter and setter functions for attributes
	public File[] getUpload(){
		return this.uploads;
	}
	public void setUpload(File[] upload){
		this.uploads = upload;
	}
	
	public String[] getUploadFileName(){
		return this.uploadFileNames;
	}
	public void setUploadFileName(String[] uploadFileName){
		this.uploadFileNames = uploadFileName;
	}
	
	public String[] getUploadContentType(){
		return this.uploadContentTypes;
	}
	public void setUploadContentType(String[] uploadContentType){
		this.uploadContentTypes = uploadContentType;
	}
	
	public String[] getDir(){
		return dir;
	}
	public void setDir(String[] dir){
		this.dir = dir;
	}
	
	public String[] getTargetFileName(){
		return targetFileName;
	}
	public void setTargetFileName(String[] targetFileName){
		this.targetFileName = targetFileName;
	}
	
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	public String execute() throws Exception{
		//get the real directory of 'upload'
		String realPath = ServletActionContext.getServletContext().getRealPath("/data");
		JSONObject jsonObject = new JSONObject(json);
		String albumName = jsonObject.getString("albumName");
		Album album = albumService.getAlbum(albumName,(Long)session.get("id"));
		JSONArray jArray = jsonObject.getJSONArray("pictureList");
		//get real directory
		String targetDirectory = realPath;
		String[] mydir = new String[uploads.length];
		String[] tname = new String[uploads.length];
		for(int i = 0; i < uploads.length; i++){
			targetDirectory = realPath;
			Picture picture = new Picture();
			picture.setAlbum(album);
			if(jArray.getJSONObject(i).getString("date")!=null){
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				picture.setCustomDate(format.parse(jArray.getJSONObject(i).getString("date")));
			}else{
				picture.setCustomDate(new Date());
			}
			picture.setDateCreated(new Date());
			picture.getPictureMeta().setDescription(jArray.getJSONObject(i).getString("description"));
			int position = uploadFileNames[i].lastIndexOf(".");
			String pictureType = uploadFileNames[i].substring(position+1);
			picture.setPictureType(pictureType);
			position = uploadFileNames[i].lastIndexOf("/");
			System.out.println("********************"+uploadFileNames[i]);
			if(position==-1){
				position = uploadFileNames[i].lastIndexOf("\\");
			}
			if(position==-1){
				position = 0;
			}
			int dotPosition = uploadFileNames[i].lastIndexOf(".");
			String picName = uploadFileNames[i].substring(position, dotPosition);
			picture.setName(picName);
			
			System.out.println("****"+targetDirectory);
			long picId = pictureService.addPicture(picture);
			targetDirectory = targetDirectory+"/"+session.get("id")+"/"+albumName;
			System.out.println("*************"+targetDirectory);
			tname[i] = picId+"."+pictureType;
			mydir[i] = targetDirectory+"/"+tname[i];
			System.out.println("****************"+mydir[i]);
			File target = new File(targetDirectory,tname[i]);
			try {
				FileUtils.copyFile(uploads[i], target);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		setDir(mydir);
		setTargetFileName(tname);
		return SUCCESS;
	}
	
	
	public void setPictureService(IPictureService<Picture> pictureService) {
		this.pictureService = pictureService;
	}
	public IPictureService<Picture> getPictureService() {
		return pictureService;
	}
	
	
	

}
