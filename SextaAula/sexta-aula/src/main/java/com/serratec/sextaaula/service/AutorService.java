package com.serratec.sextaaula.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.serratec.sextaaula.model.Autor;
import com.serratec.sextaaula.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	AutorRepository repositorio;
	
	public List<Autor> getAll(String parametro){
		if (parametro == null) {
			return repositorio.findAll();
		}
		Sort sort = Sort.by(parametro);
		return repositorio.findAll(sort);
	}
	
	public Autor findbyID(Integer id) {
		Optional<Autor> optional = repositorio.findById(id);
	return optional.get();
	}
	
	public void post(Autor Autor) {
		repositorio.save(Autor);
	}
	
	public Autor put(Integer id, Autor autor) {
		Optional<Autor> optional = repositorio.findById(id);
		Autor oldAutor = optional.get();
		if (autor.getNome() != null) {
			oldAutor.setNome(autor.getNome());
		}
		if (autor.getLivros() != null) {
			oldAutor.setLivros(autor.getLivros());
		}
		return oldAutor;
	}
	
	public void delete(Integer id) {
		repositorio.deleteById(id);
	}

}


