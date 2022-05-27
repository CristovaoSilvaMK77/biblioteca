package com.serratec.sextaaula.controller;

import java.util.List;

import com.serratec.sextaaula.model.Categoria;
import com.serratec.sextaaula.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService service;
    
    @GetMapping
    public ResponseEntity<List<Categoria>> getAll(@RequestParam (required=false) String campo){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Lista Categoria", "Lista retornada com sucesso");
        return new ResponseEntity<List<Categoria>>(service.findAll(campo), headers, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
        public ResponseEntity<Categoria> getOne(@PathVariable Integer id){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Categoria", "Categoria retornada com sucesso");
        return new ResponseEntity<Categoria>(service.findOne(id), headers, HttpStatus.ACCEPTED);
    }

    @PostMapping()
    public ResponseEntity<String> postCategoria(@RequestBody Categoria categoria) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Categoria", "Adicionada com sucesso");
        return new ResponseEntity<String>(service.addCategoria(categoria), headers, HttpStatus.CREATED);
    
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putAtualizarCategoria(@RequestBody Categoria categoria, @PathVariable Integer id){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Categoria", "Atualizada com sucesso");
        return new ResponseEntity<>(service.atualizarCategoria(id, categoria), headers, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategoria(@PathVariable Integer id){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Categoria", "Deletada com sucesso");
        return new ResponseEntity<>(service.deletarCategoria(id), headers, HttpStatus.OK);
    }



}
