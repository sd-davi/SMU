package ufma.br.sistema_monitoria_ufma.model;
import java.time.LocalDateTime;

import javax.management.monitor.Monitor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Long mensagemId;

    private String conteudo;
    private LocalDateTime dataHora;

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Monitor monitor;

    @ManyToOne
    private Monitoria monitoria;
}
