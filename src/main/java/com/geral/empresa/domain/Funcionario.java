package com.geral.empresa.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class Funcionario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_funcionario;

    @NotEmpty(message= "Campo NM_FUNCIONARIO não pode ser vazio!")
    @Length(min=5, max=255, message="Campo NM_FUNCIONARIO deve ter entre 5 e 255 caracteres!")
    private String nm_funcionario;

    @ManyToOne
    @JoinColumn(name = "id_depto")
    private Departamento departamento;

    public Funcionario() {
    }

    public Funcionario(Integer id_funcionario,
            String nm_funcionario,
            Departamento departamento) {
        this.id_funcionario = id_funcionario;
        this.nm_funcionario = nm_funcionario;
        this.departamento = departamento;
    }

    public Integer getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(Integer id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getNm_funcionario() {
        return nm_funcionario;
    }

    public void setNm_funcionario(String nm_funcionario) {
        this.nm_funcionario = nm_funcionario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_funcionario == null) ? 0 : id_funcionario.hashCode());
        result = prime * result + ((nm_funcionario == null) ? 0 : nm_funcionario.hashCode());
        result = prime * result + ((departamento == null) ? 0 : departamento.hashCode());
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
        Funcionario other = (Funcionario) obj;
        if (id_funcionario == null) {
            if (other.id_funcionario != null)
                return false;
        } else if (!id_funcionario.equals(other.id_funcionario))
            return false;
        if (nm_funcionario == null) {
            if (other.nm_funcionario != null)
                return false;
        } else if (!nm_funcionario.equals(other.nm_funcionario))
            return false;
        if (departamento == null) {
            if (other.departamento != null)
                return false;
        } else if (!departamento.equals(other.departamento))
            return false;
        return true;
    }


    
}
