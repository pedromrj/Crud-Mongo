package br.com.unifacisa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.com.unifacisa.models.Pessoa;
import br.com.unifacisa.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;
	
	public Pessoa save(Pessoa obj) {
		return repository.insert(obj);
	}
	
	public Pessoa findOne(String id) {
		return repository.findById(id).get();
	}
	
	public List<Pessoa> findAll() {
		return repository.findAll();
	}
	
	public void delete(String id) {
		repository.deleteById(id);
	}
	
	public Pessoa update(Pessoa obj) throws NotFoundException {
		if (repository.existsById(obj.getId())) {
			return repository.save(obj);
		} else {
			throw new NotFoundException();
		}
	}

}
