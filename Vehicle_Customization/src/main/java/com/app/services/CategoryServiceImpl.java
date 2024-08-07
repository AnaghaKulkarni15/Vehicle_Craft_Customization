package com.app.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Category;
import com.app.repositories.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired 
	private CategoryRepository categoryrepo ;

	@Override
	public Category addCategory(Category category) {
		return categoryrepo.save(category);
	}
	
}
