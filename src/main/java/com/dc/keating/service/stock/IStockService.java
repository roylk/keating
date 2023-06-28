/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dc.keating.service.stock;

import com.dc.keating.config.Reponse;
import com.dc.keating.entities.KtCategorieProduit;
import com.dc.keating.entities.KtProduit;
import com.dc.keating.entities.KtProduitLiquide;
import com.dc.keating.entities.KtProduitSolide;
import com.dc.keating.entities.KtSousCategorieProduit;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author user
 */
public interface IStockService {
    
    public List<KtSousCategorieProduit> listeSousCategorieProduit();
    public Reponse listeSousCategorieProduit(Pageable pageable);
    
    
    public List<KtCategorieProduit> listeCategorieProduit();
    public Reponse listeCategorieProduit(Pageable pageable);
    
    public List<KtProduit> listeProduit();
    public Reponse listeProduit(Pageable pageable);
    
    public KtSousCategorieProduit saveSousCategorieProduit(KtSousCategorieProduit sCatProduit);
    public KtCategorieProduit saveCategorieProduit(KtCategorieProduit catProduit);
    public KtProduit saveProduit(KtProduit produit);
    public KtProduitSolide saveProduit(KtProduitSolide produit);
    public KtProduitLiquide saveProduit(KtProduitLiquide produit);
   
    
    public KtSousCategorieProduit searchSousCategorieProduit(String code);
    public KtCategorieProduit searchCategorieProduit(String code);
    public KtProduit searchProduit(String code);
    
    public Page<KtSousCategorieProduit> SearchSousCategories(String mc, Pageable pageable);
    public Page<KtCategorieProduit> SearchCategories(String mc, Pageable pageable);
    public Page<KtProduit> SearchProduits(String mc, Pageable pageable);
    
    public KtSousCategorieProduit updateSousCategorieProduit(KtSousCategorieProduit sCatProduit);
    public KtCategorieProduit updateCategorieProduit(KtCategorieProduit catProduit);
    public KtProduit updateProduit(KtProduit catProduit);
    
    public void deleteSousCategorieProduit(String code);
    public void deleteCategorieProduit(String code);
    public void deleteProduit(String code);
    
    public Reponse getAllSousCategorieProduit();
    public Reponse getAllCategorieProduit();
    public Reponse getAllProduit();
    
    public boolean searchExistsScatProduit(String code);
    public boolean searchExistsCatProduit(String code);
    public boolean searchExistProduit(String code);
    
}
