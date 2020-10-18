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

import spring.boot.categorias.entity.SubcategoryLevel3;
import spring.boot.categorias.service.SubcategoryLevel3ServiceImp;


@RestController
@RequestMapping("/api")
public class SubcategoryLevel3RestController {
	
	@Autowired
	SubcategoryLevel3ServiceImp subcategoryLevel3ServiceImp;
	
	@GetMapping("/subcategoryLevel3")
	public List<SubcategoryLevel3> index(){
		
		return subcategoryLevel3ServiceImp.findAll();
	}
	
	@GetMapping("/subcategoryLevel3/{id}")	
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		SubcategoryLevel3 subcategoryLevel3=null;
		Map<String, Object> response=new HashMap<>();		
		
		try {
			subcategoryLevel3=subcategoryLevel3ServiceImp.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos.");
		}
		
		if(subcategoryLevel3==null) {
			response.put("mensaje","La subcategoryLevel3 ID : ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		
		return new ResponseEntity<SubcategoryLevel3>(subcategoryLevel3,HttpStatus.OK);
	}
	
	@PostMapping("/subcategoryLevel3")
	public ResponseEntity<?> create(SubcategoryLevel3 subcategoryLevel3) {
		
		SubcategoryLevel3 subcategoryLevel3New=null;
		Map<String, Object> response=new HashMap<>();
				
		try {
			subcategoryLevel3New=subcategoryLevel3ServiceImp.save(subcategoryLevel3);
			response.put("mensaje","La SubcategoryLevel3 ha sido creado con éxito!");
			response.put("SubcategoryLevel3",subcategoryLevel3New);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos.");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}		

		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	@PutMapping("/subcategoryLevel3")
	public ResponseEntity<?> update( SubcategoryLevel3 subcategoryLevel3) {
		
		SubcategoryLevel3 subcategoryLevel3Actual=subcategoryLevel3ServiceImp.findById(subcategoryLevel3.getId());
		SubcategoryLevel3 subcategoryLevel3Upload=null;
		
		Map<String, Object> response=new HashMap<>();
		
		if(subcategoryLevel3Actual==null) {
			response.put("mensaje","El subcategoryLevel3Actual ID : ".concat(subcategoryLevel3Actual.getId().toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}		
		
		try {
			subcategoryLevel3Upload=subcategoryLevel3ServiceImp.save(subcategoryLevel3);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la modificacion en la base de datos.");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","La SubcategoryLevel3 ha sido actualizado con éxito!");
	
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/subcategoryLevel3/{id}")	
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response=new HashMap<>();
		
		try {
			SubcategoryLevel3 subcategoryLevel3=subcategoryLevel3ServiceImp.findById(id);	
					
			subcategoryLevel3ServiceImp.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar la SubcategoryLevel3 en la base de datos.");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		
		response.put("mensaje","la SubcategoryLevel3 ha sido eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}	

}
