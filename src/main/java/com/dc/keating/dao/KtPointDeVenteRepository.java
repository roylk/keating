/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dc.keating.dao;

import com.dc.keating.entities.KtPointDeVente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author user
 */
public interface KtPointDeVenteRepository extends JpaRepository<KtPointDeVente,String> {
    
      @Query("select p from KtPointDeVente p where p.nom like :x")
       public Page<KtPointDeVente> findPointDeVente(@Param("x") String mc, Pageable pageable);
        
        @Query("select p from KtPointDeVente p where p.code=:x")
	public KtPointDeVente findbyId(@Param("x") String code);
        
        @Query("select p from KtPointDeVente p, KtCommercant c where p.commercantCode=c.code AND c.code =?1")        
        Page<KtPointDeVente> findAllPointDeVenteByCommercant(String codeC, Pageable pageable); 
    
    
    
}
