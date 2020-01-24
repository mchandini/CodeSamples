package com.webapp.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.stereotype.Component;

//DAO is useful to communicate with DB and for CRUD operations
@Component("BooksDAO")
public class BooksDAO {

	private JdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new JdbcTemplate(jdbc);
	}
	
	public List<Books> getBooks(){
		
		return jdbc.query("select * from Books", new RowMapper<Books>() {
			
			public Books mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Books book = new Books();	

				book.setId(rs.getInt("Id"));
				book.setName(rs.getString("Name"));
				book.setAuthor(rs.getString("Author"));
				
				return book;
			}
		});
	}
	
	public void create(Books book) {
		System.out.println("in dao "+book);
		//BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(book);	
		//System.out.println("in dao "+params.Id+"	"+params.Name+"		"+params.Author);
		jdbc.update("insert into Books (id, name, author) values ("+book.Id+",'"+book.Name+"','"+book.Author+"')");
	}
}
