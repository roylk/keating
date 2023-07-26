/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dc.keating.service.stock;

import com.dc.keating.config.Reponse;
import com.dc.keating.entities.KtCategorieProduit;
import com.dc.keating.entities.KtEntreeStock;
import com.dc.keating.entities.KtOperationStock;
import com.dc.keating.entities.KtProduit;
import com.dc.keating.entities.KtProduitLiquide;
import com.dc.keating.entities.KtProduitSolide;
import com.dc.keating.entities.KtSortieStock;
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
    public List<KtOperationStock> listeOperationStock();
    
    public Reponse listeProduit(Pageable pageable);
    public Reponse listeProduitL(Pageable pageable);
    public Reponse listeProduitS(Pageable pageable);
    public Reponse ListProduitByPV(String codeP, Pageable pageable);
    
    public Reponse ListeOperationStock(Pageable pageable);
    public Reponse ListeEntreeStock(Pageable pageable);
    public Reponse ListeSortieStock(Pageable pageable);
    public Reponse ListOperationByProduct(String codeP, Pageable pageable);
    public Page<KtOperationStock> ListeOperationByProduit(String codeP, Pageable pageable);
    
    
    
    public KtSousCategorieProduit saveSousCategorieProduit(KtSousCategorieProduit sCatProduit);
    public KtCategorieProduit saveCategorieProduit(KtCategorieProduit catProduit);
    public KtProduit saveProduit(KtProduit produit);
    public KtProduitSolide saveProduit(KtProduitSolide produit);
    public KtProduitLiquide saveProduit(KtProduitLiquide produit);
    
    public KtOperationStock saveOperationStock(KtOperationStock operation);
    public KtEntreeStock saveOperationStock(KtEntreeStock operation);
    public KtSortieStock saveOperationStock(KtSortieStock operation);
   
    
    public KtSousCategorieProduit searchSousCategorieProduit(String code);
    public KtCategorieProduit searchCategorieProduit(String code);
    public KtProduit searchProduit(String code);
    public KtOperationStock SearchOperation(Long id);
    
    public Page<KtSousCategorieProduit> SearchSousCategories(String mc, Pageable pageable);
    public Page<KtCategorieProduit> SearchCategories(String mc, Pageable pageable);
    public Page<KtProduit> SearchProduits(String mc, Pageable pageable);
    public Page<KtOperationStock> SearchOperation(String mc, Pageable pageable);
    
    public KtSousCategorieProduit updateSousCategorieProduit(KtSousCategorieProduit sCatProduit);
    public KtCategorieProduit updateCategorieProduit(KtCategorieProduit catProduit);
    public KtProduit updateProduit(KtProduit produit);
    public KtOperationStock updateOperation(KtOperationStock operation);
    
    public void deleteSousCategorieProduit(String code);
    public void deleteCategorieProduit(String code);
    public void deleteProduit(String code);
    public void deleteOperationStock(Long id);
    
    public Reponse getAllSousCategorieProduit();
    public Reponse getAllCategorieProduit();
    public Reponse getAllProduit();
    public Reponse getAllOperation();
    
    public boolean searchExistsScatProduit(String code);
    public boolean searchExistsCatProduit(String code);
    public boolean searchExistProduit(String code);
    public boolean searchExistOperation(Long  id);
    
    public void entrerStock(String codeProduit, Double quantite, String nom, String description);
    public void sortirStock(String codeProduit, Double quantite, String nom, String description);
    
}
