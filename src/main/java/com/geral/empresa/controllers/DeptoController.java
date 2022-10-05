package com.geral.empresa.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.geral.empresa.domain.Departamento;
import com.geral.empresa.domain.Funcionario;
import com.geral.empresa.exceptions.ObjectNotFoundException;
import com.geral.empresa.repositories.DepartamentoRepository;
import com.geral.empresa.repositories.FuncionarioRepository;
import com.geral.empresa.services.DeptoServices;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/departamentos")
public class DeptoController {

    @Autowired
    private DepartamentoRepository deptoRepository;

    @Autowired
    private FuncionarioRepository fRepository;

    @Autowired
    private DeptoServices dServices;

    @GetMapping
    public ResponseEntity<List<Departamento>> findAll() {
        List<Departamento> departamentos = deptoRepository.findAll();
        return ResponseEntity.ok().body(departamentos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Departamento>> findById(@PathVariable Integer id) {
        Optional<Departamento> departamento = deptoRepository.findById(id);
        return ResponseEntity.ok().body(departamento);
    }

    @GetMapping(value="/{id}/funcionarios")
    public ResponseEntity<List<Funcionario>> findAllByDepto(@PathVariable Integer id) {
        return ResponseEntity.ok().body(fRepository.findAllByDepto(id));
    }

    @PostMapping
    public ResponseEntity<Departamento> insDepto(@Valid @RequestBody Departamento pDepartamento) {
        pDepartamento.setId_depto(null);
        deptoRepository.save(pDepartamento);
        URI vURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pDepartamento.getId_depto()).toUri();
        return ResponseEntity.created(vURI).body(pDepartamento);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delDepartamento(@PathVariable Integer id) {
        dServices.delDepartamento(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Departamento> updDepto(@Valid @PathVariable Integer id,
        @RequestBody Departamento pDepto) {
            Departamento atualDepto =
                deptoRepository.findById(id)
                .orElseThrow(
                    () -> new ObjectNotFoundException("Departamento não encontrado!")
                );
            atualDepto.setNm_depto(pDepto.getNm_depto());
            deptoRepository.save(atualDepto);
            return ResponseEntity.ok().body(atualDepto);
    }
}
