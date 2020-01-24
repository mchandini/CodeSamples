package com.webapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webapp.DAO.Books;
import com.webapp.services.BooksService;



//class will act as controller with annotation @Controller 
@Controller
public class BooksController {
	
	//when "/" find in the URI showHome method will get executed and return logical view name "Home"
		//and Home.jsp will be executed

		/*simple controller method
		@RequestMapping("/")
		public String showHome() {
			return "Home";
		}*/
		
		/*//with session values
		@RequestMapping("/")
		public String showHome(HttpSession session) {
			session.setAttribute("key","value");
			return "Home";
		}*/
		
		//with model and view
		//@RequestMapping("/")
		/*public ModelAndView showHome() {
			
			//create a model and view for Home.jsp
			ModelAndView mv = new ModelAndView("Home");
			
			//to modify the model call .getModel
			//it returns a model map
			Map<String,Object> model = mv.getModel();
			
			model.put("model-key","model value");
			
			//ModelAndView must be retruned to use in jsp
			return mv;
		}*/
		
	
	private BooksService booksService;
	
	@Autowired
	public void setBooksService(BooksService booksService) {
		this.booksService = booksService;
	}

	//using only model not with view
	@RequestMapping("/Books")	
	public String showBooks(Model model) { 
		
		//booksService.throwTestException();
		
		List<Books> books= booksService.getData();
		model.addAttribute("Books",books);	

		return "Books";
	}
	
	/*
	 * @ExceptionHandler(DataAccessException.class) public String
	 * HandleException(DataAccessException ex) { return "ErrorPage"; }
	 */
	
	//model should be present with attribute as same as with the commandName's value of the form
	@RequestMapping("/AddBooks")	
	public String AddBooks(Model model) { 		
		
		model.addAttribute("book", new Books());
		System.out.println("in /AddBooks");
		return "AddBooks";
	}
	
	//BindingResult allows validator and to use its methods
	//@Valid will valid the object against the rules provided for the properties
	@RequestMapping(value="/doAdd", method=RequestMethod.POST)	
	public String doAdd(Model model, @Valid Books book, BindingResult result) { 
		if(result.hasErrors()) {
			model.addAttribute("book", book);
			
			  List<ObjectError> errors = result.getAllErrors();
			  
			  for(ObjectError error: errors) { System.out.println(error); }
			 
			return "AddBooks";
		}
		
		System.out.println("in controller"+book);
		booksService.addBook(book);
		return "Home";		
	}
	
	
	
}
