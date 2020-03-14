package br.com.unifacisa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.unifacisa.models.Disciplina;
import br.com.unifacisa.services.DisciplinaService;

@Controller
@RequestMapping("/pessoa")
public class DisciplinaController {

	@Autowired
	private DisciplinaService service;
	
	@PostMapping("/{id}/disciplina")
	public ResponseEntity<Disciplina> save(@PathVariable String id, @RequestBody Disciplina obj) throws NotFoundException {
		return new ResponseEntity<Disciplina>(service.save(id,obj), HttpStatus.CREATED);
	}

}
