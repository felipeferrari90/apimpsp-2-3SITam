package br.com.mpsp.controller;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mpsp.model.ImportantModel;
import br.com.mpsp.repository.ImportantRepository;


@RestController
@RequestMapping("/important")
public class ImportantController {
	
	@Autowired
	ImportantRepository importantRepository;
	

	@GetMapping()
	public ResponseEntity<List<ImportantModel>> findAll(Model model){
	    List<ImportantModel> importants = importantRepository.findAll();
		return ResponseEntity.ok(importants);
	}
	
	@PostMapping()
	public ResponseEntity save(@RequestBody @Valid ImportantModel importantModel,BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		
		ImportantModel important = importantRepository.save(importantModel);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(important.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@PutMapping(value = "{id}")
	public ResponseEntity update(@PathVariable("id") int id, @RequestBody @Valid ImportantModel importantModel, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		
		importantModel.setId(id);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity deleteById(@PathVariable("id") int id) {
		importantRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	

}
