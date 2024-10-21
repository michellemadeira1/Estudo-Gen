package com.projeto.gen.sistema_escolar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projeto.gen.sistema_escolar.entity.Aluno;
import com.projeto.gen.sistema_escolar.service.AlunoService;

@RestController
@RequestMapping("/alunos")
@CrossOrigin(origins = "*")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    // Endpoint para listar todos os alunos
    @GetMapping
    public List<Aluno> listarTodos() {
        return alunoService.listarTodos();
    }

    // Endpoint para buscar um aluno pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
        return alunoService.buscarPorId(id);
    }

    // Endpoint para cadastrar um novo aluno
    @PostMapping
    public ResponseEntity<Aluno> cadastrar(@RequestBody Aluno aluno) {
        return alunoService.salvar(aluno);
    }

    // Endpoint para atualizar um aluno existente
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
        return alunoService.atualizar(id, alunoAtualizado);
    }

    // Endpoint para deletar um aluno pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return alunoService.deletar(id);
    }
}
