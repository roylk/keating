/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dc.keating.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "kt_rapport")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KtRapport.findAll", query = "SELECT k FROM KtRapport k"),
    @NamedQuery(name = "KtRapport.findById", query = "SELECT k FROM KtRapport k WHERE k.id = :id"),
    @NamedQuery(name = "KtRapport.findByLibele", query = "SELECT k FROM KtRapport k WHERE k.libele = :libele"),
    @NamedQuery(name = "KtRapport.findByDateDebut", query = "SELECT k FROM KtRapport k WHERE k.dateDebut = :dateDebut"),
    @NamedQuery(name = "KtRapport.findByDateFin", query = "SELECT k FROM KtRapport k WHERE k.dateFin = :dateFin"),
    @NamedQuery(name = "KtRapport.findByNombreTraitement", query = "SELECT k FROM KtRapport k WHERE k.nombreTraitement = :nombreTraitement")})
public class KtRapport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "libele", nullable = false, length = 45)
    private String libele;
    @Basic(optional = false)
    @Column(name = "date_debut", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;
    @Basic(optional = false)
    @Column(name = "date_fin", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    @Column(name = "nombre_traitement")
    private Integer nombreTraitement;
    @Lob
    @Column(name = "description", length = 16777215)
    private String description;

    public KtRapport() {
    }

    public KtRapport(Integer id) {
        this.id = id;
    }

    public KtRapport(Integer id, String libele, Date dateDebut, Date dateFin) {
        this.id = id;
        this.libele = libele;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibele() {
        return libele;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Integer getNombreTraitement() {
        return nombreTraitement;
    }

    public void setNombreTraitement(Integer nombreTraitement) {
        this.nombreTraitement = nombreTraitement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KtRapport)) {
            return false;
        }
        KtRapport other = (KtRapport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dc.keating.entities.KtRapport[ id=" + id + " ]";
    }
    
}
