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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "kt_sous_categorie_produit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KtSousCategorieProduit.findAll", query = "SELECT k FROM KtSousCategorieProduit k"),
    @NamedQuery(name = "KtSousCategorieProduit.findByCode", query = "SELECT k FROM KtSousCategorieProduit k WHERE k.code = :code"),
    @NamedQuery(name = "KtSousCategorieProduit.findByLibelle", query = "SELECT k FROM KtSousCategorieProduit k WHERE k.libelle = :libelle"),
    @NamedQuery(name = "KtSousCategorieProduit.findByDescription", query = "SELECT k FROM KtSousCategorieProduit k WHERE k.description = :description")})
public class KtSousCategorieProduit extends AuditModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code", nullable = false, length = 20)
    private String code;
    @Column(name = "libelle", length = 45)
    private String libelle;
    @Column(name = "description", length = 45)
    private String description;
    @JoinColumn(name = "categorie_produit", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false)
    private KtCategorieProduit categorieProduit;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sousCategorieProduit")
    private List<KtProduit> ktProduitList;

    public KtSousCategorieProduit() {
        super();
    }

    public KtSousCategorieProduit(String code) {
        this.code = code;
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

    public KtCategorieProduit getCategorieProduit() {
        return categorieProduit;
    }

    public void setCategorieProduit(KtCategorieProduit categorieProduit) {
        this.categorieProduit = categorieProduit;
    }

    @XmlTransient
    public List<KtProduit> getKtProduitList() {
        return ktProduitList;
    }

    public void setKtProduitList(List<KtProduit> ktProduitList) {
        this.ktProduitList = ktProduitList;
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
        if (!(object instanceof KtSousCategorieProduit)) {
            return false;
        }
        KtSousCategorieProduit other = (KtSousCategorieProduit) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dc.keating.entities.KtSousCategorieProduit[ code=" + code + " ]";
    }
    
}
