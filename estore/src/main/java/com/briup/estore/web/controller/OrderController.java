package com.briup.estore.web.controller;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.estore.bean.Cart;
import com.briup.estore.bean.Customer;
import com.briup.estore.bean.Line;
import com.briup.estore.bean.Order;
import com.briup.estore.exception.ServiceException;
import com.briup.estore.service.LineService;
import com.briup.estore.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private LineService lineService;
	
	
	/*
	 * 显示确认订单页面
	 */
	@GetMapping("/confirm")
	public String orderConfirm(Model model,HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customer");
		model.addAttribute("customer", customer);
		return "user/confirmOrder";
	}
	
	/*
	 * 显示当前用户的所有订单
	 */
	@GetMapping({"","/"})
	public String orderShow(HttpSession session,Model model) throws ServiceException {
		Customer customer = (Customer) session.getAttribute("customer");
		Long id = customer.getId();
		List<Order> orders = orderService.findByCustomerId(id);
		model.addAttribute("order", orders);
		return "user/order";
	}
	/*
	 * 提交订单
	 */
	@PostMapping("/submit")
	public String submit(Model model,HttpSession session,String payway) throws ServiceException {
		Customer customer = (Customer) session.getAttribute("customer");
		Cart cart = (Cart) session.getAttribute("cart");//获得用户购物车
		Order order = new Order();
		order.setCost(cart.getCost());
		order.setCustomer(customer);//用户和订单进行关联
		order.setPayway(payway);
		Date orderDate = new Date();
		order.setOrderDate(orderDate);
		orderService.saveOrder(order);//保存用户订单
		return "redirect:/customer/index";
	}
	/*
	 * 通过id删除订单
	 */
	@GetMapping("/delete/{id}")
	public String deleteId(@PathVariable("id") Long id) throws ServiceException {
		orderService.deleteOrder(id);
		return "redirect:/order";
	}
	/*
	 * 查看订单细明
	 */
	@GetMapping("/id/{id}")
	public String findOrder(@PathVariable("id") Long id,Model model) throws ServiceException {
		Order order = orderService.findById(id);
		//Collection<Line> lines = order.getLines();
		//System.out.println(order);
		model.addAttribute("order", order);
		return "user/orderinfo";
	}
	
	
	
	
}
