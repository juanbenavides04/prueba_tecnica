package spring.boot.categorias.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.categorias.entity.Categories;
import spring.boot.categorias.service.CategoriesServiceImp;


@RestController
@RequestMapping("/api")
public class CategoriesRestController {
	
	@Autowired
	CategoriesServiceImp categoriesServiceImp;
	
	@GetMapping("/categories")
	public List<Categories> index(){
		
		return categoriesServiceImp.findAll();
	}
	
	@GetMapping("/categories/{id}")	
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Categories categories=null;
		Map<String, Object> response=new HashMap<>();		
		
		try {
			categories=categoriesServiceImp.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos.");
		}
		
		if(categories==null) {
			response.put("mensaje","El categories ID : ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		
		return new ResponseEntity<Categories>(categories,HttpStatus.OK);	
	}
	
	@PostMapping("/categories")
	public ResponseEntity<?> create(Categories categories) {
		
		Categories categoriesNew=null;
		Map<String, Object> response=new HashMap<>();
			
		
		try {
			categoriesNew=categoriesServiceImp.save(categories);
			response.put("mensaje","El categories ha sido creado con éxito!");
			response.put("categories",categoriesNew);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos.");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}		

		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	@PutMapping("/categories")
	public ResponseEntity<?> update( Categories categories) {
		
		Categories categoriesActual=categoriesServiceImp.findById(categories.getId());
		Categories categoriesUpload=null;
		
		Map<String, Object> response=new HashMap<>();
		
		
		if(categoriesActual==null) {
			response.put("mensaje","El categories ID : ".concat(categoriesActual.getId().toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}		
		
		try {
			categoriesUpload=categoriesServiceImp.save(categories);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la actualizado en la base de datos.");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","El categories ha sido actualizado con éxito!");
	
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/categories/{id}")	
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response=new HashMap<>();
		
		try {
			Categories categories=categoriesServiceImp.findById(id);	
					
			categoriesServiceImp.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el categories en la base de datos.");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		
		response.put("mensaje","El categories ha sido eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}	

}
