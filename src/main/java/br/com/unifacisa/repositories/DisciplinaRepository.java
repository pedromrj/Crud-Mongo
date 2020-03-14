package br.com.unifacisa.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.unifacisa.models.Disciplina;

public interface DisciplinaRepository extends MongoRepository<Disciplina, String> {

}
