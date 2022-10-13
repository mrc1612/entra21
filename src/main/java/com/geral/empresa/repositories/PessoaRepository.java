package com.geral.empresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geral.empresa.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
    
}
