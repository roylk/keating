/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dc.keating.dao;

import com.dc.keating.entities.KtSousCategorieProduit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author user
 */
public interface KtSousCategorieProduitRepository extends JpaRepository<KtSousCategorieProduit, String> {
    @Query("select p from KtSousCategorieProduit p where p.libelle like :x")
    public Page<KtSousCategorieProduit> findSousCategorieProduit(@Param("x") String mc, Pageable pageable);
        
    @Query("select p from KtSousCategorieProduit p where p.code=:x")
    public KtSousCategorieProduit findbyId(@Param("x") String code);
    
    
}
