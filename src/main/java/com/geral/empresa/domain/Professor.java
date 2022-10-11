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
public class Professor implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_professor;
    private String nm_professor;

    @OneToMany(mappedBy = "professor_pai")
    private List<ProfAula> aulas = new ArrayList<>();


    public Professor(Integer id_professor, String nm_professor) {
        this.id_professor = id_professor;
        this.nm_professor = nm_professor;
    }
    public Professor() {
    }
    public Integer getId_professor() {
        return id_professor;
    }
    public void setId_professor(Integer id_professor) {
        this.id_professor = id_professor;
    }
    public String getNm_professor() {
        return nm_professor;
    }
    public void setNm_professor(String nm_professor) {
        this.nm_professor = nm_professor;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_professor == null) ? 0 : id_professor.hashCode());
        result = prime * result + ((nm_professor == null) ? 0 : nm_professor.hashCode());
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
        Professor other = (Professor) obj;
        if (id_professor == null) {
            if (other.id_professor != null)
                return false;
        } else if (!id_professor.equals(other.id_professor))
            return false;
        if (nm_professor == null) {
            if (other.nm_professor != null)
                return false;
        } else if (!nm_professor.equals(other.nm_professor))
            return false;
        return true;
    }
    
}
