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


import spring.boot.categorias.entity.SubcategoryLevel4;
import spring.boot.categorias.service.SubcategoryLevel4ServiceImp;


@RestController
@RequestMapping("/api")
public class SubcategoryLevel4RestController {
	
	@Autowired
	SubcategoryLevel4ServiceImp subcategoryLevel4ServiceImp;
	
	@GetMapping("/subcategoryLevel4")
	public List<SubcategoryLevel4> index(){
		
		return subcategoryLevel4ServiceImp.findAll();
	}
	
	@GetMapping("/subcategoryLevel4/{id}")	
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		SubcategoryLevel4 subcategoryLevel4=null;
		Map<String, Object> response=new HashMap<>();		
		
		try {
			subcategoryLevel4=subcategoryLevel4ServiceImp.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos.");
		}
		
		if(subcategoryLevel4==null) {
			response.put("mensaje","La subcategoryLevel4 ID : ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		
		return new ResponseEntity<SubcategoryLevel4>(subcategoryLevel4,HttpStatus.OK);
	}
	
	@PostMapping("/subcategoryLevel4")
	public ResponseEntity<?> create(SubcategoryLevel4 subcategoryLevel4) {
		
		SubcategoryLevel4 subcategoryLevel4New=null;
		Map<String, Object> response=new HashMap<>();
				
		try {
			subcategoryLevel4New=subcategoryLevel4ServiceImp.save(subcategoryLevel4);
			response.put("mensaje","La SubcategoryLevel4 ha sido creado con éxito!");
			response.put("SubcategoryLevel4",subcategoryLevel4New);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos.");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}		

		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	@PutMapping("/subcategoryLevel4")
	public ResponseEntity<?> update( SubcategoryLevel4 subcategoryLevel4) {
		
		SubcategoryLevel4 subcategoryLevel4Actual=subcategoryLevel4ServiceImp.findById(subcategoryLevel4.getId());
		SubcategoryLevel4 subcategoryLevel4Upload=null;
		
		Map<String, Object> response=new HashMap<>();
		
		if(subcategoryLevel4Actual==null) {
			response.put("mensaje","El subcategoryLevel4Actual ID : ".concat(subcategoryLevel4Actual.getId().toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}		
		
		try {
			subcategoryLevel4Upload=subcategoryLevel4ServiceImp.save(subcategoryLevel4);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la modificacion en la base de datos.");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","La SubcategoryLevel4 ha sido actualizado con éxito!");
	
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/subcategoryLevel3/{id}")	
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response=new HashMap<>();
		
		try {
			SubcategoryLevel4 subcategoryLevel4=subcategoryLevel4ServiceImp.findById(id);	
					
			subcategoryLevel4ServiceImp.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar la SubcategoryLevel3 en la base de datos.");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		
		response.put("mensaje","la SubcategoryLevel3 ha sido eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}	

}
