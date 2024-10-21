package com.projeto.gen.sistema_escolar.service;

import com.projeto.gen.sistema_escolar.entity.Funcionario;
import com.projeto.gen.sistema_escolar.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    // Método para listar todos os funcionários
    public ResponseEntity<List<Funcionario>> listarTodos() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return ResponseEntity.ok(funcionarios);
    }

    // Método para buscar um funcionário pelo ID
    public ResponseEntity<Funcionario> buscarPorId(Long id) {
        return funcionarioRepository.findById(id)
                .map(funcionario -> ResponseEntity.ok(funcionario))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Método para salvar um novo funcionário
    public ResponseEntity<Funcionario> salvar(Funcionario funcionario) {
        if (funcionarioRepository.existsByEmail(funcionario.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioSalvo);
    }

    // Método para atualizar um funcionário existente
    public ResponseEntity<Funcionario> atualizar(Long id, Funcionario funcionarioAtualizado) {
        return funcionarioRepository.findById(id).map(funcionario -> {
            funcionario.setNome(funcionarioAtualizado.getNome());
            funcionario.setEmail(funcionarioAtualizado.getEmail());
            funcionario.setCargo(funcionarioAtualizado.getCargo());
            funcionario.setSenha(funcionarioAtualizado.getSenha());
            Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);
            return ResponseEntity.ok(funcionarioSalvo);
        }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Método para deletar um funcionário pelo ID
    public ResponseEntity<Void> deletar(Long id) {
        if (funcionarioRepository.existsById(id)) {
            funcionarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
