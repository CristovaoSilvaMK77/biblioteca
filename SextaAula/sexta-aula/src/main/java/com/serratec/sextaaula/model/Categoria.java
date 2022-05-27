package com.serratec.sextaaula.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categoria {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "categoriaId")
    private List<Livro> livros;

    private String nome;
    private String descricao;



    public Categoria() {
    }

    public Categoria( List<Livro> livros, String nome, String descricao) {
        this.livros = livros;
        this.nome = nome;
        this.descricao = descricao;
    }


    public Integer getId() {
        return this.id;
    }


    public List<Livro> getLivros() {
        return this.livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    

   


}
