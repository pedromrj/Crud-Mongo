package br.com.unifacisa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.unifacisa.models.Disciplina;
import br.com.unifacisa.services.DisciplinaService;

@Controller
@RequestMapping("/disciplina")
public class DisciplinaController {

	@Autowired
	private DisciplinaService service;
	
	@PostMapping
	public ResponseEntity<Disciplina> save(@RequestBody Disciplina obj) {
		return new ResponseEntity<Disciplina>(service.save(obj), HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<Disciplina>> findAll() {
		return new ResponseEntity<List<Disciplina>>(service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Disciplina> findOne(@PathVariable String id) {
		return new ResponseEntity<Disciplina>(service.findOne(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Disciplina> update(@PathVariable String id, @RequestBody Disciplina obj) throws NotFoundException {
		obj.setId(id);
		return new ResponseEntity<Disciplina>(service.update(obj), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		service.delete(id);
		ResponseEntity.ok().build();
	}

}
