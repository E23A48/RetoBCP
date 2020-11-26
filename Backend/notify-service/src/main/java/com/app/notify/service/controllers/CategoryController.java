package com.app.notify.service.controllers;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.notify.service.models.entity.Category;
import com.app.notify.service.models.service.ICategoryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/notifications/category")
@Slf4j
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryService;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/all")
	public List<Category> all() {
		return categoryService.findAll();
	}

	
	@GetMapping("/single/id")
	public Category detail(@PathVariable Long id) {
		return categoryService.findById(id);
	}
	
	@PostMapping("/add")
	public Category detail(@RequestBody Category category) {

		Date date = Date.from(Instant.now());
		long time = date.getTime();
		Timestamp timestamp = new Timestamp(time);
		category.setCreadtedAt(timestamp);
		
		return categoryService.save(category);
	}
	
	
}
