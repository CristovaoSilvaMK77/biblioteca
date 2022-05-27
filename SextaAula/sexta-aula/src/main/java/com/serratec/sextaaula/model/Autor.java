package com.serratec.sextaaula.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String nome;
    
    @ManyToMany(mappedBy = "autores")
    private Set<Livro> livros;


    public Autor() {
    }


    public Autor(String nome, Set<Livro> livros) {
        this.nome = nome;
        this.livros = livros;
    }


    public Integer getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Livro> getLivros() {
        return this.livros;
    }

    public void setLivros(Set<Livro> livros) {
        this.livros = livros;
    }
    



}
