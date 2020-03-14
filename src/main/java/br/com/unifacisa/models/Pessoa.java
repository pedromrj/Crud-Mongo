package br.com.unifacisa.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Pessoa {
	
	private String id;
	
	private String nome;
	
	private String cpf;
	
	@DBRef
	private List<Disciplina> materia;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Disciplina> getMateria() {
		return materia;
	}

	public void setMateria(List<Disciplina> materia) {
		this.materia = materia;
	}
	
}
