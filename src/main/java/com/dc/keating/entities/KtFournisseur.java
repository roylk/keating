/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dc.keating.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "kt_fournisseur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KtFournisseur.findAll", query = "SELECT k FROM KtFournisseur k"),
    @NamedQuery(name = "KtFournisseur.findByCode", query = "SELECT k FROM KtFournisseur k WHERE k.code = :code"),
    @NamedQuery(name = "KtFournisseur.findByNom", query = "SELECT k FROM KtFournisseur k WHERE k.nom = :nom"),
    @NamedQuery(name = "KtFournisseur.findByEmail", query = "SELECT k FROM KtFournisseur k WHERE k.email = :email"),
    @NamedQuery(name = "KtFournisseur.findByTelephone", query = "SELECT k FROM KtFournisseur k WHERE k.telephone = :telephone"),
    @NamedQuery(name = "KtFournisseur.findByAdresse", query = "SELECT k FROM KtFournisseur k WHERE k.adresse = :adresse")})
public class KtFournisseur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code", nullable = false, length = 20)
    private String code;
    @Column(name = "nom", length = 45)
    private String nom;
    @Column(name = "email", length = 45)
    private String email;
    @Column(name = "telephone", length = 45)
    private String telephone;
    @Column(name = "adresse", length = 45)
    private String adresse;
    @JoinColumn(name = "ville", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private KtVille ville;

    public KtFournisseur() {
    }

    public KtFournisseur(String code) {
        this.code = code;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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
        if (!(object instanceof KtFournisseur)) {
            return false;
        }
        KtFournisseur other = (KtFournisseur) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dc.keating.entities.KtFournisseur[ code=" + code + " ]";
    }
    
}
