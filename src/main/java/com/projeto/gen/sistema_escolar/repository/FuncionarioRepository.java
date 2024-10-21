package com.projeto.gen.sistema_escolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.gen.sistema_escolar.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Funcionario findByEmail(String email);
}
