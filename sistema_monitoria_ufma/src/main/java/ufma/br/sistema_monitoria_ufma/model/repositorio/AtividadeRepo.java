package ufma.br.sistema_monitoria_ufma.model.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ufma.br.sistema_monitoria_ufma.model.Atividade;
import ufma.br.sistema_monitoria_ufma.model.Dto.AtividadeResumoDTO;
import ufma.br.sistema_monitoria_ufma.model.Monitoria;

public interface  AtividadeRepo 
extends JpaRepository<Atividade, Integer>{
    List<Atividade> findByMonitoria(Monitoria monitoria);

    // Função: Listar atividades com quantidade de respostas
    @Query("""
    SELECT new ufma.br.sistema_monitoria_ufma.model.dto.AtividadeResumoDTO(a, COUNT(r))
    FROM Atividade a
    LEFT JOIN AtividadeResposta r ON r.atividade = a
    GROUP BY a
    """)
    List<AtividadeResumoDTO> listarAtividadesComTotalRespostas();
}
