package ufma.br.sistema_monitoria_ufma.model;

import java.time.LocalDateTime;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
 // indica que a chave primária é composta
public class AtividadeResposta {
    
   @EmbeddedId
   AtividadeRespostaId id;

    private LocalDateTime dataResposta;
    private String linkResposta;
}
