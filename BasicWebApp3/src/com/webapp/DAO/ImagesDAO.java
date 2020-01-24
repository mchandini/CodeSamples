package com.webapp.DAO;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component("ImagesDAO")
public class ImagesDAO {
	
	public ImagesDAO() {
		
	}

	private JdbcTemplate jdbcT;
	
	@Autowired
	public ImagesDAO(DataSource datasource) {
		jdbcT= new JdbcTemplate(datasource);
	}
	
	public void insertImage(String name, MultipartFile file) throws IOException{
		
		System.out.println("in imageDAO");
		System.out.println("Name of file"+name);
		
		byte[] imageBytes= file.getBytes();
		System.out.println(imageBytes.length);
		System.out.println(jdbcT == null);
		jdbcT.update("insert into Images(Name, Image) values (?,?)", new Object[] {name, imageBytes});
		//jdbcT.update("insert into Images(Name, Image) values ("+name+","+ imageBytes+")");
		//jdbcT.update("insert into Images(Name, Image) values (?,?)", name, imageBytes);
	}
}
