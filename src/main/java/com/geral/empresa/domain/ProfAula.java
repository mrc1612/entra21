package com.geral.empresa.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProfAula {
    @EmbeddedId
    private ProfAulaClass profAula;

    @ManyToOne
    @JoinColumn(name = "id_professor", updatable = false, insertable = false)
    private Professor professor_pai;
    
    @ManyToOne
    @JoinColumn(name = "id_aula", updatable = false, insertable = false)
    private Aula aula_pai;
    
}
