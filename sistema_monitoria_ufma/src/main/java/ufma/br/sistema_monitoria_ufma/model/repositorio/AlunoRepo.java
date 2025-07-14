package ufma.br.sistema_monitoria_ufma.model.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ufma.br.sistema_monitoria_ufma.model.Aluno;
import ufma.br.sistema_monitoria_ufma.model.Curso;
import ufma.br.sistema_monitoria_ufma.model.Dto.AlunoAtividadeDTO;
import ufma.br.sistema_monitoria_ufma.model.Dto.AlunoMonitoriaResumoDTO;

public interface  AlunoRepo
extends JpaRepository<Aluno, Integer> {

    Optional<Aluno> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByMatricula(String matricula);
    Optional<Aluno> findByMatricula(String matricula);
    List<Aluno> findByCurso(Curso curso);

    //Função: Alunos com mais atividades respondidas
    @Query("""
    SELECT new com.seuprojeto.dto.AlunoAtividadeDTO(a, COUNT(r))
    FROM Aluno a
    LEFT JOIN AtividadeResposta r ON r.aluno = a
    GROUP BY a
    """)
    List<AlunoAtividadeDTO> listarAlunosComTotalDeAtividadesRespondidas();

    @Query("""
    SELECT new ufma.br.sistema_monitoria_ufma.model.dto.AlunoMonitoriaResumoDTO(
        m.monitoriaId,
        d.nome,
        m.horario,
        c.nome,
        m.link
    )
    FROM Monitoria m
    JOIN m.alunos a
    JOIN m.curso c
    JOIN m.disciplina d
    WHERE a.alunoId = :alunoId        
    """)List<AlunoMonitoriaResumoDTO> listarMonitoriasDoAluno(@Param("alunoId") Integer alunoId);

}
