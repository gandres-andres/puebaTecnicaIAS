package com.pruba.BackEnd.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "tont_zonas")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class tont_zonas implements Serializable {

    @Id
    @Column(name = "cdzona")
    private String cdzona;

    @NotBlank
    @Column(name = "dsnombre")
    private String dsnombre;

    @OneToMany(mappedBy = "tont_zonas", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<tont_paises> paises = new ArrayList<tont_paises>();
    

    public tont_zonas() {
    }

    public tont_zonas(String cdzona, String dsnombre) {
        this.cdzona = cdzona;
        this.dsnombre = dsnombre;
    }

    public String getCdzona() {
        return cdzona;
    }

    public void setCdzona(String cdzona) {
        this.cdzona = cdzona;
    }

    public String getDsnombre() {
        return dsnombre;
    }

    public void setDsnombre(String dsnombre) {
        this.dsnombre = dsnombre;
    }

    @XmlTransient
    public List<tont_paises> getPaises() {
        return paises;
    }

    public void setPaises(List<tont_paises> paises) {
        this.paises = paises;
    }

}
