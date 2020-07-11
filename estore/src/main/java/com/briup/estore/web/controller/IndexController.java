package com.briup.estore.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Cart;
import com.briup.estore.bean.Customer;
import com.briup.estore.exception.ServiceException;
import com.briup.estore.service.BookService;
import com.briup.estore.service.CustomerService;

@Controller
public class IndexController {

	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BookService bookService;
	
	
	//显示首页
	@GetMapping("/index")
	public String indexPage(HttpSession session,Model model) {

		return "index";
	}
	
	
	/*
	 * 显示注册页面
	 */
	@GetMapping("/register")
	public String registerPage() {
		return "register";
	}
	/*
	 * 实现注册
	 */
	@PostMapping("/register")
	public String registerCustomer(Customer customer) throws ServiceException {
		return "login";
	}
	/*
	 * 显示登录页面
	 */
	@GetMapping({"/","/login"})
	public String loginPage(HttpSession session) {
		return "login";
	}
	@GetMapping("/adminlogin")
	public String adminlogin(HttpSession session) {
		return "admin/login";
	}
	
	/*
	 * 用户登录
	 */
	@PostMapping("/login")
	public String login(Customer customer,Model model,HttpSession session) throws ServiceException {
		
		return "index";
	}
	/*
	 * 用户退出
	 */
	@GetMapping("/logout")
	public String logOut(HttpSession session) {
		session.removeAttribute("customer");
		session.removeAttribute("cart");
		return "login";
	}
}
