/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dc.keating.dao;

import com.dc.keating.entities.KtPrivilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author user
 */

public interface KtPrivilegeRepository extends JpaRepository<KtPrivilege, String> {
    
    @Query("select p from KtPrivilege p where p.code=:x")
    public KtPrivilege findbyCode(@Param("x") String code);
    
}
