package ufma.br.sistema_monitoria_ufma.model.repositorio;

import java.util.List;

import javax.management.monitor.Monitor;

import org.springframework.data.jpa.repository.JpaRepository;

import ufma.br.sistema_monitoria_ufma.model.Aluno;
import ufma.br.sistema_monitoria_ufma.model.Mensagem;
import ufma.br.sistema_monitoria_ufma.model.Monitoria;

public interface MensagemRepo 
extends JpaRepository<Mensagem, Integer>{
    List<Mensagem> findByMonitoriaOrderByDataHoraAsc(Monitoria monitoria);
    List<Mensagem> findByAluno(Aluno aluno);
    List<Mensagem> findByMonitor(Monitor monitor);
}
