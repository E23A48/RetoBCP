package com.app.notify.service.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.notify.service.models.dao.CategoryDao;
import com.app.notify.service.models.entity.Category;

@Service
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Category> findAll() {
		return (List<Category>) categoryDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Category findById(Long Id) {
		return categoryDao.findById(Id).orElse(null);
	}
	
	@Override
	@Transactional(readOnly = false)
	public Category save(Category category) {
		Category cat = categoryDao.save(category);
		
        return cat;
	}
	
}
