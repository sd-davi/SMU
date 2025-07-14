package ufma.br.sistema_monitoria_ufma.controller.Dto;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDto {
    private String nome;
    private String email;
    private String celular;
    private Date data_nascimento;
    private String matricula;
    private Integer curso_id;
    private String senha;
    private List<Integer> disciplinasMatriculadoIds;
}
