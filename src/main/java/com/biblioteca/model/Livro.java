package com.biblioteca.model;

import javax.persistence.Entity;

@Entity
public class Livro extends AbstractEntity {

	private String nome;
	
	private String autor;
	
	private Long paginas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Long getPaginas() {
		return paginas;
	}

	public void setPaginas(Long paginas) {
		this.paginas = paginas;
	}
	
}
