package com.pruba.BackEnd.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "tont_paises")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class tont_paises implements Serializable {

    @Id
    @Column(name = "cdpais")
    private String cdpais;

    @NotBlank
    @Column(name = "dsnombre")
    private String dsnombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cdzona")
    @JsonIgnore
    private tont_zonas tont_zonas;

    @OneToMany(mappedBy = "tont_paises", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<tont_aves_pais> aves_pais = new ArrayList<tont_aves_pais>();

    public tont_paises() {
    }

    public tont_paises(String cdpais, String dsnombre, tont_zonas tont_zonas) {
        this.cdpais = cdpais;
        this.dsnombre = dsnombre;
        this.tont_zonas = tont_zonas;
    }

    public String getCdpais() {
        return cdpais;
    }

    public void setCdpais(String cdpais) {
        this.cdpais = cdpais;
    }

    public String getDsnombre() {
        return dsnombre;
    }

    public void setDsnombre(String dsnombre) {
        this.dsnombre = dsnombre;
    }

    public tont_zonas getTont_zonas() {
        return tont_zonas;
    }

    public void setTont_zonas(tont_zonas tont_zonas) {
        this.tont_zonas = tont_zonas;
    }

    @XmlTransient
    public List<tont_aves_pais> getAves_pais() {
        return aves_pais;
    }

    public void setAves_pais(List<tont_aves_pais> aves_pais) {
        this.aves_pais = aves_pais;
    }

}
