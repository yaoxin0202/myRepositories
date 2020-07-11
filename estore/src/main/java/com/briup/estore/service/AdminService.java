package com.briup.estore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.briup.estore.bean.Admin;
import com.briup.estore.dao.AdminDao;
import com.briup.estore.exception.ServiceException;

@Transactional
@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	/*
	 * 用户登录
	 */
	public Admin login(String name,String password) throws ServiceException{
		Admin admin = adminDao.findByName(name);
		if(admin!=null) {
			if(password.equals(admin.getPassword())) {
				return admin;
			}else {
				return null;
			}
		}
		return null;
	}
}
