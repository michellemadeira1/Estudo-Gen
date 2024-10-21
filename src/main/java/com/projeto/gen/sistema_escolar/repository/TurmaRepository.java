package com.projeto.gen.sistema_escolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projeto.gen.sistema_escolar.entity.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
    boolean existsByNome(String nome);
}
