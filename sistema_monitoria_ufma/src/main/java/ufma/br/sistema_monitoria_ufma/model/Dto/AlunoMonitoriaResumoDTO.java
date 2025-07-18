package ufma.br.sistema_monitoria_ufma.model.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AlunoMonitoriaResumoDTO {

    private Integer monitoriaId;
    private String disciplina;
    private String horario;
    private String curso;
    private String link;

}
