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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "uf_terminal", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UfTerminal.findAll", query = "SELECT u FROM UfTerminal u"),
    @NamedQuery(name = "UfTerminal.findByCode", query = "SELECT u FROM UfTerminal u WHERE u.code = :code"),
    @NamedQuery(name = "UfTerminal.findByDesignation", query = "SELECT u FROM UfTerminal u WHERE u.designation = :designation"),
    @NamedQuery(name = "UfTerminal.findByNumeroSerie", query = "SELECT u FROM UfTerminal u WHERE u.numeroSerie = :numeroSerie"),
    @NamedQuery(name = "UfTerminal.findByStatut", query = "SELECT u FROM UfTerminal u WHERE u.statut = :statut")})
public class UfTerminal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code", nullable = false, length = 45)
    private String code;
    @Column(name = "designation", length = 45)
    private String designation;
    @Basic(optional = false)
    @Column(name = "numero_serie", nullable = false, length = 45)
    private String numeroSerie;
    @Basic(optional = false)
    @Column(name = "statut", nullable = false)
    private short statut;
    @JoinColumn(name = "point_de_vente", referencedColumnName = "code")
    @ManyToOne
    private KtPointDeVente pointDeVente;

    public UfTerminal() {
    }

    public UfTerminal(String code) {
        this.code = code;
    }

    public UfTerminal(String code, String numeroSerie, short statut) {
        this.code = code;
        this.numeroSerie = numeroSerie;
        this.statut = statut;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public short getStatut() {
        return statut;
    }

    public void setStatut(short statut) {
        this.statut = statut;
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
        if (!(object instanceof UfTerminal)) {
            return false;
        }
        UfTerminal other = (UfTerminal) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dc.keating.entities.UfTerminal[ code=" + code + " ]";
    }
    
}
