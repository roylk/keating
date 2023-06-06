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
@Table(name = "kt_commercant", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KtCommercant.findAll", query = "SELECT k FROM KtCommercant k"),
    @NamedQuery(name = "KtCommercant.findByCode", query = "SELECT k FROM KtCommercant k WHERE k.code = :code"),
    @NamedQuery(name = "KtCommercant.findByRaisonSociale", query = "SELECT k FROM KtCommercant k WHERE k.raisonSociale = :raisonSociale"),
    @NamedQuery(name = "KtCommercant.findByTelephone", query = "SELECT k FROM KtCommercant k WHERE k.telephone = :telephone"),
    @NamedQuery(name = "KtCommercant.findByEmail", query = "SELECT k FROM KtCommercant k WHERE k.email = :email"),
    @NamedQuery(name = "KtCommercant.findByAdresse", query = "SELECT k FROM KtCommercant k WHERE k.adresse = :adresse")})
public class KtCommercant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code", nullable = false, length = 45)
    private String code;
    @Basic(optional = false)
    @Column(name = "raison_sociale", nullable = false, length = 45)
    private String raisonSociale;
    @Basic(optional = false)
    @Column(name = "telephone", nullable = false, length = 20)
    private String telephone;
    @Basic(optional = false)
    @Column(name = "email", nullable = false, length = 45)
    private String email;
    @Column(name = "adresse", length = 45)
    private String adresse;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "commercantCode")
    private List<KtPointDeVente> ktPointDeVenteList;
    @OneToMany(mappedBy = "commercant")
    private List<KtUtilisateur> ktUtilisateurList;*/
    @JoinColumn(name = "ville", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private KtVille ville;
    @Column(nullable = false)
    private short statut;

    public KtCommercant() {
    }

    public KtCommercant(String code) {
        this.code = code;
    }

    public KtCommercant(String code, String raisonSociale, String telephone, String email) {
        this.code = code;
        this.raisonSociale = raisonSociale;
        this.telephone = telephone;
        this.email = email;
    }

    public void setStatut(short statut) {
        this.statut = statut;
    }

    public short getStatut() {
        return statut;
    }

    public KtCommercant(String code, String raisonSociale, String telephone, String email, String adresse, KtVille ville, short statut) {
        this.code = code;
        this.raisonSociale = raisonSociale;
        this.telephone = telephone;
        this.email = email;
        this.adresse = adresse;
        this.ville = ville;
        this.statut = statut;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

   /*@XmlTransient
    public List<KtPointDeVente> getKtPointDeVenteList() {
        return ktPointDeVenteList;
    }

    public void setKtPointDeVenteList(List<KtPointDeVente> ktPointDeVenteList) {
        this.ktPointDeVenteList = ktPointDeVenteList;
    }

    @XmlTransient
    public List<KtUtilisateur> getKtUtilisateurList() {
        return ktUtilisateurList;
    }

    public void setKtUtilisateurList(List<KtUtilisateur> ktUtilisateurList) {
        this.ktUtilisateurList = ktUtilisateurList;
    }*/

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
        if (!(object instanceof KtCommercant)) {
            return false;
        }
        KtCommercant other = (KtCommercant) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dc.keating.entities.KtCommercant[ code=" + code + " ]";
    }
    
}
