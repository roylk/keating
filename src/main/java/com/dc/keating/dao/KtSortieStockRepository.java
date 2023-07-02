/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dc.keating.dao;

import com.dc.keating.entities.KtSortieStock;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author user
 */
public interface KtSortieStockRepository extends JpaRepository<KtSortieStock,String> {
    
}
