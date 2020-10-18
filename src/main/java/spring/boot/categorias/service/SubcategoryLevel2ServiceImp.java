package spring.boot.categorias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.categorias.dao.ISubcategoryLevel2Dao;
import spring.boot.categorias.entity.SubcategoryLevel2;

@Service
public class SubcategoryLevel2ServiceImp implements ISubcategoryLevel2Service {
	
	@Autowired
	ISubcategoryLevel2Dao categoryLevel2Dao;

	@Override
	public List<SubcategoryLevel2> findAll() {
		// TODO Auto-generated method stub
		return (List<SubcategoryLevel2>) categoryLevel2Dao.findAll();
	}

	@Override
	public SubcategoryLevel2 findById(Long id) {
		// TODO Auto-generated method stub
		return categoryLevel2Dao.findById(id).orElse(null);
	}

	@Override
	public SubcategoryLevel2 save(SubcategoryLevel2 subcategoryLevel2) {
		// TODO Auto-generated method stub
		return categoryLevel2Dao.save(subcategoryLevel2);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		categoryLevel2Dao.deleteById(id);
	}
	


}
