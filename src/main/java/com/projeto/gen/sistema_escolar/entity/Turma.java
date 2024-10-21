package com.projeto.gen.sistema_escolar.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3)
    private String nome;

    @NotBlank
    private String instrutor;

    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("turma") 
    private List<Aluno> alunos;
    
    
    public Turma() {}
    
  
    public Turma(Long id, @NotBlank @Size(min = 3) String nome, @NotBlank String instrutor, List<Aluno> alunos) {
        this.id = id;
        this.nome = nome;
        this.instrutor = instrutor;
        this.alunos = alunos;
    }

    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(String instrutor) {
        this.instrutor = instrutor;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
