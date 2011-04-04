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
public class Album extends BaseEntity {
	
	@OneToMany(mappedBy="album")
	private List<Picture> pictureList = new ArrayList<Picture>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private User owner;
	
	private String name;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date customDate;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn
	private Picture cover;
	
	@OneToOne (cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn
	private AlbumMeta albumMeta = new AlbumMeta();

	public List<Picture> getPictureList() {
		return pictureList;
	}

	public void setPictureList(List<Picture> pictureList) {
		this.pictureList = pictureList;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCustomDate() {
		return customDate;
	}

	public void setCustomDate(Date customDate) {
		this.customDate = customDate;
	}

	public Picture getCover() {
		return cover;
	}

	public void setCover(Picture cover) {
		this.cover = cover;
	}

	public void setAlbumMeta(AlbumMeta albumMeta) {
		this.albumMeta = albumMeta;
	}

	public AlbumMeta getAlbumMeta() {
		return albumMeta;
	}

}
