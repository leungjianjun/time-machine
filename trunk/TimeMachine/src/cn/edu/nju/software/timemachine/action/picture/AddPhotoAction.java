package cn.edu.nju.software.timemachine.action.picture;



import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class AddPhotoAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private File[] uploads;
	private String[] uploadFileNames;
	private String[] uploadContentTypes;
	private String[] dir;
	private String[] targetFileName;
	
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
	
	public String execute() throws Exception{
		//get the real directory of 'upload'
		String realPath = ServletActionContext.getServletContext().getRealPath("/upload");
		System.out.println("*********************"+realPath+"**********************");
		
		//get real directory
		String targetDirectory = realPath;
		String[] mydir = new String[uploads.length];
		String[] tname = new String[uploads.length];
		for(int i = 0; i < uploads.length; i++){
			//filenames for the files to be saved
			tname[i] = generateFileName(uploadFileNames[i]);
			//the path to save files
			mydir[i] = targetDirectory+"\\"+tname[i];
			//make a file
			File target = new File(targetDirectory,tname[i]);
			//copy the from tempfile to realfile
			FileUtils.copyFile(uploads[i], target);
		}
		setDir(mydir);
		setTargetFileName(tname);
		return SUCCESS;
	}
	
	//provide name for the files uploaded
	private String generateFileName(String fileName){
		//get current time
		DateFormat format = new SimpleDateFormat("yyMMddHHmmss");
		//convert to string
		String formatDate = format.format(new Date());
		//get random file number
		int random = new Random().nextInt(10000);
		//get the extension of the file
		int position = fileName.lastIndexOf(".");
		String extension = fileName.substring(position);
		return formatDate+random+extension;
		
	}
	
	
	

}
