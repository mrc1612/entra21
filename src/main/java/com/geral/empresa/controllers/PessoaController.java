package com.geral.empresa.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.geral.empresa.domain.Pessoa;
import com.geral.empresa.repositories.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping
    public ResponseEntity<Pessoa> insPessoa(@Valid @RequestBody Pessoa pPessoa) {
        pPessoa.setId_pessoa(null);
        pessoaRepository.save(pPessoa);
        URI vUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pPessoa.getId_pessoa()).toUri();
        return ResponseEntity.created(vUri).body(pPessoa);
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        return ResponseEntity.ok().body(pessoas);
    }
}
