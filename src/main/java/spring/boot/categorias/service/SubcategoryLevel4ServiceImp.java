package spring.boot.categorias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.categorias.dao.ISubcategoryLevel4Dao;
import spring.boot.categorias.entity.SubcategoryLevel4;

@Service
public class SubcategoryLevel4ServiceImp implements ISubcategoryLevel4Service{
	
	@Autowired
	ISubcategoryLevel4Dao subcategoryLevel4Dao;

	@Override
	public List<SubcategoryLevel4> findAll() {
		// TODO Auto-generated method stub
		return (List<SubcategoryLevel4>) subcategoryLevel4Dao.findAll();
	}

	@Override
	public SubcategoryLevel4 findById(Long id) {
		// TODO Auto-generated method stub
		return subcategoryLevel4Dao.findById(id).orElse(null);
	}

	@Override
	public SubcategoryLevel4 save(SubcategoryLevel4 subcategoryLevel4) {
		// TODO Auto-generated method stubcliente
		return subcategoryLevel4Dao.save(subcategoryLevel4);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		subcategoryLevel4Dao.deleteById(id);
		
	}
	

}
