package ufma.br.sistema_monitoria_ufma.model.Dto;

import ufma.br.sistema_monitoria_ufma.model.Aluno;

public class AlunoAtividadeDTO {
    private Aluno aluno;
    private Long totalRespostas;

    public AlunoAtividadeDTO(Aluno aluno, Long totalRespostas) {
        this.aluno = aluno;
        this.totalRespostas = totalRespostas;
    }

    public Aluno getAluno() { return aluno; }
    public Long getTotalRespostas() { return totalRespostas; }
    
}
