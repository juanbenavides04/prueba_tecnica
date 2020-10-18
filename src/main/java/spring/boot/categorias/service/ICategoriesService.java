package spring.boot.categorias.service;
import java.util.List;

import spring.boot.categorias.entity.Categories;

public interface ICategoriesService {
	
	public List<Categories> findAll();
		
	public Categories findById(Long id);
	
	public Categories save(Categories categories);
	
	public void delete(Long id); 
	

}
