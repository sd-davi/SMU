package ufma.br.sistema_monitoria_ufma.model;
import java.time.LocalDateTime;

import javax.management.monitor.Monitor;

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


@Entity
@Table(name="mensagem")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mensagem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mensagem_id")
    private Integer mensagemId;

    private String conteudo;
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "monitor_id")
    private Monitor monitor;

    @ManyToOne
    @JoinColumn(name = "monitoria_id")
    private Monitoria monitoria;
}
