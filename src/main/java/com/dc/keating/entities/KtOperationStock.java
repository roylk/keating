/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dc.keating.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author user
 */
@Entity
@Table(name = "kt_Operation_stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KtOperationStock.findAll", query = "SELECT k FROM KtOperationStock k"),
    /*@NamedQuery(name = "KtOperationStock.findByCode", query = "SELECT k FROM KtOperationStock k WHERE k.code = :code"),
    @NamedQuery(name = "KtProduit.findByLibelle", query = "SELECT k FROM KtProduit k WHERE k.libelle = :libelle"),
    @NamedQuery(name = "KtProduit.findByNutriscore", query = "SELECT k FROM KtProduit k WHERE k.nutriscore = :nutriscore"),
    @NamedQuery(name = "KtProduit.findByDlc", query = "SELECT k FROM KtProduit k WHERE k.dlc = :dlc"),
    @NamedQuery(name = "KtProduit.findByDdm", query = "SELECT k FROM KtProduit k WHERE k.ddm = :ddm"),
    //@NamedQuery(name = "KtProduit.findByVolumeUnitaire", query = "SELECT k FROM KtProduit k WHERE k.volumeUnitaire = :volumeUnitaire"),
   // @NamedQuery(name = "KtProduit.findByPoidsUnitaire", query = "SELECT k FROM KtProduit k WHERE k.poidsUnitaire = :poidsUnitaire"),
    @NamedQuery(name = "KtProduit.findByQuantiteUnitaire", query = "SELECT k FROM KtProduit k WHERE k.quantiteUnitaire = :quantiteUnitaire")*/})

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public  class  KtOperationStock extends AuditModel implements Serializable {
    
    private static final long serialVersionUID = 1L; 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    //@Column(name = "code", nullable = false, length = 10) 
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "quantite", precision = 22, scale = 0)
    private Double quantite;
    @Column(name = "nom", nullable = false, length = 45)
    private String nom;
    @Column(name = "description", nullable = false, length = 100)
    private  String description;
    
    @JoinColumn(name = "produit", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false)
    private KtProduit produit;

    public KtOperationStock(Long id, Double quantite, String nom, String description, KtProduit produit) {
        super();
        this.id = id;
        this.quantite = quantite;
        this.nom = nom;
        this.description = description;
        this.produit = produit;
    }

    public KtOperationStock(Double quantite, KtProduit produit) {
        this.quantite = quantite;
        this.produit = produit;
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
        if (!(object instanceof KtOperationStock)) {
            return false;
        }
        KtOperationStock other = (KtOperationStock) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dc.keating.entities.KtOperationStock[ code=" + id + " ]";
    }
}
