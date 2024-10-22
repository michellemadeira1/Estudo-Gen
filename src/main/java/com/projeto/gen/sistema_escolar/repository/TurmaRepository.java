package com.projeto.gen.sistema_escolar.repository;

import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projeto.gen.sistema_escolar.entity.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
	
    boolean existsByNome(String nome);
    
 // Verifica se algum aluno está matriculado em outra turma no mesmo horário
    boolean existsByAlunos_IdAndHorario(Long alunoId, LocalTime localTime);

   
}
