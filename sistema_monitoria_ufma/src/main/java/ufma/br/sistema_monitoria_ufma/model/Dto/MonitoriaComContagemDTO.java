package ufma.br.sistema_monitoria_ufma.model.Dto;

import ufma.br.sistema_monitoria_ufma.model.Monitoria;

public class MonitoriaComContagemDTO {
    private Monitoria monitoria;
    private Long quantidadeAlunos;

    public MonitoriaComContagemDTO(Monitoria monitoria, Long quantidadeAlunos) {
        this.monitoria = monitoria;
        this.quantidadeAlunos = quantidadeAlunos;
    }

    public Monitoria getMonitoria() { return monitoria; }
    public Long getQuantidadeAlunos() { return quantidadeAlunos; }
}
