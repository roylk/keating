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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "kt_produit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KtProduit.findAll", query = "SELECT k FROM KtProduit k"),
    @NamedQuery(name = "KtProduit.findByCode", query = "SELECT k FROM KtProduit k WHERE k.code = :code"),
    @NamedQuery(name = "KtProduit.findByLibelle", query = "SELECT k FROM KtProduit k WHERE k.libelle = :libelle"),
    @NamedQuery(name = "KtProduit.findByNutriscore", query = "SELECT k FROM KtProduit k WHERE k.nutriscore = :nutriscore"),
    @NamedQuery(name = "KtProduit.findByDlc", query = "SELECT k FROM KtProduit k WHERE k.dlc = :dlc"),
    @NamedQuery(name = "KtProduit.findByDdm", query = "SELECT k FROM KtProduit k WHERE k.ddm = :ddm"),
    @NamedQuery(name = "KtProduit.findByVolumeUnitaire", query = "SELECT k FROM KtProduit k WHERE k.volumeUnitaire = :volumeUnitaire"),
    @NamedQuery(name = "KtProduit.findByPoidsUnitaire", query = "SELECT k FROM KtProduit k WHERE k.poidsUnitaire = :poidsUnitaire"),
    @NamedQuery(name = "KtProduit.findByQuantite", query = "SELECT k FROM KtProduit k WHERE k.quantite = :quantite")})
public class KtProduit implements Serializable {

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
    @Temporal(TemporalType.TIMESTAMP)
    private Date dlc;
    @Column(name = "ddm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ddm;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "volume_unitaire", precision = 22, scale = 0)
    private Double volumeUnitaire;
    @Column(name = "poids_unitaire", precision = 22, scale = 0)
    private Double poidsUnitaire;
    @Column(name = "quantite", precision = 22, scale = 0)
    private Double quantite;
    @JoinColumn(name = "point_de_vente", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false)
    private KtPointDeVente pointDeVente;

    public KtProduit() {
    }

    public KtProduit(String code) {
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

    public String getNutriscore() {
        return nutriscore;
    }

    public void setNutriscore(String nutriscore) {
        this.nutriscore = nutriscore;
    }

    public Date getDlc() {
        return dlc;
    }

    public void setDlc(Date dlc) {
        this.dlc = dlc;
    }

    public Date getDdm() {
        return ddm;
    }

    public void setDdm(Date ddm) {
        this.ddm = ddm;
    }

    public Double getVolumeUnitaire() {
        return volumeUnitaire;
    }

    public void setVolumeUnitaire(Double volumeUnitaire) {
        this.volumeUnitaire = volumeUnitaire;
    }

    public Double getPoidsUnitaire() {
        return poidsUnitaire;
    }

    public void setPoidsUnitaire(Double poidsUnitaire) {
        this.poidsUnitaire = poidsUnitaire;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public KtPointDeVente getPointDeVente() {
        return pointDeVente;
    }

    public void setPointDeVente(KtPointDeVente pointDeVente) {
        this.pointDeVente = pointDeVente;
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
