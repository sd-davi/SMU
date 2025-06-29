package ufma.br.sistema_monitoria_ufma.model;

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
@Table(name="discilina")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Disciplina{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_disciplina")
    private Integer id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;
}
