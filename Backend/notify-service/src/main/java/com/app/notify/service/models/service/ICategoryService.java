package com.app.notify.service.models.service;

import java.util.List;
import com.app.notify.service.models.entity.Category;

public interface ICategoryService {
	
	public List<Category> findAll();
	public Category findById(Long Id);
	public Category save(Category category);
	
}
