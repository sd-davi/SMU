package ufma.br.sistema_monitoria_ufma.model.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class AlunoMonitoriaDTO {
    private Integer alunoId;
    private Integer monitoriaId;

}
