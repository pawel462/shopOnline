package net.dintel.shopbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.dintel.shopbackend.dao.CategoryDAO;
import net.dintel.shopbackend.dto.Category;


@Repository("categoryDAO")
public class CategoryDAOimpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {

		Category category = new Category();

		// dodawanie category
		category.setId(1);
		category.setName("Czujniki");
		category.setDescription("Czujniki bezprzewodowe Fibaro");
		category.setImageURL("fibaro.png");

		categories.add(category);

		// druga kategoria
		category = new Category();
		category.setId(2);
		category.setName("Centrale");
		category.setDescription("Centrale Fibaro");
		category.setImageURL("fibaro2.png");

		categories.add(category);

		// trzecia kategoria
		category = new Category();
		category.setId(3);
		category.setName("Moduly");
		category.setDescription("Moduly wykonawcze Fibaro");
		category.setImageURL("fibaro3.png");

		categories.add(category);

	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		
	//enchanced for loop
		
		for(Category category: categories){
			if(category.getId() == id) return category;
		}
		return null;
	}

}
