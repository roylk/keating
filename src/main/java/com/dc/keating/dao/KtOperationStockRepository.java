/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dc.keating.dao;

import com.dc.keating.entities.KtOperationStock;
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
public interface KtOperationStockRepository extends JpaRepository<KtOperationStock, Long> {
    @Query("select o from KtOperationStock o where o.nom like :x OR o.description like :x")
    public Page<KtOperationStock> findOperation(@Param("x") String mc, Pageable pageable);
        
    @Query("select o from KtOperationStock o where o.id=:x")
    public KtOperationStock findbyId(@Param("x") Long id);
    
    @Query("select o from KtOperationStock o, KtProduit p where o.produit=p.code AND p.code =?1 ")        
    Page<KtOperationStock> findAllOperationByProduit(String codeP, Pageable pageable); 
    /*@Query("SELECT r FROM KtRegion r WHERE r.id = :id")
    KtRegion findByIdRegion(Integer id);*/
    
    
}
