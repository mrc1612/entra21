package com.geral.empresa.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.geral.empresa.services.FuncServices;

@RestController
public class GeneralController {

    @Autowired
    private FuncServices fServices;

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
    
    @GetMapping(value = "/geraJSON", produces = "application/json")
    @ResponseBody
    public String retornaJSON(@RequestBody Map<String, Object> inputJSON) {
        String retorno  = "";
        if (fServices.validaUsuario(inputJSON.get("login").toString(), inputJSON.get("senha").toString())) {
            retorno = "true";
        } else {
            retorno = "false";
        }
        return "{ \"mensagem\": "+retorno+" }";
    }
}
