package com.serratec.sextaaula.service;

import java.util.List;
import java.util.Optional;

import com.serratec.sextaaula.model.Categoria;
import com.serratec.sextaaula.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    
    @Autowired
    CategoriaRepository categoria;

    public List<Categoria> findAll(String campo){
        if(campo == null){
            return categoria.findAll();
        }
        Sort sort = Sort.by(campo);

        return categoria.findAll(sort);
    }

    public Categoria findOne(Integer id){
        Optional<Categoria> optional = categoria.findById(id);
        
        return optional.get();
    }

    public String addCategoria(Categoria categoriaRecebida){
        
        categoria.save(categoriaRecebida);
        return "Categoria adicionada com Sucesso!";

    }

    public Categoria atualizarCategoria(Integer id, Categoria catNova){
        Optional<Categoria> optional = categoria.findById(id);
        Categoria oldCategoria = optional.get();
        
        if(catNova.getNome() != null && !catNova.getNome().equals("")){
            oldCategoria.setNome(catNova.getNome());
        }if(catNova.getDescricao() != null && !catNova.getDescricao().equals("")){
            oldCategoria.setDescricao(catNova.getDescricao());
        }
        categoria.save(oldCategoria);
        return oldCategoria;
    }

    public String deletarCategoria(Integer id){
        categoria.deleteById(id);
        return "Categoria deletada com Sucesso";
    }

}
