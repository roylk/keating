/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dc.keating.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "kt_pays", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KtPays.findAll", query = "SELECT k FROM KtPays k"),
    @NamedQuery(name = "KtPays.findByCode", query = "SELECT k FROM KtPays k WHERE k.code = :code"),
    @NamedQuery(name = "KtPays.findByNom", query = "SELECT k FROM KtPays k WHERE k.nom = :nom"),
    @NamedQuery(name = "KtPays.findByDateCreation", query = "SELECT k FROM KtPays k WHERE k.dateCreation = :dateCreation")})
public class KtPays extends AuditModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code", nullable = false, length = 5)
    private String code;
    @Basic(optional = false)
    @Column(name = "nom", nullable = false, length = 45)
    private String nom;
    /*@Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;*/
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "pays")
    private List<KtRegion> ktRegionList;*/

    public KtPays() {
    }

    public KtPays(String code) {
        this.code = code;
    }

    public KtPays(String code, String nom) {
        super();
        this.code = code;
        this.nom = nom;
    }
    
     /*public KtPays(String code, String nom, Date dateCreation) {
        this.code = code;
        this.nom = nom;
        //this.dateCreation = dateCreation;
    }*/

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    /*public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }*/

   /* @XmlTransient
    public List<KtRegion> getKtRegionList() {
        return ktRegionList;
    }

    public void setKtRegionList(List<KtRegion> ktRegionList) {
        this.ktRegionList = ktRegionList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KtPays)) {
            return false;
        }
        KtPays other = (KtPays) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dc.keating.entities.KtPays[ code=" + code + " ]";
    }
    
}