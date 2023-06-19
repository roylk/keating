/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dc.keating.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author user
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@DiscriminatorValue("LIQUID")
public class KtProduitLiquide extends KtProduit {
    @Column(name = "volume_unitaire", precision = 22, scale = 0)
    private Double volumeUnitaire;
    
    @Column(name = "volume_total", precision = 22, scale = 0)
    private Double volumeTotal;
    
}
