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
public interface KtOperationStockRepository extends JpaRepository<KtOperationStock, String> {
    @Query("select o from KtOperationStock o where o.nom like :x")
    public Page<KtOperationStock> findOperation(@Param("x") String mc, Pageable pageable);
        
    @Query("select o from KtOperationStock o where o.code=:x")
    public KtOperationStock findbyId(@Param("x") String code);
    
}
