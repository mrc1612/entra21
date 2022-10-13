package com.geral.empresa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Projeto implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_projeto;
    private String nm_projeto;

    @ManyToMany
    @JoinTable(
        name="projeto_pessoa",
        joinColumns = @JoinColumn(name="id_projeto"),
        inverseJoinColumns = @JoinColumn(name="id_pessoa")
    )
    @JsonIgnore
    private List<Pessoa> pessoas_projeto = new ArrayList<>();

    public Projeto(Integer id_projeto, String nm_projeto) {
        this.id_projeto = id_projeto;
        this.nm_projeto = nm_projeto;
    }
    public Projeto() {
    }
    public Integer getId_projeto() {
        return id_projeto;
    }
    public void setId_projeto(Integer id_projeto) {
        this.id_projeto = id_projeto;
    }
    public String getNm_projeto() {
        return nm_projeto;
    }
    public void setNm_projeto(String nm_projeto) {
        this.nm_projeto = nm_projeto;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_projeto == null) ? 0 : id_projeto.hashCode());
        result = prime * result + ((nm_projeto == null) ? 0 : nm_projeto.hashCode());
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
        Projeto other = (Projeto) obj;
        if (id_projeto == null) {
            if (other.id_projeto != null)
                return false;
        } else if (!id_projeto.equals(other.id_projeto))
            return false;
        if (nm_projeto == null) {
            if (other.nm_projeto != null)
                return false;
        } else if (!nm_projeto.equals(other.nm_projeto))
            return false;
        return true;
    }
    public List<Pessoa> getPessoas_projeto() {
        return pessoas_projeto;
    }
    public void setPessoas_projeto(List<Pessoa> pessoas_projeto) {
        this.pessoas_projeto = pessoas_projeto;
    }
    
}
