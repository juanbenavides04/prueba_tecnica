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



import spring.boot.categorias.entity.SubcategoryLevel2;
import spring.boot.categorias.service.SubcategoryLevel2ServiceImp;


@RestController
@RequestMapping("/api")
public class SubcategoryLevel2RestController {
	
	@Autowired
	SubcategoryLevel2ServiceImp subcategoryLevel2ServiceImp;
	
	@GetMapping("/subcategoryLevel2")
	public List<SubcategoryLevel2> index(){
		
		return subcategoryLevel2ServiceImp.findAll();
	}
	
	@GetMapping("/subcategoryLevel2/{id}")	
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		SubcategoryLevel2 subcategoryLevel2=null;
		Map<String, Object> response=new HashMap<>();		
		
		try {
			subcategoryLevel2=subcategoryLevel2ServiceImp.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos.");
		}
		
		if(subcategoryLevel2==null) {
			response.put("mensaje","La subcategoryLevel2 ID : ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		
		return new ResponseEntity<SubcategoryLevel2>(subcategoryLevel2,HttpStatus.OK);
	}
	
	@PostMapping("/subcategoryLevel2")
	public ResponseEntity<?> create(SubcategoryLevel2 subcategoryLevel2) {
		
		SubcategoryLevel2 subcategoryLevel2New=null;
		Map<String, Object> response=new HashMap<>();
				
		try {
			subcategoryLevel2New=subcategoryLevel2ServiceImp.save(subcategoryLevel2);
			response.put("mensaje","La SubcategoryLevel2 ha sido creado con éxito!");
			response.put("SubcategoryLevel2",subcategoryLevel2New);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos.");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}		

		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	@PutMapping("/subcategoryLevel2")
	public ResponseEntity<?> update( SubcategoryLevel2 subcategoryLevel2) {
		
		SubcategoryLevel2 subcategoryLevel2Actual=subcategoryLevel2ServiceImp.findById(subcategoryLevel2.getId());
		SubcategoryLevel2 subcategoryLevel2Upload=null;
		
		Map<String, Object> response=new HashMap<>();
		
		if(subcategoryLevel2Actual==null) {
			response.put("mensaje","El SubcategoryLevel2 ID : ".concat(subcategoryLevel2Actual.getId().toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}		
		
		try {
			subcategoryLevel2Upload=subcategoryLevel2ServiceImp.save(subcategoryLevel2);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la modificacion en la base de datos.");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","La SubcategoryLevel2 ha sido actualizado con éxito!");
	
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/subcategoryLevel2/{id}")	
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response=new HashMap<>();
		
		try {
			SubcategoryLevel2 subcategoryLevel2=subcategoryLevel2ServiceImp.findById(id);	
					
			subcategoryLevel2ServiceImp.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar la SubcategoryLevel2 en la base de datos.");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		
		response.put("mensaje","la SubcategoryLevel2 ha sido eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}	

}
