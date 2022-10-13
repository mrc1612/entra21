package com.geral.empresa.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.geral.empresa.domain.Funcionario;
import com.geral.empresa.repositories.FuncionarioRepository;
import com.geral.empresa.services.FuncServices;

@RestController
@RequestMapping(value="/funcionarios")
public class FuncController {

    @Autowired
    private FuncServices fServices;

    @Autowired
    private FuncionarioRepository fRepository;

    @GetMapping
    public ResponseEntity<List<Funcionario>> findAll() {
        List<Funcionario> funcionarios = fServices.findAll();
        return ResponseEntity.ok().body(funcionarios);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable Integer id) {
        Funcionario funcionario = fServices.findById(id);
        return ResponseEntity.ok().body(funcionario);
    }

    @GetMapping(value="/nome/{nome}")
    public ResponseEntity<List<Funcionario>> findAllByName(@PathVariable String nome) {
        List<Funcionario> funcionarios = fRepository.findAllByName(nome);
        return ResponseEntity.ok().body(funcionarios);
    }

    @GetMapping("/maxId")
    public ResponseEntity<Integer> getMaxId() {
        Integer maxId = fRepository.getMaxId();
        if (maxId == null) {
            maxId = 0;
        }
        return ResponseEntity.ok().body(maxId);
    }

    @PostMapping(value="/{idDepto}")
    public ResponseEntity<Funcionario> insFunc(@PathVariable Integer idDepto, @Valid @RequestBody Funcionario pFuncionario) {
        Funcionario novoFuncionario = fServices.insFunc(pFuncionario, idDepto);
        URI vURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoFuncionario.getId_funcionario()).toUri();
        return ResponseEntity.created(vURI).body(novoFuncionario);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Funcionario> updFunc(@PathVariable Integer id, @Valid @RequestBody Funcionario pFuncionario) {
        Funcionario novoFuncionario = fServices.updFunc(id, pFuncionario);
        URI vURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoFuncionario.getId_funcionario()).toUri();
        return ResponseEntity.created(vURI).body(novoFuncionario);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delFunc(@PathVariable Integer id) {
        fServices.delFunc(id);
        return ResponseEntity.noContent().build();
    }
}
