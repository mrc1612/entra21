package com.geral.empresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geral.empresa.domain.Departamento;
import com.geral.empresa.domain.Funcionario;
import com.geral.empresa.exceptions.ObjectNotFoundException;
import com.geral.empresa.repositories.DepartamentoRepository;
import com.geral.empresa.repositories.FuncionarioRepository;

@Service
public class FuncServices {

    @Autowired
    private FuncionarioRepository fRepository;

    @Autowired
    private DepartamentoRepository dRepository;

    public List<Funcionario> findAll() {
        return fRepository.findAll();
    }

    public Funcionario findById(Integer id) {
        Optional<Funcionario> funcionario = fRepository.findById(id);
        return funcionario.orElseThrow(
            () -> new ObjectNotFoundException("Objeto não encontrado! Id: "+id+", Tipo: "+Funcionario.class.getName())
        );
    }

    public Funcionario insFunc(Funcionario pFuncionario, Integer pIdDepto) {
        Departamento deptoFunc =
            dRepository
                .findById(pIdDepto)
                .orElseThrow(
                    () -> new ObjectNotFoundException("Departamento "+pIdDepto+" não encontrado!")
                );
        pFuncionario.setId_funcionario(null);
        pFuncionario.setDepartamento(deptoFunc);
        return fRepository.save(pFuncionario);
    }

    public Funcionario updFunc(Integer pId, Funcionario pFuncionario) {
        Funcionario funcAtual =
            fRepository
                .findById(pId)
                .orElseThrow(
                    () -> new ObjectNotFoundException("Funcionario "+pId+" não encontrado!")
                );
        funcAtual.setNm_funcionario(pFuncionario.getNm_funcionario());
        return fRepository.save(funcAtual);
    }

    public void delFunc(Integer pId) {
        try {
            fRepository.deleteById(pId);
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            throw new com.geral.empresa.exceptions.EmptyResultDataAccessException("Funcionário "+pId+" não existe!");
        }
    }
}
