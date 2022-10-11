package com.geral.empresa.domain;

import java.io.Serializable;

public class ProfAulaClass implements Serializable{
    private Integer id_professor;
    private String id_aula;
    
    public ProfAulaClass(Integer id_professor, String id_aula) {
        this.id_professor = id_professor;
        this.id_aula = id_aula;
    }
    public ProfAulaClass() {
    }
    public Integer getId_professor() {
        return id_professor;
    }
    public void setId_professor(Integer id_professor) {
        this.id_professor = id_professor;
    }
    public String getId_aula() {
        return id_aula;
    }
    public void setId_aula(String id_aula) {
        this.id_aula = id_aula;
    }
    
    
}
