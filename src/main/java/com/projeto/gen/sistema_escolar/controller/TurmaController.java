package com.projeto.gen.sistema_escolar.controller;

import com.projeto.gen.sistema_escolar.entity.Turma;
import com.projeto.gen.sistema_escolar.service.TurmaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
@CrossOrigin("*")
@Tag(name = "Turma", description = "Controlador para gerenciar turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @Operation(summary = "Listar todas as turmas")
    @GetMapping("/todas")
    public ResponseEntity<List<Turma>> listarTodas() {
        return turmaService.listarTodas();
    }

    @Operation(summary = "Buscar turma por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Turma> buscarPorId(@PathVariable Long id) {
        return turmaService.buscarPorId(id);
    }

    @Operation(summary = "Salvar nova turma")
    @PostMapping("/cadastrar")
    public ResponseEntity<Turma> salvar(@RequestBody Turma turma) {
        return turmaService.salvar(turma);
    }

    @Operation(summary = "Atualizar turma existente")
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Turma> atualizar(@PathVariable Long id, @RequestBody Turma turmaAtualizada) {
        return turmaService.atualizar(id, turmaAtualizada);
    }


    @Operation(summary = "Deletar turma")
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return turmaService.deletar(id);
    }
}
