/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dc.keating.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class KtEntreeStock extends KtOperationStock {
   
    /*@Column(name = "quantite_entree", precision = 22, scale = 0)
    private Double quantiteEntree;*/
    @Column(name = "volume_entre", precision = 22, scale = 0)
    private Double volumeEntre;
    @Column(name = "poids_entre", precision = 22, scale = 0)
    private Double poidsEntre;

    public KtEntreeStock(Double quantite, KtProduit produit) {
        super (quantite, produit);
    }

    public KtEntreeStock(Double volumeEntre, Double poidsEntre, Long id, Double quantite, String nom, String description, KtProduit produit) {
        super(id, quantite, nom, description, produit);
        this.volumeEntre = volumeEntre;
        this.poidsEntre = poidsEntre;
    }

    
   
    
    
    
    
    

      
       
}
