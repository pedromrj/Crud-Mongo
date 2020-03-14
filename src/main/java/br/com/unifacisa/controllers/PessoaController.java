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
import br.com.unifacisa.models.Pessoa;
import br.com.unifacisa.services.PessoaService;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService service;
	
	@PostMapping
	public ResponseEntity<Pessoa> save(@RequestBody Pessoa obj) {
		return new ResponseEntity<Pessoa>(service.save(obj), HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<Pessoa>> findAll() {
		return new ResponseEntity<List<Pessoa>>(service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> findOne(@PathVariable String id) {
		return new ResponseEntity<Pessoa>(service.findOne(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> update(@PathVariable String id, @RequestBody Pessoa obj) throws NotFoundException {
		obj.setId(id);
		return new ResponseEntity<Pessoa>(service.update(obj), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		service.delete(id);
		ResponseEntity.ok().build();
	}
	
	@PostMapping("/{id}/disciplina")
	public ResponseEntity<Disciplina> save(@PathVariable String id, @RequestBody Disciplina obj) throws NotFoundException {
		return new ResponseEntity<Disciplina>(service.save(id,obj), HttpStatus.CREATED);
	}

}
