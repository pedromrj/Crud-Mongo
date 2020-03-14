package br.com.unifacisa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.com.unifacisa.models.Disciplina;
import br.com.unifacisa.models.Pessoa;
import br.com.unifacisa.repositories.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository repository;
	
	@Autowired
	private PessoaService service;
	
	public Disciplina save(String id, Disciplina obj) throws NotFoundException {
		Pessoa p = service.findOne(id);
		Disciplina d = repository.save(obj);
		p.getMateria().add(d);
		service.update(p);
		return d;
	}
	

}
