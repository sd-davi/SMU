package ufma.br.sistema_monitoria_ufma.model.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import ufma.br.sistema_monitoria_ufma.model.Curso;

public interface CursoRepo 
extends JpaRepository <Curso, Integer> {
    
}
