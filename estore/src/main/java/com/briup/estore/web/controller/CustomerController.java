package com.briup.estore.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Cart;
import com.briup.estore.bean.Customer;
import com.briup.estore.exception.ServiceException;
import com.briup.estore.service.BookService;
import com.briup.estore.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private BookService bookService;
	// 显示用户管理页面
		@GetMapping({ "/", "" })
		public String showCustomer() {
			return "user/userinfo";
		}
	/*
	 * 实现注册
	 */
	@PostMapping("/register")
	public String registerCustomer(Customer customer) throws ServiceException {
		customerService.register(customer);
		return "login";
	}
	/*
	 * 实现登录
	 */
	@PostMapping("/login")
	public String loginCustomer(Customer customer,Model model,HttpSession session) throws ServiceException {
		String name = customer.getName();
		String password = customer.getPassword();
		Customer customer2 = customerService.login(name, password);
		session.setAttribute("customer", customer2);
		return "redirect:/customer/index";
	}
	/*
	 * 查看书籍
	 */
	@GetMapping("/index")
	public String findBook(HttpSession session) {
		List<Book> books = bookService.selBook();
		session.setAttribute("books", books);
		Cart cart = new Cart();
		session.setAttribute("cart", cart);
		return "index";
	}
	/*
	 * 用户信息修改
	 */
	@PostMapping("/update")
	public String updateCustomer(Customer customer,HttpServletRequest req) {
		Long id = Long.valueOf(req.getParameter("id"));
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		String zip = req.getParameter("zip");
		String telephone = req.getParameter("telephone");
		String email = req.getParameter("email");
		Customer customer1 = (Customer) req.getSession().getAttribute("customer");
		customer1.setId(id);
		customer1.setName(name);
		customer1.setPassword(password);
		customer1.setAddress(address);
		customer1.setZip(zip);
		customer1.setTelephone(telephone);
		customer1.setEmail(email);
		return "user/userinfo";
	}
}
