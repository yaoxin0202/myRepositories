package com.briup.estore.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Cart;
import com.briup.estore.bean.Line;
import com.briup.estore.exception.ServiceException;
import com.briup.estore.service.BookService;

@Controller
@RequestMapping("/cart")
public class CartContoller {

	@Autowired
	private BookService bookService;

	// 显示购物车页面
	@GetMapping({ "/", "" })
	public String showCart() {
		return "user/cart";
	}

	/*
	 * 往购物车添加书籍
	 */
	@GetMapping("/add/{id}")
	public String addBook(@PathVariable("id") Long id,HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		Book book = bookService.findById(id);
		Line line = new Line();
		line.setBook(book);
		cart.add(line);
		return "index";
	}
	/*
	 * 删除购物车
	 */
	@GetMapping("/delete/{id}")
	public String delCart(@PathVariable("id") Long id,HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		cart.delete(id);
		return "user/cart";
	}
	/*
	 * 清除所有
	 */
	@GetMapping("/clear")
	public String delALLCart(HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		cart.clear();
		return "user/cart";
	}
	/*
	 * 保存修改购物车的数量
	 */
	@PostMapping("/saveupdate")
	public String updateCart(HttpSession session,HttpServletRequest req) {
		Cart cart = (Cart) session.getAttribute("cart");
		Long key = Long.valueOf(req.getParameter("id"));
		int num = Integer.valueOf(req.getParameter("num"));
		cart.update(key, num);
		return "user/cart";
	}

}
