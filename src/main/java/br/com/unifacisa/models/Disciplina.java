package br.com.unifacisa.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Disciplina {

	private String id;
	
	private String nome;
	
	private String professor;

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

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}
	
	
	
}
