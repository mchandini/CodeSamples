package com.webapp.DAO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Books {

	int Id;
	
	@Size(min=5, max=15, message="Enter a name with in the range 5 and 15")
	String Name;
	
	@NotNull
	String Author;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	
	@Override
	public String toString() {
		return "Books [Id=" + Id + ", Name=" + Name + ", Author=" + Author + "]";
	}
	
	
}
