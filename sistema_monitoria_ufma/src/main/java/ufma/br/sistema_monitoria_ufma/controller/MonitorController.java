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

import ufma.br.sistema_monitoria_ufma.controller.Dto.MonitorDto;
import ufma.br.sistema_monitoria_ufma.model.Monitor;
import ufma.br.sistema_monitoria_ufma.model.Monitoria;
import ufma.br.sistema_monitoria_ufma.services.MonitorService;

@RestController
@RequestMapping("/api/monitor")
public class MonitorController {

    @Autowired
    MonitorService service;


    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody MonitorDto dto) {
        try {
            Monitor salvo = service.salvar(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monitor> buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Monitor> listarTodos() {
        return service.listarTodos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/monitorias")
    public ResponseEntity<?> listarMonitorias(@PathVariable Integer id) {
    try {
        List<Monitoria> monitorias = service.listarMonitorias(id);
        return ResponseEntity.ok(monitorias);
    } catch (RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
}
