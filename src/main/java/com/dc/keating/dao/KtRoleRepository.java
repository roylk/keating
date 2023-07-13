/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dc.keating.dao;

import com.dc.keating.entities.KtRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author user
 */
public interface KtRoleRepository extends JpaRepository <KtRole, Integer>{
    
    @Query("SELECT r FROM KtRole r WHERE r.libele = ?1")
    KtRole getOneByCode(String libele); 
    
    @Query("SELECT r FROM KtRole r WHERE r.id = ?1")
    KtRole getOneById(Integer id); 
    
}
