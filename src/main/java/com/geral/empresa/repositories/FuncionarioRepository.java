package com.geral.empresa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.geral.empresa.domain.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{

    @Query("SELECT f_objeto FROM Funcionario f_objeto WHERE f_objeto.departamento_pai.id_depto = :pIdDepto ORDER BY nm_funcionario")
    List<Funcionario> findAllByDepto(@Param(value = "pIdDepto") Integer pIdDepto);

    @Query("SELECT f_objeto FROM Funcionario f_objeto WHERE f_objeto.nm_funcionario like %:pNome% ORDER BY nm_funcionario")
    List<Funcionario> findAllByName(@Param(value = "pNome") String pNome);

    @Query("SELECT max(f_objeto.id) FROM Funcionario f_objeto")
    Integer getMaxId();
}
