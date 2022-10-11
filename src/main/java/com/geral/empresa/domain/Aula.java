package com.geral.empresa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Aula implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_aula;
    private String nm_aula;

    @OneToMany(mappedBy = "aula_pai")
    private List<ProfAula> professores = new ArrayList<>();

    public Aula(Integer id_aula, String nm_aula) {
        this.id_aula = id_aula;
        this.nm_aula = nm_aula;
    }
    public Aula() {
    }
    public Integer getId_aula() {
        return id_aula;
    }
    public void setId_aula(Integer id_aula) {
        this.id_aula = id_aula;
    }
    public String getNm_aula() {
        return nm_aula;
    }
    public void setNm_aula(String nm_aula) {
        this.nm_aula = nm_aula;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_aula == null) ? 0 : id_aula.hashCode());
        result = prime * result + ((nm_aula == null) ? 0 : nm_aula.hashCode());
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
        Aula other = (Aula) obj;
        if (id_aula == null) {
            if (other.id_aula != null)
                return false;
        } else if (!id_aula.equals(other.id_aula))
            return false;
        if (nm_aula == null) {
            if (other.nm_aula != null)
                return false;
        } else if (!nm_aula.equals(other.nm_aula))
            return false;
        return true;
    }
    
}
