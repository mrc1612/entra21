package com.geral.empresa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pessoa implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pessoa;
    private String nm_pessoa;
    
    @ManyToMany(mappedBy = "pessoas_projeto")
    @JsonIgnore
    private List<Projeto> projetos_pessoa = new ArrayList<>();

    public Pessoa(Integer id_pessoa, String nm_pessoa) {
        this.id_pessoa = id_pessoa;
        this.nm_pessoa = nm_pessoa;
    }
    public Pessoa() {
    }
    public Integer getId_pessoa() {
        return id_pessoa;
    }
    public void setId_pessoa(Integer id_pessoa) {
        this.id_pessoa = id_pessoa;
    }
    public String getNm_pessoa() {
        return nm_pessoa;
    }
    public void setNm_pessoa(String nm_pessoa) {
        this.nm_pessoa = nm_pessoa;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_pessoa == null) ? 0 : id_pessoa.hashCode());
        result = prime * result + ((nm_pessoa == null) ? 0 : nm_pessoa.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        if (id_pessoa == null) {
            if (other.id_pessoa != null)
                return false;
        } else if (!id_pessoa.equals(other.id_pessoa))
            return false;
        if (nm_pessoa == null) {
            if (other.nm_pessoa != null)
                return false;
        } else if (!nm_pessoa.equals(other.nm_pessoa))
            return false;
        return true;
    }
    public List<Projeto> getProjetos_pessoa() {
        return projetos_pessoa;
    }
    public void setProjetos_pessoa(List<Projeto> projetos_pessoa) {
        this.projetos_pessoa = projetos_pessoa;
    }

    
}
