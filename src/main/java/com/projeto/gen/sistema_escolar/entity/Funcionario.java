package com.projeto.gen.sistema_escolar.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único do funcionário")
    private Long id;

    @NotBlank
    @Size(min = 3)
    @Schema(description = "Nome do funcionário", example = "Maria Oliveira")
    private String nome;

    @NotBlank
    @Email
    @Column(unique = true)
    @Schema(description = "Email do funcionário", example = "maria.oliveira@example.com")
    private String email;

    @NotBlank
    @Size(min = 6)
    @Schema(description = "Senha do funcionário", example = "senha123")
    private String senha;

    @NotBlank
    @Schema(description = "Cargo do funcionário", example = "Professor")
    private String cargo;
    
    
    

	public Funcionario(Long id, @NotBlank @Size(min = 3) String nome, @NotBlank @Email String email,
			@NotBlank @Size(min = 6) String senha, @NotBlank String cargo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cargo = cargo;
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




	public String getSenha() {
		return senha;
	}




	public void setSenha(String senha) {
		this.senha = senha;
	}




	public String getCargo() {
		return cargo;
	}




	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

    
    
}
