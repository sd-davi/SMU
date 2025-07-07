package ufma.br.sistema_monitoria_ufma.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    private Integer notificacaoId;

    private String mensagem;
    private boolean lida = false;
    private LocalDateTime dataEnvio;

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Monitor monitor;
}
