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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "kt_ville", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KtVille.findAll", query = "SELECT k FROM KtVille k"),
    @NamedQuery(name = "KtVille.findById", query = "SELECT k FROM KtVille k WHERE k.id = :id"),
    @NamedQuery(name = "KtVille.findByCode", query = "SELECT k FROM KtVille k WHERE k.code = :code"),
    @NamedQuery(name = "KtVille.findByDateCreation", query = "SELECT k FROM KtVille k WHERE k.dateCreation = :dateCreation")})
public class KtVille extends AuditModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "code", nullable = false, length = 5)
    private String code;
    @Column(name = "nom", nullable = false, length = 30)
    private String nom;
    /*@Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;*/
    @JoinColumn(name = "region", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private KtRegion region;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "ville")
    private List<KtFournisseur> ktFournisseurList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ville")
    private List<KtPointDeVente> ktPointDeVenteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ville")
    private List<KtCommercant> ktCommercantList;*/
    

    public KtVille() {
        super();
    }

    public KtVille(Integer id) {
        this.id = id;
    }

    public KtVille(Integer id, String code) {
        this.id = id;
        this.code = code;
    }
    
     public KtVille(String code,String nom, KtRegion region) {
         super();
        //this.id = id;
        this.code = code;
        this.nom = nom;
        //this.dateCreation = dateCreation;
        this.region = region;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /*public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }*/

    public KtRegion getRegion() {
        return region;
    }

    public void setRegion(KtRegion region) {
        this.region = region;
    }

    /*@XmlTransient
    public List<KtFournisseur> getKtFournisseurList() {
        return ktFournisseurList;
    }

    public void setKtFournisseurList(List<KtFournisseur> ktFournisseurList) {
        this.ktFournisseurList = ktFournisseurList;
    }

    @XmlTransient
    public List<KtPointDeVente> getKtPointDeVenteList() {
        return ktPointDeVenteList;
    }

    public void setKtPointDeVenteList(List<KtPointDeVente> ktPointDeVenteList) {
        this.ktPointDeVenteList = ktPointDeVenteList;
    }

    @XmlTransient
    public List<KtCommercant> getKtCommercantList() {
        return ktCommercantList;
    }

    public void setKtCommercantList(List<KtCommercant> ktCommercantList) {
        this.ktCommercantList = ktCommercantList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KtVille)) {
            return false;
        }
        KtVille other = (KtVille) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dc.keating.entities.KtVille[ id=" + id + " ]";
    }
    
}
