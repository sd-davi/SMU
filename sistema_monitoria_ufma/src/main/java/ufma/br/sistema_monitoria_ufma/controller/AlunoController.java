package ufma.br.sistema_monitoria_ufma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ufma.br.sistema_monitoria_ufma.controller.Dto.AlunoDto;
import ufma.br.sistema_monitoria_ufma.model.Aluno;
import ufma.br.sistema_monitoria_ufma.services.AlunoService;
import ufma.br.sistema_monitoria_ufma.services.Exceptions.UsuarioRunTime;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
    
    @Autowired
    AlunoService service;

    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody AlunoDto a) {
        try {
            Aluno novoAluno = service.salvar(a); // usando DTO
            return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
        } catch (UsuarioRunTime e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
