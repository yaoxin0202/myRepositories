package com.briup.estore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.estore.bean.Line;
import com.briup.estore.dao.LineDao;

@Service
public class LineService {

	@Autowired
	private LineDao lineDao;
	
	public List<Line> findAll() {
		List<Line> list = lineDao.findAll();
		return list;
	}
	
}
