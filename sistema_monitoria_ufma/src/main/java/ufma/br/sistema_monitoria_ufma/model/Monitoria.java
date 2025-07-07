package ufma.br.sistema_monitoria_ufma.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
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
    @JoinColumn(name = "monitor_id")
    private Monitor monitor;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

    private String codigoDisciplina;
    private String horario;
    private String link;

    @ManyToMany(mappedBy = "monitorias")
    Set<Aluno> alunos;
}
