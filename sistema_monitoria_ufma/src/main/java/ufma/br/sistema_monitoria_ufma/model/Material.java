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
@Table(name="material")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Material {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="material_id")
    private Long id;

    private String titulo;
    private String descricao;
    private String link;
    private String caminhoArquivo;

    @ManyToOne
    @JoinColumn(name = "monitoria_id")
    private Monitoria monitoria;
}
