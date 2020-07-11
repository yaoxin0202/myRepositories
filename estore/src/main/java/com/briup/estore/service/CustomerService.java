package com.briup.estore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.briup.estore.bean.Customer;
import com.briup.estore.dao.CustomerDao;
import com.briup.estore.exception.ServiceException;

@Transactional
@Service
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;
	/*
	 * 用户注册
	 */
	public void register(Customer customer) throws ServiceException{
		if(customerDao.findByName(customer.getName()) ==null) {
			customerDao.save(customer);
		}
	}
	/*
	 * 用户登录
	 */
	public Customer login(String name,String password) throws ServiceException{
		Customer customer = customerDao.findByName(name);
		if(name.equals(customer.getName())) {
			if(password.equals(customer.getPassword())) {
				return customer;
			}
		}
		return null;
	}
	/*
	 * 查询所有用户
	 */
	public List<Customer> findAll(){
		List<Customer> customers = customerDao.findAll();
		return customers;
	}
	/*
	 * 删除用户
	 */
	public void deleteById(Long id) {
		customerDao.deleteById(id);
	}
	/*
	 * 保存用户
	 */
	public void save(Customer customer) {
		customerDao.save(customer);
	}
}
