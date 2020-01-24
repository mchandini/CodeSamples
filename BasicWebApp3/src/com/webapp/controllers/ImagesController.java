package com.webapp.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.webapp.DAO.ImagesDAO;

@Controller
public class ImagesController {

	private ImagesDAO imagesDAO;

	@Autowired
	public void setImagesDAO(ImagesDAO imagesDAO) {
		this.imagesDAO = imagesDAO;
	}

	@RequestMapping("/AddImages")
	public String addImageForm() {
		return "AddImages";
	}

	@RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
	public String uploadImages(@RequestParam(defaultValue = "name of file", value = "FileName") String name,
			@RequestParam(value="photo") MultipartFile photo) {
		System.out.println("Name of file" + name);
		try {
			imagesDAO.insertImage(name, photo);
			System.out.println("succesfull image insertion");
		} catch (IOException e) {
			
			System.out.println("IO exception occured while inserting image " + e);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error occured while inserting image {}" + e);
		}

		return "Home";
	}
}
