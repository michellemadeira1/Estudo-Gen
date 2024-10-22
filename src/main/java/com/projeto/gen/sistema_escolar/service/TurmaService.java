package com.projeto.gen.sistema_escolar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projeto.gen.sistema_escolar.entity.Aluno;
import com.projeto.gen.sistema_escolar.entity.Turma;
import com.projeto.gen.sistema_escolar.repository.TurmaRepository;

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
        // Verificar se algum aluno está matriculado em outra turma no mesmo horário
        for (Aluno aluno : turma.getAlunos()) {
            if (turmaRepository.existsByAlunos_IdAndHorario(aluno.getId(), turma.getHorario())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        }

        Turma turmaSalva = turmaRepository.save(turma);
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaSalva);
    }
    
    

 // Método para atualizar uma turma existente
    public ResponseEntity<Turma> atualizar(Long id, Turma turmaAtualizada) {
        // Verifica se a turma existe
        if (!turmaRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Recupera a turma existente
        Turma turma = turmaRepository.findById(id).get();

        // Verificar se algum aluno está matriculado em outra turma no mesmo horário
        for (Aluno aluno : turmaAtualizada.getAlunos()) {
            boolean conflito = turmaRepository.existsByAlunos_IdAndHorario(aluno.getId(), turmaAtualizada.getHorario());
            if (conflito) {
                // Se houver conflito de horário, retornar BAD_REQUEST
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }

        // Atualizar a turma
        turma.setNome(turmaAtualizada.getNome());
        turma.setInstrutor(turmaAtualizada.getInstrutor());
        turma.setAlunos(turmaAtualizada.getAlunos());
        turma.setHorario(turmaAtualizada.getHorario());

        // Salvar as mudanças
        Turma turmaSalva = turmaRepository.save(turma);
        return ResponseEntity.ok(turmaSalva);
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
