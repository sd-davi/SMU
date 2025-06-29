package ufma.br.sistema_monitoria_ufma.model.Dto;



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
    private String senha;
    private Long curso;
    private Long disciplina;
    private String codigoVerifcacao;
}
