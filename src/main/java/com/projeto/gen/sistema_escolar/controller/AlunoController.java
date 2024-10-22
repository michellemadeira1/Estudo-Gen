package com.projeto.gen.sistema_escolar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projeto.gen.sistema_escolar.entity.Aluno;
import com.projeto.gen.sistema_escolar.service.AlunoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/alunos")
@CrossOrigin(origins = "*")
@Tag(name = "Aluno", description = "Controlador para gerenciar alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    
    @Operation(summary = "Listar todos os alunos")
    @GetMapping
    public List<Aluno> listarTodos() {
        return alunoService.listarTodos();
    }

    @Operation(summary = "Buscar um aluno pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
        return alunoService.buscarPorId(id);
    }

    @Operation(summary = "Cadastrar um novo aluno")
    @PostMapping
    public ResponseEntity<Aluno> cadastrar(@RequestBody Aluno aluno) {
        return alunoService.salvar(aluno);
    }

    @Operation(summary = "Atualizar um aluno existente")
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
        return alunoService.atualizar(id, alunoAtualizado);
    }

    @Operation(summary = "Deletar um aluno pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return alunoService.deletar(id);
    }
}
