package ufma.br.sistema_monitoria_ufma.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;

@Entity
@IdClass(AtividadeRespostaId.class) // indica que a chave primária é composta
public class AtividadeResposta {
    
    @Id
    @ManyToOne
    private Atividade atividade;

    @Id
    @ManyToOne
    private Aluno aluno;

    private LocalDateTime dataResposta;
    private String linkResposta;
}
