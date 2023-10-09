/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dc.keating.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author user
 */
@Entity
@Table(name = "kt_produit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KtProduit.findAll", query = "SELECT k FROM KtProduit k"),
    @NamedQuery(name = "KtProduit.findByCode", query = "SELECT k FROM KtProduit k WHERE k.code = :code"),
    @NamedQuery(name = "KtProduit.findByLibelle", query = "SELECT k FROM KtProduit k WHERE k.libelle = :libelle"),
    @NamedQuery(name = "KtProduit.findByNutriscore", query = "SELECT k FROM KtProduit k WHERE k.nutriscore = :nutriscore"),
    @NamedQuery(name = "KtProduit.findByDlc", query = "SELECT k FROM KtProduit k WHERE k.dlc = :dlc"),
    @NamedQuery(name = "KtProduit.findByDdm", query = "SELECT k FROM KtProduit k WHERE k.ddm = :ddm"),
    //@NamedQuery(name = "KtProduit.findByVolumeUnitaire", query = "SELECT k FROM KtProduit k WHERE k.volumeUnitaire = :volumeUnitaire"),
   // @NamedQuery(name = "KtProduit.findByPoidsUnitaire", query = "SELECT k FROM KtProduit k WHERE k.poidsUnitaire = :poidsUnitaire"),
    @NamedQuery(name = "KtProduit.findByQuantiteUnitaire", query = "SELECT k FROM KtProduit k WHERE k.quantiteUnitaire = :quantiteUnitaire")})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "NATURE_PROD", discriminatorType = DiscriminatorType.STRING, length = 6)
public class KtProduit extends AuditModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code", nullable = false, length = 20)
    private String code;
    @Column(name = "libelle", length = 45)
    private String libelle;
    @Column(name = "nutriscore", length = 4)
    private String nutriscore;
    @Column(name = "dlc")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dlc;
    @Column(name = "ddm")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime ddm;
     @Column(name = "packaging", precision = 22, scale = 0)
    private Double packaging ;
    @Column(name = "quantite_unitaire", precision = 22, scale = 0)
    private Double quantiteUnitaire;
    @Column(name = "quantite_totale", precision = 22, scale = 0)
    private Double quantiteTotale;
    @Column(nullable = false)
    private short statut;
    @JoinColumn(name = "sous_categorie_produit", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false)
    private KtSousCategorieProduit sousCategorieProduit;
    @JoinColumn(name = "point_de_vente", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false)
    private KtPointDeVente pointDeVente;
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KtProduit)) {
            return false;
        }
        KtProduit other = (KtProduit) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dc.keating.entities.KtProduit[ code=" + code + " ]";
    }
    
}
