package ufma.br.sistema_monitoria_ufma.model.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ufma.br.sistema_monitoria_ufma.model.Material;
import ufma.br.sistema_monitoria_ufma.model.Monitoria;

public interface  MaterialRepo 
extends JpaRepository<Material, Integer> {

    List<Material> findByMonitoria(Monitoria monitoria);
}

