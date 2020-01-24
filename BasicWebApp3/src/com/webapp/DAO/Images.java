package com.webapp.DAO;

import org.springframework.web.multipart.MultipartFile;

public class Images {
	
	int id;
	String name;
	MultipartFile image;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "Images [id=" + id + ", name=" + name + ", image=" + image + "]";
	}

	
}
