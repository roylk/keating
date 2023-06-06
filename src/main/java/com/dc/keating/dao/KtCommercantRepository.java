/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dc.keating.dao;

import com.dc.keating.entities.KtCommercant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author user
 */
public interface KtCommercantRepository extends JpaRepository<KtCommercant,String> {
        @Query("select c from KtCommercant c where c.nom like :x")
	public Page<KtCommercant> findCommercant(@Param("x") String mc, Pageable pageable);
        
        @Query("select c from KtCommercant c where c.code=:x")
	public KtCommercant findbyId(@Param("x") String code);
    
}
