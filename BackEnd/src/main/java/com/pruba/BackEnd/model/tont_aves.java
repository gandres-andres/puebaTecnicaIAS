package com.pruba.BackEnd.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "tont_aves")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class tont_aves implements Serializable {

    @Id
    @Column(name = "cdave")
    private String cdave;

    @NotBlank
    @Column(name = "dsnombre_comun")
    private String dsnombre_comun;

    @NotBlank
    @Column(name = "dsnombre_cientifico")
    private String dsnombre_cientifico;

    @OneToMany(mappedBy = "tont_aves", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<tont_aves_pais> aves_pais = new ArrayList<tont_aves_pais>();

    public tont_aves() {
    }

    public tont_aves(String cdave, String dsnombre_comun, String dsnombre_cientifico) {
        this.cdave = cdave;
        this.dsnombre_comun = dsnombre_comun;
        this.dsnombre_cientifico = dsnombre_cientifico;
    }

    public String getCdave() {
        return cdave;
    }

    public void setCdave(String cdave) {
        this.cdave = cdave;
    }

    public String getDsnombre_comun() {
        return dsnombre_comun;
    }

    public void setDsnombre_comun(String dsnombre_comun) {
        this.dsnombre_comun = dsnombre_comun;
    }

    public String getDsnombre_cientifico() {
        return dsnombre_cientifico;
    }

    public void setDsnombre_cientifico(String dsnombre_cientifico) {
        this.dsnombre_cientifico = dsnombre_cientifico;
    }

    @XmlTransient
    public List<tont_aves_pais> getAves_pais() {
        return aves_pais;
    }

    public void setAves_pais(List<tont_aves_pais> aves_pais) {
        this.aves_pais = aves_pais;
    }

}
