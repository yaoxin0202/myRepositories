package com.briup.estore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.estore.bean.Book;
import com.briup.estore.dao.BookDao;

@Service
public class BookService {
	
	 @Autowired 
	 private BookDao bookDao; 
	 /*
	  * 查看所有书籍
	  */
	 public List<Book> selBook(){ 
		List<Book> list = bookDao.findAll();
	 	return list;
	}
	 /*
	  * 向购物车添加书籍
	  */
	 public Book findById(Long id) {
		 Book book = bookDao.findById(id).get();
		 return book;

	 }
	 /*
	  * 通过id删除书籍
	  */
	 public void deleteById(Long id) {
		 bookDao.deleteById(id);
	 }
	 /*
	  * 修改书籍价格
	  */
	public void save(Book book) {
		bookDao.save(book);
	}
		
}
