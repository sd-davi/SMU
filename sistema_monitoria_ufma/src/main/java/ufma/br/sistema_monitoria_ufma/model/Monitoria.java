package ufma.br.sistema_monitoria_ufma.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="monitoria")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Monitoria {

    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_monitor")
    private Monitor monitor;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "id_disciplina")
    private Disciplina disciplina;

    private String codigoDisciplina;
    private String horario;
    private String link;

    
}
