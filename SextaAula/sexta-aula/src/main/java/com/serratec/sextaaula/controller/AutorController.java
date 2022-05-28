package com.serratec.sextaaula.controller;

import java.util.List;

import com.serratec.sextaaula.model.Autor;
import com.serratec.sextaaula.service.AutorService;

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
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    AutorService service;
    
    @GetMapping
    public ResponseEntity<List<Autor>> getAll(@RequestParam (required=false) String campo){
        HttpHeaders headers = new HttpHeaders();
        headers.add("autor-list", "Lista de autores retornada com sucesso");
        return new ResponseEntity<List<Autor>>(service.getAll(campo), headers, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
        public ResponseEntity<Autor> getOne(@PathVariable Integer id){
        HttpHeaders headers = new HttpHeaders();
        headers.add("get-one-autor", "Autor retornado por id com sucesso");
        return new ResponseEntity<Autor>(service.findbyID(id), headers, HttpStatus.ACCEPTED);
    }

    @PostMapping()
    public ResponseEntity<String> postAutor(@RequestBody Autor Autor) {
    	service.post(Autor);
        HttpHeaders headers = new HttpHeaders();
        headers.add("adicionar-autor", "Autor adicionado com sucesso");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putAtualizarAutor(@RequestBody Autor Autor, @PathVariable Integer id){
        HttpHeaders headers = new HttpHeaders();
        headers.add("update-autor", "Autor atualizado com sucesso");
        return new ResponseEntity<>(service.put(id, Autor), headers, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAutor(@PathVariable Integer id){
    	service.delete(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("delete-autor", "Autor deletado com sucesso");
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }



}
