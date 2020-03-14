package br.com.unifacisa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.com.unifacisa.models.Disciplina;
import br.com.unifacisa.models.Disciplina;
import br.com.unifacisa.repositories.DisciplinaRepository;
import br.com.unifacisa.repositories.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository repository;
	
	@Autowired
	private DisciplinaService service;
		
	public Disciplina save(Disciplina obj) {
		return repository.insert(obj);
	}
	
	public Disciplina findOne(String id) {
		return repository.findById(id).get();
	}
	
	public List<Disciplina> findAll() {
		return repository.findAll();
	}
	
	public void delete(String id) {
		repository.deleteById(id);
	}
	
	public Disciplina update(Disciplina obj) throws NotFoundException {
		if (repository.existsById(obj.getId())) {
			return repository.save(obj);
		} else {
			throw new NotFoundException();
		}
	}

}
