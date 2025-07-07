package ufma.br.sistema_monitoria_ufma.model.repositorio;

import java.util.List;

import javax.management.monitor.Monitor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ufma.br.sistema_monitoria_ufma.model.Aluno;
import ufma.br.sistema_monitoria_ufma.model.Curso;
import ufma.br.sistema_monitoria_ufma.model.Disciplina;
import ufma.br.sistema_monitoria_ufma.model.Dto.MonitoriaComContagemDTO;
import ufma.br.sistema_monitoria_ufma.model.Monitoria;

public interface  MonitoriaRepo
extends JpaRepository<Monitoria, Integer>{
    
    List<Monitoria> findByMonitor(Monitor monitor);
    List<Monitoria> findByCurso(Curso curso);
    List<Monitoria> findByDisciplina(Disciplina disciplina);
    List<Monitoria> findByAlunosContaining(Aluno aluno); 
    

    // Função: Listar monitorias com número de alunos inscritos
    @Query("""
    SELECT new ufma.br.sistema_monitoria_ufma.model.dto.MonitoriaComContagemDTO(m, COUNT(a))
    FROM Monitoria m
    LEFT JOIN m.alunos a
    GROUP BY m
    """)
    List<MonitoriaComContagemDTO> listarMonitoriasComContagemDeAlunos();
}
