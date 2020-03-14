package br.com.unifacisa.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.unifacisa.models.Pessoa;

public interface PessoaRepository extends MongoRepository<Pessoa,String>{

}
