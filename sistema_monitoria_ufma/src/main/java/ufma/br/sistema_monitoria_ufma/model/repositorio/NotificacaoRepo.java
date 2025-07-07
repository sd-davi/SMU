package ufma.br.sistema_monitoria_ufma.model.repositorio;

import java.util.List;

import javax.management.monitor.Monitor;

import org.springframework.data.jpa.repository.JpaRepository;

import ufma.br.sistema_monitoria_ufma.model.Aluno;
import ufma.br.sistema_monitoria_ufma.model.Notificacao;

public interface  NotificacaoRepo 
extends JpaRepository<Notificacao, Integer>{
    List<Notificacao> findByAluno(Aluno aluno);
    List<Notificacao> findByMonitor(Monitor monitor);
    List<Notificacao> findByAlunoAndLidaFalse(Aluno aluno);
    List<Notificacao> findByMonitorAndLidaFalse(Monitor monitor);
}
