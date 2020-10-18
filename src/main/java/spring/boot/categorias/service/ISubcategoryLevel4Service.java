package spring.boot.categorias.service;

import java.util.List;

import spring.boot.categorias.entity.SubcategoryLevel4;

public interface ISubcategoryLevel4Service {
	
	public List<SubcategoryLevel4> findAll();
	
	public SubcategoryLevel4 findById(Long id);
	
	public SubcategoryLevel4 save(SubcategoryLevel4 subcategoryLevel4);
	
	public void delete(Long id); 

}
