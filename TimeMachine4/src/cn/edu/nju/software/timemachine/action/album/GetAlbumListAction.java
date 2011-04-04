package cn.edu.nju.software.timemachine.action.album;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.edu.nju.software.timemachine.action.BaseAction;
import cn.edu.nju.software.timemachine.entity.Album;
import cn.edu.nju.software.timemachine.entity.Picture;
import cn.edu.nju.software.timemachine.service.IAlbumService;

@Controller
@Scope("prototype")
public class GetAlbumListAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IAlbumService<Album> albumService;

	public void setAlbumService(IAlbumService<Album> albumService) {
		this.albumService = albumService;
	}

	public IAlbumService<Album> getAlbumService() {
		return albumService;
	}

	
	public void getAlbumList() throws JSONException{
		JSONObject jsonObject = new JSONObject();
		long id = (Long) session.get("id");
		for(Album album: albumService.getAlbumList((Long)session.get("id")) ){
			JSONObject ajson = new JSONObject();
			ajson.accumulate("name", album.getName());
			Picture cover = album.getCover();
			if(cover!=null){
				ajson.accumulate("cover", "data/"+id+"/"+album.getName()+"/"+cover.getId()+"."+cover.getPictureType());
			}else{
				//没有图片的相册的封面
				ajson.accumulate("cover", "img/userphoto.jpg");
			}
			ajson.accumulate("description", album.getAlbumMeta().getDescription());
			ajson.accumulate("cusotomDate", album.getCustomDate());
			jsonObject.append("albumList", ajson);
		}
		sendMsg(jsonObject.toString());
	}
}