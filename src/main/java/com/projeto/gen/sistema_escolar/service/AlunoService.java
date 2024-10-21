package com.projeto.gen.sistema_escolar.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.projeto.gen.sistema_escolar.entity.Aluno;
import com.projeto.gen.sistema_escolar.repository.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    // Método para listar todos os alunos
    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

 // Método para buscar um aluno pelo ID
    public ResponseEntity<Aluno> buscarPorId(Long id) {
        return alunoRepository.findById(id)
                .map(aluno -> ResponseEntity.ok(aluno))  
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());  
    }


 // Método para salvar um novo aluno
    public ResponseEntity<Aluno> salvar(Aluno aluno) {
        if (alunoRepository.existsByEmail(aluno.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();  
        }
        
        aluno.setMedia(calcularMedia(aluno.getNotaPrimeiroModulo(), aluno.getNotaSegundoModulo()));
        Aluno alunoSalvo = alunoRepository.save(aluno);  // Salva o aluno
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoSalvo);
    }


   
 // Método para atualizar um aluno existente
    public ResponseEntity<Aluno> atualizar(Long id, Aluno alunoAtualizado) {
        return alunoRepository.findById(id).map(aluno -> {
            aluno.setNome(alunoAtualizado.getNome());
            aluno.setEmail(alunoAtualizado.getEmail());
            aluno.setIdade(alunoAtualizado.getIdade());
            aluno.setNotaPrimeiroModulo(alunoAtualizado.getNotaPrimeiroModulo());
            aluno.setNotaSegundoModulo(alunoAtualizado.getNotaSegundoModulo());
            aluno.setMedia(calcularMedia(alunoAtualizado.getNotaPrimeiroModulo(), alunoAtualizado.getNotaSegundoModulo()));
            
            Aluno alunoAtualizadoSalvo = alunoRepository.save(aluno);  
            return ResponseEntity.ok(alunoAtualizadoSalvo);  
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build()); 
    }


    
 // Método para deletar um aluno pelo ID
    public ResponseEntity<Void> deletar(Long id) {
        if (alunoRepository.existsById(id)) {
            alunoRepository.deleteById(id);
            return ResponseEntity.noContent().build();  
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  
    }


    // Método auxiliar para calcular a média
    private double calcularMedia(double notaPrimeiroModulo, double notaSegundoModulo) {
        return (notaPrimeiroModulo + notaSegundoModulo) / 2;
    }
}
