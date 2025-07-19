package ufma.br.sistema_monitoria_ufma.model.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ufma.br.sistema_monitoria_ufma.model.Disciplina;

public interface  DisciplinaRepo
extends JpaRepository<Disciplina,Integer>{
    
    List<Disciplina> findAllByIdIn(List<Integer> ids);
    Optional<Disciplina> findById(Integer id);
}
