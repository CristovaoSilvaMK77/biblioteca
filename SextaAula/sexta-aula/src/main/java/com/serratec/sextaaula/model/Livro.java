package com.serratec.sextaaula.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Livro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Categoria categoriaId;

    @ManyToMany
    @JoinTable(name="livro_autor", 
        joinColumns = @JoinColumn(name = "livro_fk", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name= "autor_fk", referencedColumnName = "id"))
    private Set<Autor> autores;



    public Livro() {
    }


    public Livro( String nome, Categoria categoriaId, Set<Autor> autores) {
        this.nome = nome;
        this.categoriaId = categoriaId;
        this.autores = autores;
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

    public Categoria getCategoriaId() {
        return this.categoriaId;
    }

    public void setCategoriaId(Categoria categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Set<Autor> getAutores() {
        return this.autores;
    }

    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }

    
}
