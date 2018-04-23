package com.pruba.BackEnd.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "tont_aves_pais")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class tont_aves_pais implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdpais")
    @JsonIgnore
    private tont_paises tont_paises;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdave")
    @JsonIgnore
    private tont_aves tont_aves;
  
    public tont_aves_pais() {
    }

    public tont_aves_pais(tont_paises tont_paises, tont_aves tont_aves) {
        this.tont_paises = tont_paises;
        this.tont_aves = tont_aves;
    }

    public tont_paises getTont_paises() {
        return tont_paises;
    }

    public void setTont_paises(tont_paises tont_paises) {
        this.tont_paises = tont_paises;
    }

    public tont_aves getTont_aves() {
        return tont_aves;
    }

    public void setTont_aves(tont_aves tont_aves) {
        this.tont_aves = tont_aves;
    }

}
