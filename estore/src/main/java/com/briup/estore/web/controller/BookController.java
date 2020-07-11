package com.briup.estore.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.estore.bean.Book;
import com.briup.estore.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	
	 @Autowired private BookService bookService;
	 /*
	  * 书目详细信息
	  */
	 @GetMapping("/id/{id}") 
	 public String showPage(@PathVariable("id") Long id,Model model) {
		 Book book = bookService.findById(id);
		 model.addAttribute("book", book);
		 return "user/productDetail"; 
	 }
	 /*
	  * 通过id删除书籍
	  */
	 @GetMapping("/delete/{id}")
	 public String deleteById(@PathVariable("id") Long id){
		 bookService.deleteById(id);
		 return "redirect:/admin/index";
	 }
	 /*
	  * 修改书籍价格
	  */
	 @PostMapping("/saveupdate")
	 public String saveupdate(Long id,Double price) {
		 Book book = bookService.findById(id);
		 book.setPrice(price);
		 bookService.save(book);
		 return "redirect:/admin/index";
	 }
}
