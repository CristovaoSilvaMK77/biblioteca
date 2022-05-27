package com.serratec.sextaaula.repository;

import com.serratec.sextaaula.model.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    
    
}
