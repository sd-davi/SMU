package ufma.br.sistema_monitoria_ufma.model.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ufma.br.sistema_monitoria_ufma.model.Aluno;
import ufma.br.sistema_monitoria_ufma.model.Atividade;
import ufma.br.sistema_monitoria_ufma.model.AtividadeResposta;
import ufma.br.sistema_monitoria_ufma.model.AtividadeRespostaId;

public interface AtividadeRespostaRepo 
extends JpaRepository<AtividadeResposta, AtividadeRespostaId> {
    List<AtividadeResposta> findByAluno(Aluno aluno);
    List<AtividadeResposta> findByAtividade(Atividade atividade);
    Optional<AtividadeResposta> findByAtividadeAndAluno(Atividade atividade, Aluno aluno);
}
