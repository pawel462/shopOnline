package net.dintel.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.dintel.shopbackend.dao.CategoryDAO;
import net.dintel.shopbackend.dto.Category;



@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
		//dodanie categorii
		mv.addObject("categories", categoryDAO.list());
		
		
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping(value = { "/about" })
	public ModelAndView about() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value = { "/contact" })
	public ModelAndView contact() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	
	/*
	 * metody ladujace wszystkie producty
	 */
	
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		//dodanie categorii
		mv.addObject("categories", categoryDAO.list());
		
		
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
			ModelAndView mv = new ModelAndView("page");
		
			//nazwa dla pojedynczej categori
			
		Category category= null;
		category = categoryDAO.get(id);
		
		mv.addObject("title", category.getName());
		//dodanie categorii
		mv.addObject("categories", categoryDAO.list());
		//passing pojedynczy object
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}

//	@RequestMapping(value="/test")
//	public ModelAndView test(@RequestParam(value="greeting", required=false)String greeting){
//		if(greeting == null){
//			greeting = "Hello there";
//		}
//		
//		ModelAndView mv = new ModelAndView("page");
//		mv.addObject("greeting", greeting);
//		return mv;
//	}
	
//	@RequestMapping(value="/test/{greeting}")
//	public ModelAndView test(@PathVariable(value="greeting", required=false)String greeting){
//		if(greeting == null){
//			greeting = "Hello there";
//		}
//		
//		ModelAndView mv = new ModelAndView("page");
//		mv.addObject("greeting", greeting);
//		return mv;
//	}
	
	
}
