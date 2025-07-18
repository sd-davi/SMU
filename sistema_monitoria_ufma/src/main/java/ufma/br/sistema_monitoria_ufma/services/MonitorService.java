package ufma.br.sistema_monitoria_ufma.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import ufma.br.sistema_monitoria_ufma.model.Monitor;
import ufma.br.sistema_monitoria_ufma.model.Monitoria;
import ufma.br.sistema_monitoria_ufma.controller.Dto.MonitorDto;
import ufma.br.sistema_monitoria_ufma.model.Curso;
import ufma.br.sistema_monitoria_ufma.model.Disciplina;
import ufma.br.sistema_monitoria_ufma.model.repositorio.CursoRepo;
import ufma.br.sistema_monitoria_ufma.model.repositorio.DisciplinaRepo;
import ufma.br.sistema_monitoria_ufma.model.repositorio.MonitorRepo;

@Service
public class MonitorService {

    @Autowired
    MonitorRepo repo;

    @Autowired
    CursoRepo cursoRepo;

    @Autowired
    DisciplinaRepo disciplinaRepo;

    public Monitor salvar(MonitorDto dto) {
        validarMonitor(dto);

        Curso curso = cursoRepo.findById(dto.getCursoId())
            .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        Disciplina disciplina = disciplinaRepo.findById(dto.getDisciplinaId())
            .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));

        Monitor monitor = new Monitor();
        monitor.setNome(dto.getNome());
        monitor.setEmail(dto.getEmail());
        monitor.setCelular(dto.getCelular());
        monitor.setData_nascimento(dto.getDataNascimento());
        monitor.setCurso(curso);
        monitor.setMatricula(dto.getMatricula());
        monitor.setSenha(dto.getSenha());
        monitor.setDisciplina(disciplina);
        monitor.setCodigo_verificacao(dto.getCodigo());

        return repo.save(monitor);
    }

    private void validarMonitor(MonitorDto dto) {
        if (dto.getNome() == null || dto.getNome().isBlank()) {
            throw new RuntimeException("Nome é obrigatório.");
        }
        if (dto.getEmail() == null || dto.getEmail().isBlank()) {
            throw new RuntimeException("Email é obrigatório.");
        }
        if (dto.getSenha() == null || dto.getSenha().length() < 6) {
            throw new RuntimeException("Senha deve ter ao menos 6 caracteres.");
        }
        if (dto.getMatricula() == null || dto.getMatricula().isBlank()) {
            throw new RuntimeException("Matrícula é obrigatória.");
        }
        if (dto.getCursoId() == null) {
            throw new RuntimeException("Curso é obrigatório.");
        }
        if (dto.getDisciplinaId() == null) {
            throw new RuntimeException("Disciplina é obrigatória.");
        }
        if (dto.getCodigo() == null || dto.getCodigo().isBlank()) {
            throw new RuntimeException("Código de confirmação é obrigatório.");
        }

        if (repo.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email já está cadastrado.");
        }

        if (repo.existsByMatricula(dto.getMatricula())) {
            throw new RuntimeException("Matrícula já está cadastrada.");
        }
    }

    public Optional<Monitor> buscarPorId(Integer id) {
        return repo.findById(id);
    }

    public List<Monitor> listarTodos() {
        return repo.findAll();
    }

    public void deletarPorId(Integer id) {
        repo.deleteById(id);
    }

    public List<Monitoria> listarMonitorias(Integer id) {
        Monitor monitor = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Monitor não encontrado"));
        
        return monitor.getMonitorias();
    }

}
