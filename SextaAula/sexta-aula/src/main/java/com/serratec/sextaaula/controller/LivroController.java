package com.serratec.sextaaula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.serratec.sextaaula.model.Livro;
import com.serratec.sextaaula.model.Livro;
import com.serratec.sextaaula.service.LivroService;

@RestController
@RequestMapping("/livro")
public class LivroController {
	
	@Autowired
	LivroService service;
	
	@GetMapping
	public ResponseEntity<List<Livro>> getAll(@RequestParam(required=false) String parametro) {
		HttpHeaders header = new HttpHeaders();
		header.add("lista-livro", "Segue a lista de livros.");
		return new ResponseEntity<List<Livro>>(service.getAll(parametro), header, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getonebyId(@PathVariable Integer id) {
		HttpHeaders header = new HttpHeaders();
		header.add("livro-unico", "Segue o livro requisitado.");
		return new ResponseEntity<>(service.findbyID(id), header, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> post(@RequestBody Livro livro) {
		service.post(livro);
		HttpHeaders header = new HttpHeaders();
		header.add("adicao-livro", "O livro foi adicionado com sucesso.");
		return new ResponseEntity<>(header, HttpStatus.CREATED);
	}
	  @PutMapping("/{id}")
	    public ResponseEntity<?> putAtualizarLivro(@RequestBody Livro Livro, @PathVariable Integer id){
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("livro-update", "Livro atualizado com sucesso");
	        return new ResponseEntity<>(service.put(id, Livro), headers, HttpStatus.OK);
	    }
	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<?> deleteLivro(@PathVariable Integer id){
	    	service.delete(id);
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("livro-update", "Livro deletado com sucesso");
	        return new ResponseEntity<>(headers, HttpStatus.OK);
	    }

	
	

}
