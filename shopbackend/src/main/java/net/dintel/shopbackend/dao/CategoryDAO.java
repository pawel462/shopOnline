package net.dintel.shopbackend.dao;

import java.util.List;

import net.dintel.shopbackend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();

	Category get(int id);
	

}
