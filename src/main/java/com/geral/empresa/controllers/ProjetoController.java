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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.geral.empresa.domain.Pessoa;
import com.geral.empresa.domain.Projeto;
import com.geral.empresa.exceptions.ObjectNotFoundException;
import com.geral.empresa.repositories.PessoaRepository;
import com.geral.empresa.repositories.ProjetoRepository;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {
    @Autowired
    private ProjetoRepository projetoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping
    public ResponseEntity<Projeto> insProjeto(@Valid @RequestBody Projeto pProjeto) {
        pProjeto.setId_projeto(null);
        projetoRepository.save(pProjeto);
        URI vUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pProjeto.getId_projeto()).toUri();
        return ResponseEntity.created(vUri).body(pProjeto);
    }

    @GetMapping
    public ResponseEntity<List<Projeto>> findAll() {
        List<Projeto> projetos = projetoRepository.findAll();
        return ResponseEntity.ok().body(projetos);
    }

    @PostMapping(value = "{id_projeto}/pessoa/{id_pessoa}")
    public ResponseEntity<Void> insProjetoPessoa(@Valid @PathVariable Integer id_projeto, @Valid @PathVariable Integer id_pessoa) {
        Projeto projeto = projetoRepository
            .findById(id_projeto)
            .orElseThrow(
                () -> new ObjectNotFoundException("Projeto "+id_projeto+" não encontrado!")
            );
        List<Pessoa> pessoas = projeto.getPessoas_projeto();
        Pessoa pessoa = pessoaRepository
            .findById(id_pessoa)
            .orElseThrow(
                () -> new ObjectNotFoundException("Pessoa "+id_pessoa+" não encontrada!")
            );
        pessoas.add(pessoa);
        projeto.setPessoas_projeto(pessoas);
        projetoRepository.save(projeto);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping(value = "{id_projeto}/pessoa/{id_pessoa}")
    public ResponseEntity<Void> delProjetoPessoa(@Valid @PathVariable Integer id_projeto, @Valid @PathVariable Integer id_pessoa) {
        Projeto projeto = projetoRepository
            .findById(id_projeto)
            .orElseThrow(
                () -> new ObjectNotFoundException("Projeto "+id_projeto+" não encontrado!")
            );
        List<Pessoa> pessoas = projeto.getPessoas_projeto();
        Pessoa pessoa = pessoaRepository
            .findById(id_pessoa)
            .orElseThrow(
                () -> new ObjectNotFoundException("Pessoa "+id_pessoa+" não encontrada!")
            );
        pessoas.remove(pessoa);
        projeto.setPessoas_projeto(pessoas);
        projetoRepository.save(projeto);
        return ResponseEntity.noContent().build();
    }
}
