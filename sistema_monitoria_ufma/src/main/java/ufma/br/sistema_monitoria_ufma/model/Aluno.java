package ufma.br.sistema_monitoria_ufma.model;

import java.sql.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="aluno")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Aluno{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aluno_id")
    private Integer id;

    private String nome;
    private String email;
    private String celular;
    private Date data_nascimento;
    private String matricula;

    @JsonIgnore
    private String senha;

    private Integer curso_id;


    @ManyToMany
    @JoinTable(
    name = "aluno_disciplina",
    joinColumns = @JoinColumn(name = "disciplina_id"), 
    inverseJoinColumns = @JoinColumn(name = "aluno_id"))
    Set<Disciplina> disciplinas;

    @ManyToMany
    @JoinTable(
    name = "monitoria_aluno",
    joinColumns = @JoinColumn(name = "monitoria_id"), 
    inverseJoinColumns = @JoinColumn(name = "aluno_id"))
    Set<Monitoria> monitorias;


}
