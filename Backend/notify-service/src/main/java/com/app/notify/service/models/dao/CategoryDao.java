package com.app.notify.service.models.dao;

import com.app.notify.service.models.entity.Category;

import org.springframework.data.repository.CrudRepository;


public interface CategoryDao extends CrudRepository<Category, Long> {

}