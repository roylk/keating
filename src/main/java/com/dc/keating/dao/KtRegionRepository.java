/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dc.keating.dao;

import com.dc.keating.entities.KtRegion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author user
 */
public interface KtRegionRepository extends JpaRepository<KtRegion, Integer> {
        //@Query("select g from Personne p Gerant g where g.code=p.code AND g.type_pers ='GER'")
    @Query("select r,p from KtRegion r, KtPays p where r.pays=p.code AND p.code =?1 ")        
    List<KtRegion> findAllRegionByPays(String codeP); 
    
    @Query("SELECT r FROM KtRegion r WHERE r.id = :id")
    KtRegion findByIdRegion(Integer id);
    
    
}
