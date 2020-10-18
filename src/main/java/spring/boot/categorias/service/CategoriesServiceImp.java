package spring.boot.categorias.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.categorias.dao.ICategoriesDao;
import spring.boot.categorias.entity.Categories;



@Service
public class CategoriesServiceImp implements ICategoriesService {
	
	@Autowired
	private ICategoriesDao categoriesDao ;

	@Override
	public List<Categories> findAll() {
		// TODO Auto-generated method stub
		return (List<Categories>) categoriesDao.findAll();
	}

	@Override
	public Categories findById(Long id) {
		// TODO Auto-generated method stub
		Categories categories=categoriesDao.findById(id).orElse(null);
		return categories;
	}

	@Override
	public Categories save(Categories categories) {
		// TODO Auto-generated method stub
		return categoriesDao.save(categories);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		categoriesDao.deleteById(id);
		
	}
	

	

}
