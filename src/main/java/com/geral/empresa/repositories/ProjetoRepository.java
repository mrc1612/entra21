package com.geral.empresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geral.empresa.domain.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer>{

}
