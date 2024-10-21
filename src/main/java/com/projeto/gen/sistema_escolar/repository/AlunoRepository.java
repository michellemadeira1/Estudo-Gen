package com.projeto.gen.sistema_escolar.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.gen.sistema_escolar.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
    List<Aluno> findAllByNomeContainingIgnoreCase(String nome);
    boolean existsByEmail(String email);
}
