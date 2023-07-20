/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dc.keating.dao;

import com.dc.keating.entities.KtProduit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author user
 */
public interface KtProduitRepository extends JpaRepository<KtProduit,String> {
    @Query("select p from KtProduit p where p.libelle like :x OR p.code like :x")
    public Page<KtProduit> findProduit(@Param("x") String mc, Pageable pageable);
        
    @Query("select p from KtProduit p where p.code=:x")
    public KtProduit findbyId(@Param("x") String code);
    
    
}
