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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "kt_role", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"libele"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KtRole.findAll", query = "SELECT k FROM KtRole k"),
    @NamedQuery(name = "KtRole.findById", query = "SELECT k FROM KtRole k WHERE k.id = :id"),
    @NamedQuery(name = "KtRole.findByLibele", query = "SELECT k FROM KtRole k WHERE k.libele = :libele")})
public class KtRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "libele", nullable = false, length = 45)
    private String libele;
    @Lob
    @Column(name = "description", length = 16777215)
    private String description;
    /*@JoinTable(name = "kt_role_privilege", joinColumns = {
        @JoinColumn(name = "role", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "privilege", referencedColumnName = "code", nullable = false)})*/
    @ManyToMany(mappedBy ="ktRole", fetch = FetchType.LAZY)
    //@ManyToMany(mappedBy = "ktRoleList")
    private List<KtPrivilege> ktPrivilegeList;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private List<KtUtilisateur> ktUtilisateurList;*/

    public KtRole() {
    }

    public KtRole(Integer id) {
        this.id = id;
    }

    public KtRole(Integer id, String libele) {
        this.id = id;
        this.libele = libele;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibele() {
        return libele;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<KtPrivilege> getKtPrivilegeList() {
        return ktPrivilegeList;
    }

    public void setKtPrivilegeList(List<KtPrivilege> ktPrivilegeList) {
        this.ktPrivilegeList = ktPrivilegeList;
    }

   /* @XmlTransient
    public List<KtUtilisateur> getKtUtilisateurList() {
        return ktUtilisateurList;
    }

    public void setKtUtilisateurList(List<KtUtilisateur> ktUtilisateurList) {
        this.ktUtilisateurList = ktUtilisateurList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KtRole)) {
            return false;
        }
        KtRole other = (KtRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dc.keating.entities.KtRole[ id=" + id + " ]";
    }
    
}
