package com.projeto.gen.sistema_escolar.service;

import com.projeto.gen.sistema_escolar.entity.Turma;
import com.projeto.gen.sistema_escolar.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    // Método para listar todas as turmas
    public ResponseEntity<List<Turma>> listarTodas() {
        List<Turma> turmas = turmaRepository.findAll();
        return ResponseEntity.ok(turmas);
    }

    // Método para buscar uma turma pelo ID
    public ResponseEntity<Turma> buscarPorId(Long id) {
        return turmaRepository.findById(id)
                .map(turma -> ResponseEntity.ok(turma))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Método para salvar uma nova turma
    public ResponseEntity<Turma> salvar(Turma turma) {
        if (turmaRepository.existsByNome(turma.getNome())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Turma turmaSalva = turmaRepository.save(turma);
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaSalva);
    }

    // Método para atualizar uma turma existente
    public ResponseEntity<Turma> atualizar(Long id, Turma turmaAtualizada) {
        return turmaRepository.findById(id).map(turma -> {
            turma.setNome(turmaAtualizada.getNome());
            turma.setInstrutor(turmaAtualizada.getInstrutor());
            turma.setAlunos(turmaAtualizada.getAlunos());
            Turma turmaSalva = turmaRepository.save(turma);
            return ResponseEntity.ok(turmaSalva);
        }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Método para deletar uma turma pelo ID
    public ResponseEntity<Void> deletar(Long id) {
        if (turmaRepository.existsById(id)) {
            turmaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
