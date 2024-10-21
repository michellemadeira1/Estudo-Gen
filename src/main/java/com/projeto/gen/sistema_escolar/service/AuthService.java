package com.projeto.gen.sistema_escolar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

import com.projeto.gen.sistema_escolar.entity.Funcionario;
import com.projeto.gen.sistema_escolar.repository.FuncionarioRepository;

@Service
public class AuthService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    // Método para gerar token JWT
    public String gerarToken(Funcionario funcionario) {
        return Jwts.builder()
            .setSubject(funcionario.getEmail())
            .setExpiration(new Date(System.currentTimeMillis() + 3 * 60 * 60 * 1000)) // 3 horas
            .signWith(SignatureAlgorithm.HS256, "chaveSecreta") // Use uma chave segura
            .compact();
    }

    // Método para autenticar o funcionário e gerar o token
    public String autenticar(String email, String senha) {
        Funcionario funcionario = funcionarioRepository.findByEmail(email);
        // Verifique a senha (implementação a ser feita)
        if (funcionario != null /* && senhaValida(funcionario, senha) */) {
            return gerarToken(funcionario);
        }
        throw new RuntimeException("Email ou senha inválidos.");
    }
}
