package cn.edu.nju.software.timemachine.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Picture extends BaseEntity {
	
	@OneToMany(mappedBy="picture")
	private List<SimpleComment> commentList = new ArrayList<SimpleComment>();
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date customDate;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn
	private Album album;
	
	private String pictureType;
	
	@OneToOne (cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn
	private PictureMeta pictureMeta;

	public List<SimpleComment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<SimpleComment> commentList) {
		this.commentList = commentList;
	}

	public Date getCustomDate() {
		return customDate;
	}

	public void setCustomDate(Date customDate) {
		this.customDate = customDate;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public String getPictureType() {
		return pictureType;
	}

	public void setPictureType(String pictureType) {
		this.pictureType = pictureType;
	}

	public PictureMeta getPictureMeta() {
		return pictureMeta;
	}

	public void setPictureMeta(PictureMeta pictureMeta) {
		this.pictureMeta = pictureMeta;
	}

}
