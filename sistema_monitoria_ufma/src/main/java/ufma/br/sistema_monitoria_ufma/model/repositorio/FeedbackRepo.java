package ufma.br.sistema_monitoria_ufma.model.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ufma.br.sistema_monitoria_ufma.model.Aluno;
import ufma.br.sistema_monitoria_ufma.model.Feedback;
import ufma.br.sistema_monitoria_ufma.model.Monitoria;

public interface FeedbackRepo 
extends JpaRepository<Feedback, Integer>{
    List<Feedback> findByMonitoria(Monitoria monitoria);
    List<Feedback> findByAluno(Aluno aluno);
}
