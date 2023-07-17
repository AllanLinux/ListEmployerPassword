package br.com.allanlf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.allanlf.model.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long>{

}
