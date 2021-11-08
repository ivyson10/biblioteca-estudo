package com.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.model.Livro;
import com.biblioteca.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;
	
	
	public Livro salvar(Livro livro) {
		return repository.save(livro);
	}
	
	public Livro findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("error"));
	}
	
	public String delete(Long id) {
		var livro = findById(id);
		repository.delete(livro);
		return "Livro deletado com sucesso";
	}
	
	
	public Livro put(Long id, Livro livro) {
		var old = findById(id);
		old.setAutor(livro.getAutor());
		old.setNome(livro.getNome());
		old.setPaginas(livro.getPaginas());		
		return repository.save(old);
	}
	
	public Livro patchTitulo(Long id, String titulo) {
		var old = findById(id);
		old.setNome(titulo);
		return repository.save(old);
	}
	
}
