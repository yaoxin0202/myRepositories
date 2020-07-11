package com.briup.estore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.estore.bean.Admin;

public interface AdminDao extends JpaRepository<Admin, Long>{
	
	Admin findByNameAndPassword(String name, String password);

	Admin findByName(String name);
}
