package com.projeto.gen.sistema_escolar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



@Entity
public class Aluno {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @NotBlank
	@Size(min = 3)
	private String nome;
	  
    @NotBlank
    @Email
    @Column(unique = true)  
	private String email;
    
    
	private int idade;
	private double notaPrimeiroModulo;
	private  double notaSegundoModulo;
    private double media;
    
    @ManyToOne
    @JsonIgnore 
    @JoinColumn(name = "turma_id", nullable = false) 
    private Turma turma;
    
    
    
    public Aluno() {}
    
    
	public Aluno(Long id, @NotBlank @Size(min = 3) String nome, @NotBlank @Email String email, int idade,
			double notaPrimeiroModulo, double notaSegundoModulo, double media) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.idade = idade;
		this.notaPrimeiroModulo = notaPrimeiroModulo;
		this.notaSegundoModulo = notaSegundoModulo;
		this.media = media;
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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getIdade() {
		return idade;
	}



	public void setIdade(int idade) {
		this.idade = idade;
	}



	public double getNotaPrimeiroModulo() {
		return notaPrimeiroModulo;
	}



	public void setNotaPrimeiroModulo(double notaPrimeiroModulo) {
		this.notaPrimeiroModulo = notaPrimeiroModulo;
	}



	public double getNotaSegundoModulo() {
		return notaSegundoModulo;
	}



	public void setNotaSegundoModulo(double notaSegundoModulo) {
		this.notaSegundoModulo = notaSegundoModulo;
	}



	public double getMedia() {
		return media;
	}



	public void setMedia(double media) {
		this.media = media;
	}
	
    
    
}
