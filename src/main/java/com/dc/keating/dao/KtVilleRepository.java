/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dc.keating.dao;

import com.dc.keating.entities.KtVille;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author user
 */
public interface KtVilleRepository extends JpaRepository<KtVille, Integer>{
    @Query("SELECT v FROM KtVille v WHERE v.id = :id")
    KtVille findByIdVille(Integer id);
    
    @Query("SELECT u FROM KtVille u WHERE u.code = ?1")
    KtVille getOneByCode(String code); 
    
 //@Query("select g from Personne p Gerant g where g.code=p.code AND g.type_pers ='GER'")
   @Query("select v, r from KtVille v, KtRegion r   where v.region=r.id AND r.id =?1 ")        
//  @Query("select g from Gerant g, Personne p where g.code=p.code AND p.g.type_pers='GER'")
    List<KtVille> findAllVilleByRegion(Integer codeR); 
    
   
    
    
}
