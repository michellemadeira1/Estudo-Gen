package com.projeto.gen.sistema_escolar.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único da turma")
    private Long id;

    @NotBlank
    @Size(min = 3)
    @Schema(description = "Nome da turma", example = "Turma de Matemática")
    private String nome;

    @NotBlank
    @Schema(description = "Nome do instrutor", example = "Professor Carlos")
    private String instrutor;
    
    @NotBlank
    @Schema(description = "Horário da turma", example = "09:00:00")
    private LocalTime horario;

    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("turma") 
    @Schema(description = "Lista de alunos matriculados na turma")
    private List<Aluno> alunos;
    
    
    public Turma() {}
    
  
   
    
    public Turma(Long id, @NotBlank @Size(min = 3) String nome, @NotBlank String instrutor, @NotBlank LocalTime horario,
			List<Aluno> alunos) {
		super();
		this.id = id;
		this.nome = nome;
		this.instrutor = instrutor;
		this.horario = horario;
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


	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}


	
}
