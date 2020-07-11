package com.briup.estore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.estore.bean.Book;

public interface BookDao extends JpaRepository<Book, Long> {
	

}
