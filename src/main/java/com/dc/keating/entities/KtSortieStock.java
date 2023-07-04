/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dc.keating.entities;

import javax.persistence.Column;
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
//@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class KtSortieStock extends KtOperationStock {
    /*@Column(name = "quantite_sortie", precision = 22, scale = 0)
    private Double quantiteSortie;*/
    @Column(name = "volume_sorti", precision = 22, scale = 0)
    private Double volumeSorti;
    @Column(name = "poids_sorti", precision = 22, scale = 0)
    private Double poidsEntre;

    public KtSortieStock() {
       
    }
    
    public KtSortieStock(Double quantite, KtProduit produit) {
        super(quantite, produit);
    }

    public KtSortieStock(Double volumeSorti, Double poidsEntre, Long id, Double quantite, String nom, String description, KtProduit produit) {
        super(id, quantite, nom, description, produit);
        this.volumeSorti = volumeSorti;
        this.poidsEntre = poidsEntre;
    }
    
    
    
}
