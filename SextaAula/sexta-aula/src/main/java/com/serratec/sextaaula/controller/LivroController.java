package com.serratec.sextaaula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
