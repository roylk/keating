/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dc.keating.dao;

import com.dc.keating.entities.KtUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author user
 */
public interface KtUtilisateurRepository extends JpaRepository <KtUtilisateur,Integer>{
    @Query("select u from KtUtilisateur u where u.login=:x")
    public KtUtilisateur findbyLogin(@Param("x") String login);
        
        
    @Query("select u from KtUtilisateur u where u.email=:x")
    public KtUtilisateur findbyEmail(@Param("x") String email);
    
}
