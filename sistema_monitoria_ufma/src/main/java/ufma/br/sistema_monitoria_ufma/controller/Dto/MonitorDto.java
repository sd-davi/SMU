package ufma.br.sistema_monitoria_ufma.controller.Dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MonitorDto {
    private String nome;
    private String email;
    private String celular;
    private Date dataNascimento;
    private Integer cursoId;
    private String matricula;
    private String senha;
    private Integer disciplinaId;
    private String codigo;
}