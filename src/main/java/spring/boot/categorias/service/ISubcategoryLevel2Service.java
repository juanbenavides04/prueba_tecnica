package spring.boot.categorias.service;

import java.util.List;

import spring.boot.categorias.entity.SubcategoryLevel2;

public interface ISubcategoryLevel2Service {
	
	public List<SubcategoryLevel2> findAll();
	
	public SubcategoryLevel2 findById(Long id);
	
	public SubcategoryLevel2 save(SubcategoryLevel2 subcategoryLevel2);
	
	public void delete(Long id); 

}
