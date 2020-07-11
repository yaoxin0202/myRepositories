package com.briup.estore.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.estore.bean.Admin;
import com.briup.estore.bean.Book;
import com.briup.estore.bean.Customer;
import com.briup.estore.exception.ServiceException;
import com.briup.estore.service.AdminService;
import com.briup.estore.service.BookService;
import com.briup.estore.service.CustomerService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private BookService bookService;
	@Autowired
	private CustomerService customerService;
	
	/*
	 * 实现登录
	 */
	@PostMapping("/login")
	public String loginAdmin(Admin admin,Model model,HttpSession session) throws ServiceException {
		String name = admin.getName();
		String password = admin.getPassword();
		Admin admin2 = adminService.login(name, password);
		session.setAttribute("admin", admin2);
		return "redirect:/admin/index";
	}
	/*
	 * 管理书籍
	 */
	@GetMapping("/index")
	public String findBook(HttpSession session) {
		List<Book> books = bookService.selBook();
		session.setAttribute("books", books);
		return "admin/index";
	}
	/*
	 * 用户管理
	 */
	@GetMapping("/userAll")
	public String userAll(Model model) {
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers", customers);
		return "/admin/userinfo";
	}
	/*
	 * 删除用户
	 */
	@GetMapping("/delete/{id}")
	public String deleteCustomerById(@PathVariable("id") Long id) {
		customerService.deleteById(id);
		return "redirect:/admin/userAll";
	}
	/*
	 * 修改用户
	 */
	@PostMapping("/saveupdate")
	public String updateCustomer(Customer customer, HttpServletRequest req) {
		Long id = Long.valueOf(req.getParameter("id"));
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		String telephone = req.getParameter("telephone");
		customer.setId(id);
		customer.setName(name);
		customer.setPassword(password);
		customer.setAddress(address);
		customer.setTelephone(telephone);
		customerService.save(customer);
		return "redirect:/admin/userAll";
	}
}
