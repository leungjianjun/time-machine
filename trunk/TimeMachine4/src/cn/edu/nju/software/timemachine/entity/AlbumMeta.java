package cn.edu.nju.software.timemachine.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class AlbumMeta extends BaseEntity {
	
	@OneToOne(mappedBy = "albumMeta")
	private Album album;
	
	private String description;

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
