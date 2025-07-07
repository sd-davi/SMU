package ufma.br.sistema_monitoria_ufma.model.repositorio;

import java.util.List;
import java.util.Optional;

import javax.management.monitor.Monitor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ufma.br.sistema_monitoria_ufma.model.Curso;
import ufma.br.sistema_monitoria_ufma.model.Dto.MonitorResumoDTO;


public interface  MonitorRepo
extends JpaRepository<Monitor, Integer> {

    Optional<Monitor> findByEmail(String email);
    boolean existsByEmail(String email);
    Optional<Monitor> findByMatricula(String matricula);
    //Optional<Monitor> findByCodigoVerificacao(String codigoVerificacao);
    List<Monitor> findByCurso(Curso curso);

    //Função: Listar monitores com número de monitorias

    @Query("""
    SELECT new ufma.br.sistema_monitoria_ufma.model.dto.MonitorResumoDTO(m, COUNT(mon))
    FROM Monitor m
    LEFT JOIN Monitoria mon ON mon.monitor = m
    GROUP BY m
    """)
    List<MonitorResumoDTO> listarMonitoresComMonitorias();

}
