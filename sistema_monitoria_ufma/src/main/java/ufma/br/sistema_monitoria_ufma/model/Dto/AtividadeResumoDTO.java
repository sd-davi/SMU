package ufma.br.sistema_monitoria_ufma.model.Dto;

import ufma.br.sistema_monitoria_ufma.model.Atividade;

public class AtividadeResumoDTO {
    private Atividade atividade;
    private Long totalRespostas;

    public AtividadeResumoDTO(Atividade atividade, Long totalRespostas) {
        this.atividade = atividade;
        this.totalRespostas = totalRespostas;
    }

    public Atividade getAtividade() { return atividade; }
    public Long getTotalRespostas() { return totalRespostas; }
}
