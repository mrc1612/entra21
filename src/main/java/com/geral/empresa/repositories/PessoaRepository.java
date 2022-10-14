package com.geral.empresa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.geral.empresa.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
    @Query("SELECT pessoa FROM Pessoa pessoa JOIN pessoa.projetos_pessoa pp WHERE pp.id_projeto = :pIdProjeto")
    List<Pessoa> findByProjeto(@Param("pIdProjeto") Integer pIdProjeto);
}
