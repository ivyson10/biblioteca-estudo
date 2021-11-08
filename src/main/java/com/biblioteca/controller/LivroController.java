package com.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.model.Livro;
import com.biblioteca.service.LivroService;

@RequestMapping("livros")
@RestController
public class LivroController {

	@Autowired
	private LivroService service;
	
	@PostMapping
	public ResponseEntity<Livro> save(@RequestBody Livro livro){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(livro));
	}
	
	@GetMapping
	public ResponseEntity<Livro> save(@RequestParam("id") Long id){
		return ResponseEntity.ok(service.findById(id));
	}
	
	@DeleteMapping
	public ResponseEntity<String> delete(@RequestParam("id") Long id){
		return ResponseEntity.ok(service.delete(id));
	}
	
	@PutMapping
	public ResponseEntity<Livro> put(@RequestParam("id") Long id, @RequestBody Livro livro ){
		return ResponseEntity.ok(service.put(id, livro));
	}
	
	@PatchMapping
	public ResponseEntity<Livro> patchTitulo(@RequestParam("id") Long id, @RequestParam("titulo") String titulo ){
		return ResponseEntity.ok(service.patchTitulo(id, titulo));
	}
	
	
	
}
