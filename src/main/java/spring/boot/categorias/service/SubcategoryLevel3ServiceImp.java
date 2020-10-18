package spring.boot.categorias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.categorias.dao.ISubcategoryLevel3Dao;
import spring.boot.categorias.entity.SubcategoryLevel3;

@Service
public class SubcategoryLevel3ServiceImp implements ISubcategoryLevel3Service{
	
	@Autowired
	ISubcategoryLevel3Dao subcategoryLevel3Dao;

	@Override
	public List<SubcategoryLevel3> findAll() {
		// TODO Auto-generated method stub
		return (List<SubcategoryLevel3>) subcategoryLevel3Dao.findAll();
	}

	@Override
	public SubcategoryLevel3 findById(Long id) {
		// TODO Auto-generated method stub
		return subcategoryLevel3Dao.findById(id).orElse(null);
	}

	@Override
	public SubcategoryLevel3 save(SubcategoryLevel3 subcategoryLevel3) {
		// TODO Auto-generated method stub
		return subcategoryLevel3Dao.save(subcategoryLevel3);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		subcategoryLevel3Dao.deleteById(id);
		
	}
	


}
