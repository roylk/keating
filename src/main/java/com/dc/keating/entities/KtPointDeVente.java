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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "kt_point_de_vente", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KtPointDeVente.findAll", query = "SELECT k FROM KtPointDeVente k"),
    @NamedQuery(name = "KtPointDeVente.findByCode", query = "SELECT k FROM KtPointDeVente k WHERE k.code = :code"),
    @NamedQuery(name = "KtPointDeVente.findByNom", query = "SELECT k FROM KtPointDeVente k WHERE k.nom = :nom"),
    @NamedQuery(name = "KtPointDeVente.findByEmail", query = "SELECT k FROM KtPointDeVente k WHERE k.email = :email"),
    @NamedQuery(name = "KtPointDeVente.findByTelephone", query = "SELECT k FROM KtPointDeVente k WHERE k.telephone = :telephone"),
    @NamedQuery(name = "KtPointDeVente.findByStatut", query = "SELECT k FROM KtPointDeVente k WHERE k.statut = :statut"),
    @NamedQuery(name = "KtPointDeVente.findByAdresse", query = "SELECT k FROM KtPointDeVente k WHERE k.adresse = :adresse")})
public class KtPointDeVente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code", nullable = false, length = 45)
    private String code;
    @Basic(optional = false)
    @Column(name = "nom", nullable = false, length = 45)
    private String nom;
    @Basic(optional = false)
    @Column(name = "email", nullable = false, length = 45)
    private String email;
    @Basic(optional = false)
    @Column(name = "telephone", nullable = false, length = 45)
    private String telephone;
    @Basic(optional = false)
    @Column(name = "statut", nullable = false)
    private short statut;
    @Basic(optional = false)
    @Column(name = "adresse", nullable = false, length = 45)
    private String adresse;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pointDeVente")
    private List<KtProduit> ktProduitList;
    @OneToMany(mappedBy = "pointDeVente")
    private List<UfTerminal> ufTerminalList;
    @JoinColumn(name = "commercant_code", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false)
    private KtCommercant commercantCode;
    @JoinColumn(name = "ville", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private KtVille ville;

    public KtPointDeVente() {
    }

    public KtPointDeVente(String code) {
        this.code = code;
    }

    public KtPointDeVente(String code, String nom, String email, String telephone, short statut, String adresse) {
        this.code = code;
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
        this.statut = statut;
        this.adresse = adresse;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public short getStatut() {
        return statut;
    }

    public void setStatut(short statut) {
        this.statut = statut;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @XmlTransient
    public List<KtProduit> getKtProduitList() {
        return ktProduitList;
    }

    public void setKtProduitList(List<KtProduit> ktProduitList) {
        this.ktProduitList = ktProduitList;
    }

    @XmlTransient
    public List<UfTerminal> getUfTerminalList() {
        return ufTerminalList;
    }

    public void setUfTerminalList(List<UfTerminal> ufTerminalList) {
        this.ufTerminalList = ufTerminalList;
    }

    public KtCommercant getCommercantCode() {
        return commercantCode;
    }

    public void setCommercantCode(KtCommercant commercantCode) {
        this.commercantCode = commercantCode;
    }

    public KtVille getVille() {
        return ville;
    }

    public void setVille(KtVille ville) {
        this.ville = ville;
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
        if (!(object instanceof KtPointDeVente)) {
            return false;
        }
        KtPointDeVente other = (KtPointDeVente) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dc.keating.entities.KtPointDeVente[ code=" + code + " ]";
    }
    
}
