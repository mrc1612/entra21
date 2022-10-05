package com.geral.empresa.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralController {

    @GetMapping("/")
    public String index() {
        return "Olá, mundo!";
    }

    @PostMapping("/")
    public String indexPost() {
        return "Agora com POST!";
    }

    @GetMapping("/teste")
    public String outroIndex() {
        return "Usando URI teste";
    }

    @GetMapping("/teste/{parametro}")
    public String comParametro(@PathVariable Integer parametro) {
        return "Você passou "+parametro+" como parâmetro";
    }
    
}
