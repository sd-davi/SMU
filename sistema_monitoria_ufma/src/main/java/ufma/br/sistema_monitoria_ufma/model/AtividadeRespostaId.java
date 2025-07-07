package ufma.br.sistema_monitoria_ufma.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;

public class AtividadeRespostaId implements Serializable {
    @Column(name = "atividade_id")
    private Integer atividade;
    @Column(name = "aluno_id")
    private Integer aluno;

    public AtividadeRespostaId() {
    }

    public AtividadeRespostaId(Integer atividade, Integer aluno) {
        this.atividade = atividade;
        this.aluno = aluno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AtividadeRespostaId)) return false;
        AtividadeRespostaId that = (AtividadeRespostaId) o;
        return Objects.equals(atividade, that.atividade) &&
               Objects.equals(aluno, that.aluno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(atividade, aluno);
    }
}
