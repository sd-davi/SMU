package ufma.br.sistema_monitoria_ufma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // Buscar aluno por ID
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // Listar todos os alunos
    @GetMapping
    public List<Aluno> listarTodos() {
        return service.listarTodos();
    }

    // Deletar aluno por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }

}

