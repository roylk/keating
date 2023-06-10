/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dc.keating.entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "kt_categorie_produit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KtCategorieProduit.findAll", query = "SELECT k FROM KtCategorieProduit k"),
    @NamedQuery(name = "KtCategorieProduit.findByCode", query = "SELECT k FROM KtCategorieProduit k WHERE k.code = :code"),
    @NamedQuery(name = "KtCategorieProduit.findByLibelle", query = "SELECT k FROM KtCategorieProduit k WHERE k.libelle = :libelle"),
    @NamedQuery(name = "KtCategorieProduit.findByDescription", query = "SELECT k FROM KtCategorieProduit k WHERE k.description = :description")})
public class KtCategorieProduit extends AuditModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code", nullable = false, length = 20)
    private String code;
    @Basic(optional = false)
    @Column(name = "libelle", nullable = false, length = 45)
    private String libelle;
    @Column(name = "description", length = 45)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorieProduit")
    private List<KtSousCategorieProduit> ktSousCategorieProduitList;

    public KtCategorieProduit() {
        super();
    }

    public KtCategorieProduit(String code) {
        this.code = code;
    }

    public KtCategorieProduit(String code, String libelle) {
        super();
        this.code = code;
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<KtSousCategorieProduit> getKtSousCategorieProduitList() {
        return ktSousCategorieProduitList;
    }

    public void setKtSousCategorieProduitList(List<KtSousCategorieProduit> ktSousCategorieProduitList) {
        this.ktSousCategorieProduitList = ktSousCategorieProduitList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KtCategorieProduit)) {
            return false;
        }
        KtCategorieProduit other = (KtCategorieProduit) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dc.keating.entities.KtCategorieProduit[ code=" + code + " ]";
    }
    
}
