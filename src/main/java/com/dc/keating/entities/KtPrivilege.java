/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dc.keating.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "kt_privilege", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KtPrivilege.findAll", query = "SELECT k FROM KtPrivilege k"),
    @NamedQuery(name = "KtPrivilege.findByCode", query = "SELECT k FROM KtPrivilege k WHERE k.code = :code")})
public class KtPrivilege implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code", nullable = false, length = 15)
    private String code;
    @Lob
    @Column(name = "description", length = 16777215)
    private String description;
//   @JoinTable(name = "kt_role_privilege", joinColumns = {
//      @JoinColumn(name = "privilege", referencedColumnName = "code", nullable = false)}, inverseJoinColumns = {
//       @JoinColumn(name = "role", referencedColumnName = "id", nullable = false)})
//    @ManyToMany
//    private List<KtRole> ktRoleList;

    public KtPrivilege() {
    }

    public KtPrivilege(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   /* @XmlTransient
    public List<KtRole> getKtRoleList() {
        return ktRoleList;
    }

    public void setKtRoleList(List<KtRole> ktRoleList) {
        this.ktRoleList = ktRoleList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KtPrivilege)) {
            return false;
        }
        KtPrivilege other = (KtPrivilege) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dc.keating.entities.KtPrivilege[ code=" + code + " ]";
    }
    
}
