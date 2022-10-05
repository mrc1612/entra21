package com.geral.empresa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geral.empresa.repositories.DepartamentoRepository;

@Service
public class DeptoServices {

    @Autowired
    DepartamentoRepository dRepository;

    public void delDepartamento(Integer pId) {
        try {
            dRepository.deleteById(pId);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new com.geral.empresa.exceptions.DataIntegrityViolationException("Departamento não pode ser deletado! Possui funcionários alocados!");
        }
    }

}
