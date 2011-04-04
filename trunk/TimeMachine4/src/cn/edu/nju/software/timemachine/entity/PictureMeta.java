package cn.edu.nju.software.timemachine.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class PictureMeta extends BaseEntity {
	
	@OneToOne(mappedBy = "pictureMeta")
	private Picture picture;
	
	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String description;

}
