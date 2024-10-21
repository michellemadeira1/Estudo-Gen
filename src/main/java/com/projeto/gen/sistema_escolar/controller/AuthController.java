package com.projeto.gen.sistema_escolar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projeto.gen.sistema_escolar.dto.FuncionarioLoginDTO; // Importando o DTO
import com.projeto.gen.sistema_escolar.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody FuncionarioLoginDTO loginDTO) {
        String token = authService.autenticar(loginDTO.getEmail(), loginDTO.getSenha());
        return ResponseEntity.ok(token);
    }
}
