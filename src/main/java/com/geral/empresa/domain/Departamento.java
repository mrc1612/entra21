package com.geral.empresa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class Departamento implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_depto;

    @NotEmpty(message="Campo NM_DEPTO não pode ser vazio!")
    @Length(min=5, max=255, message="Campo NM_DEPTO deve ter entre 5 e 255 caracteres!")
    private String nm_depto;

    @OneToMany(mappedBy = "departamento")
    private List<Funcionario> funcionarios = new ArrayList<>();
    
    public Departamento() {
    }

    public Departamento(Integer id_depto, String nm_depto) {
        this.id_depto = id_depto;
        this.nm_depto = nm_depto;
    }

    public Integer getId_depto() {
        return id_depto;
    }

    public String getNm_depto() {
        return nm_depto;
    }

    public void setId_depto(Integer id_depto) {
        this.id_depto = id_depto;
    }

    public void setNm_depto(String nm_depto) {
        this.nm_depto = nm_depto;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_depto == null) ? 0 : id_depto.hashCode());
        result = prime * result + ((nm_depto == null) ? 0 : nm_depto.hashCode());
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
        Departamento other = (Departamento) obj;
        if (id_depto == null) {
            if (other.id_depto != null)
                return false;
        } else if (!id_depto.equals(other.id_depto))
            return false;
        if (nm_depto == null) {
            if (other.nm_depto != null)
                return false;
        } else if (!nm_depto.equals(other.nm_depto))
            return false;
        return true;
    }
}
