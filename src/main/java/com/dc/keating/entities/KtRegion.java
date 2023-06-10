/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dc.keating.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "kt_region")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KtRegion.findAll", query = "SELECT k FROM KtRegion k"),
    @NamedQuery(name = "KtRegion.findById", query = "SELECT k FROM KtRegion k WHERE k.id = :id"),
    @NamedQuery(name = "KtRegion.findByNom", query = "SELECT k FROM KtRegion k WHERE k.nom = :nom"),
    @NamedQuery(name = "KtRegion.findByDateCreation", query = "SELECT k FROM KtRegion k WHERE k.dateCreation = :dateCreation")})
public class KtRegion extends AuditModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "code", nullable = false, length = 5)
    private String code;
    @Basic(optional = false)
    @Column(name = "nom", nullable = false, length = 45)
    private String nom;
    /*@Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;*/
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "region")
    private List<KtVille> ktVilleList;*/
    @JoinColumn(name = "pays", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false)
    private KtPays pays;

    public KtRegion() {
        super();
    }

   /* public KtRegion(Integer id) {
        this.id = id;
    }*/

    public KtRegion(String code,String nom, KtPays pays) {
        super();
        //this.id = id;
        this.code = code;
        this.nom = nom;
        //this.dateCreation = dateCreation;
        this.pays = pays;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

   /* public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }*/

   /* @XmlTransient
    public List<KtVille> getKtVilleList() {
        return ktVilleList;
    }

    public void setKtVilleList(List<KtVille> ktVilleList) {
        this.ktVilleList = ktVilleList;
    }*/

    public KtPays getPays() {
        return pays;
    }

    public void setPays(KtPays pays) {
        this.pays = pays;
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
        if (!(object instanceof KtRegion)) {
            return false;
        }
        KtRegion other = (KtRegion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dc.keating.entities.KtRegion[ id=" + id + " ]";
    }
    
}
