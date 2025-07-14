package ufma.br.sistema_monitoria_ufma.services;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ufma.br.sistema_monitoria_ufma.controller.Dto.AlunoDto;
import ufma.br.sistema_monitoria_ufma.model.Aluno;
import ufma.br.sistema_monitoria_ufma.model.Curso;
import ufma.br.sistema_monitoria_ufma.model.Disciplina;
import ufma.br.sistema_monitoria_ufma.model.Dto.AlunoAtividadeDTO;
import ufma.br.sistema_monitoria_ufma.model.repositorio.AlunoRepo;
import ufma.br.sistema_monitoria_ufma.model.repositorio.CursoRepo;
import ufma.br.sistema_monitoria_ufma.model.repositorio.DisciplinaRepo;
import ufma.br.sistema_monitoria_ufma.model.repositorio.MonitoriaRepo;
import ufma.br.sistema_monitoria_ufma.services.Exceptions.UsuarioRunTime;

@Service
public class AlunoService {

    
    @Autowired
    AlunoRepo repo;

    @Autowired
     MonitoriaRepo monitoriaRepo;

    @Autowired
    CursoRepo cursoRepo;

    @Autowired
    DisciplinaRepo disciplinaRepo;


    @Transactional
    // so salva apos o final (para evitar dados incosistentes), se tiver problemas faz um rollback
    public Aluno salvar(AlunoDto a){
        validarAluno(a);
        Curso curso = cursoRepo.findById(a.getCurso_id())
        .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        List<Disciplina> disciplinas = disciplinaRepo.findAllById(a.getDisciplinasMatriculadoIds());

        Aluno aluno = new Aluno();
        aluno.setNome(a.getNome());
        aluno.setEmail(a.getEmail());
        aluno.setCelular(a.getCelular());
        aluno.setData_nascimento(a.getData_nascimento());
        aluno.setCurso_id(curso.getId());
        aluno.setMatricula(a.getMatricula());
        aluno.setSenha(a.getSenha());
        aluno.setDisciplinas(new HashSet<>(disciplinas));

        return repo.save(aluno);
    }

    public void validarAluno(AlunoDto aluno) {

        if (aluno.getNome() == null || aluno.getNome().isBlank()) {
            throw new UsuarioRunTime("Nome do aluno é obrigatório.");
        }

        if (aluno.getEmail() == null || aluno.getEmail().isBlank()) {
            throw new UsuarioRunTime("E-mail do aluno é obrigatório.");
        }

        if (aluno.getCelular() == null || aluno.getCelular().isBlank()) {
            throw new UsuarioRunTime("Celular do aluno é obrigatório.");
        }

        if (aluno.getData_nascimento() == null) {
            throw new UsuarioRunTime("Data de nascimento é obrigatória.");
        }

        if (aluno.getCurso_id() == null ) {
            throw new UsuarioRunTime("Curso do aluno é obrigatório.");
        }

        if (aluno.getMatricula() == null || aluno.getMatricula().isBlank()) {
            throw new UsuarioRunTime("Matrícula do aluno é obrigatória.");
        }

        if (aluno.getSenha() == null || aluno.getSenha().isBlank()) {
            throw new UsuarioRunTime("Senha do aluno é obrigatória.");
        }
         if (repo.existsByEmail(aluno.getEmail())) {
        throw new RuntimeException("Email já está cadastrado.");
        }

    // (opcional) verifica se a matrícula já existe
        if (repo.existsByMatricula(aluno.getMatricula())) {
            throw new RuntimeException("Matrícula já está cadastrada.");
        }
    }



    //public List<AlunoMonitoriaResumoDTO> listarMonitorias(Integer a){ verificarId(a); return repo.listarMonitoriasDoAluno(a);}
        

    private void verificarId(Integer a){
        if (a == null ){
            throw new UsuarioRunTime("Usuario invalido");
        }
    }

    public List<Aluno> listarTodos() {
        return repo.findAll();
    }

    public Optional<Aluno> buscarPorId(Integer id) {
        return repo.findById(id);
    }

    public Optional<Aluno> buscarPorEmail(String email) {
        return repo.findByEmail(email);
    }

    public Optional<Aluno> buscarPorMatricula(String matricula) {
        return repo.findByMatricula(matricula);
    }

    public void deletarPorId(Integer id) {
        repo.deleteById(id);
    }

    public List<Aluno> listarPorCurso(Integer cursoId) {
        return cursoRepo.findById(cursoId)
            .map(repo::findByCurso)
            .orElse(Collections.emptyList());
    }

    public List<AlunoAtividadeDTO> listarAlunosComTotalDeAtividadesRespondidas() {
        return repo.listarAlunosComTotalDeAtividadesRespondidas();
    }

}
