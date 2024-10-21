package com.projeto.gen.sistema_escolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.gen.sistema_escolar.entity.Aluno;


public interface AlunoRepository {

public interface FuncionarioRepository extends JpaRepository<Aluno, Long> {
	boolean existsByEmail(String email);
    
 }
}
