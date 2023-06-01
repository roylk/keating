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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "kt_utilisateur", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"email"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KtUtilisateur.findAll", query = "SELECT k FROM KtUtilisateur k"),
    @NamedQuery(name = "KtUtilisateur.findById", query = "SELECT k FROM KtUtilisateur k WHERE k.id = :id"),
    @NamedQuery(name = "KtUtilisateur.findByNom", query = "SELECT k FROM KtUtilisateur k WHERE k.nom = :nom"),
    @NamedQuery(name = "KtUtilisateur.findByPrenom", query = "SELECT k FROM KtUtilisateur k WHERE k.prenom = :prenom"),
    @NamedQuery(name = "KtUtilisateur.findByTelephone", query = "SELECT k FROM KtUtilisateur k WHERE k.telephone = :telephone"),
    @NamedQuery(name = "KtUtilisateur.findByEmail", query = "SELECT k FROM KtUtilisateur k WHERE k.email = :email"),
    @NamedQuery(name = "KtUtilisateur.findByLogin", query = "SELECT k FROM KtUtilisateur k WHERE k.login = :login"),
    @NamedQuery(name = "KtUtilisateur.findByMotDePasse", query = "SELECT k FROM KtUtilisateur k WHERE k.motDePasse = :motDePasse"),
    @NamedQuery(name = "KtUtilisateur.findBySexe", query = "SELECT k FROM KtUtilisateur k WHERE k.sexe = :sexe"),
    @NamedQuery(name = "KtUtilisateur.findByStatut", query = "SELECT k FROM KtUtilisateur k WHERE k.statut = :statut")})
public class KtUtilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "nom", length = 45)
    private String nom;
    @Column(name = "prenom", length = 45)
    private String prenom;
    @Column(name = "telephone", length = 45)
    private String telephone;
    @Column(name = "email", length = 45)
    private String email;
    @Column(name = "login", length = 20)
    private String login;
    @Column(name = "mot_de_passe", length = 300)
    private String motDePasse;
    @Column(name = "sexe", length = 10)
    private String sexe;
    @Basic(optional = false)
    @Column(name = "statut", nullable = false)
    private short statut;
    @JoinColumn(name = "commercant", referencedColumnName = "code")
    @ManyToOne
    private KtCommercant commercant;
    @JoinColumn(name = "role", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private KtRole role;

    public KtUtilisateur() {
    }

    public KtUtilisateur(Integer id) {
        this.id = id;
    }

    public KtUtilisateur(Integer id, short statut) {
        this.id = id;
        this.statut = statut;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public short getStatut() {
        return statut;
    }

    public void setStatut(short statut) {
        this.statut = statut;
    }

    public KtCommercant getCommercant() {
        return commercant;
    }

    public void setCommercant(KtCommercant commercant) {
        this.commercant = commercant;
    }

    public KtRole getRole() {
        return role;
    }

    public void setRole(KtRole role) {
        this.role = role;
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
        if (!(object instanceof KtUtilisateur)) {
            return false;
        }
        KtUtilisateur other = (KtUtilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dc.keating.entities.KtUtilisateur[ id=" + id + " ]";
    }
    
}
