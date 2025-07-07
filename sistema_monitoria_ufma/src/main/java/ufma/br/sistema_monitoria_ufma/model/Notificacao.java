package ufma.br.sistema_monitoria_ufma.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name="notificacao")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Notificacao {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notificacao_id")
    private Integer notificacaoId;

    private String mensagem;
    private boolean lida = false;
    private LocalDateTime dataEnvio;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "monitor_id")
    private Monitor monitor;
}
