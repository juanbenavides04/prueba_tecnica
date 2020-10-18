package spring.boot.categorias.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import spring.boot.categorias.entity.Categories;


public interface ICategoriesDao extends CrudRepository<Categories, Long>{

}
