/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dc.keating.dao;

import com.dc.keating.entities.KtCategorieProduit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author user
 */
public interface KtCategorieProduitRepository extends JpaRepository<KtCategorieProduit, String> {
    @Query("select p from KtCategorieProduit p where p.libelle like :x")
    public Page<KtCategorieProduit> findCategorieProduit(@Param("x") String mc, Pageable pageable);
        
    @Query("select p from KtCategorieProduit p where p.code=:x")
    public KtCategorieProduit findbyId(@Param("x") String code);
    
}
