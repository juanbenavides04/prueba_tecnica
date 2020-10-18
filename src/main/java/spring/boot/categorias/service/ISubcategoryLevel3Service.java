package spring.boot.categorias.service;

import java.util.List;

import spring.boot.categorias.entity.SubcategoryLevel3;

public interface ISubcategoryLevel3Service {
	
	public List<SubcategoryLevel3> findAll();
	
	public SubcategoryLevel3 findById(Long id);
	
	public SubcategoryLevel3 save(SubcategoryLevel3 subcategoryLevel3);
	
	public void delete(Long id); 

}
