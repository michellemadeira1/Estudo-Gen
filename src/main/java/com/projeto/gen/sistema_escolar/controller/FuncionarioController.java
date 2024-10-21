package com.projeto.gen.sistema_escolar.controller;

import com.projeto.gen.sistema_escolar.entity.Funcionario;
import com.projeto.gen.sistema_escolar.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
@CrossOrigin("*")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    // Listar todos os funcionários
    @GetMapping("/todos")
    public ResponseEntity<List<Funcionario>> listarTodos() {
        return funcionarioService.listarTodos();
    }

    // Buscar funcionário por ID
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {
        return funcionarioService.buscarPorId(id);
    }

    // Salvar novo funcionário
    @PostMapping("/cadastrar")
    public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario) {
        return funcionarioService.salvar(funcionario);
    }

    // Atualizar funcionário existente
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @RequestBody Funcionario funcionarioAtualizado) {
        return funcionarioService.atualizar(id, funcionarioAtualizado);
    }

    // Deletar funcionário
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return funcionarioService.deletar(id);
    }
}
