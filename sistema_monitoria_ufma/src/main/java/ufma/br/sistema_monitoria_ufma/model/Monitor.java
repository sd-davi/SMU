package ufma.br.sistema_monitoria_ufma.model;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="monitor")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Monitor{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_monitor")
    private Integer id;
    
    private String nome;
    private String email;
    private String celular;
    private Date data_nascimento;
    private String matricula;

    @JsonIgnore
    private String senha;

    private String codigo_verificacao;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "id_disciplina")
    private Disciplina disciplina;

    @OneToMany(mappedBy="monitor", fetch= FetchType.LAZY)
    List<Disciplina> disciplinas;
}
