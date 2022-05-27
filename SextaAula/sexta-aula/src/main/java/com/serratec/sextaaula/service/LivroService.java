package com.serratec.sextaaula.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.serratec.sextaaula.model.Livro;
import com.serratec.sextaaula.repository.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	LivroRepository repositorio;
	
	public List<Livro> getAll(String parametro){
		if (parametro == null) {
			return repositorio.findAll();
		}
		Sort sort = Sort.by(parametro);
		return repositorio.findAll(sort);
	}
	
	public Livro findbyID(Integer id) {
		Optional<Livro> optional = repositorio.findById(id);
	return optional.get();
	}
	
	public void post(Livro livro) {
		repositorio.save(livro);
	}
	
	public Livro put(Integer id, Livro livro) {
		Optional<Livro> optional = repositorio.findById(id);
		Livro oldLivro = optional.get();
		if (livro.getNome() != null) {
			oldLivro.setNome(livro.getNome());
		}
		if (livro.getCategoriaId() != null) {
			oldLivro.setCategoriaId(livro.getCategoriaId());
		}
		if (livro.getAutores() != null) {
			oldLivro.setAutores(livro.getAutores());
		}
		return oldLivro;
	}
	
	public void delete(Integer id) {
		repositorio.deleteById(id);
	}

}
