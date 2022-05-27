package com.serratec.sextaaula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serratec.sextaaula.model.Livro;

	
public interface LivroRepository extends JpaRepository<Livro, Integer> {

}
