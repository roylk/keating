/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dc.keating.service.stock;

import com.dc.keating.config.Reponse;
import com.dc.keating.dao.KtCategorieProduitRepository;
import com.dc.keating.dao.KtEntreeStockRepository;
import com.dc.keating.dao.KtOperationStockRepository;
import com.dc.keating.dao.KtProduitLiquideRepository;
import com.dc.keating.dao.KtProduitRepository;
import com.dc.keating.dao.KtProduitSolideRepository;
import com.dc.keating.dao.KtSortieStockRepository;
import com.dc.keating.dao.KtSousCategorieProduitRepository;
import com.dc.keating.entities.KtCategorieProduit;
import com.dc.keating.entities.KtEntreeStock;
import com.dc.keating.entities.KtOperationStock;
import com.dc.keating.entities.KtProduit;
import com.dc.keating.entities.KtProduitLiquide;
import com.dc.keating.entities.KtProduitSolide;
import com.dc.keating.entities.KtSortieStock;
import com.dc.keating.entities.KtSousCategorieProduit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */

@Service 
@Transactional
public class StockServiceImpl implements IStockService{
    
    @Autowired
    KtSousCategorieProduitRepository sousCatProduitRepository;
    
    @Autowired
    KtCategorieProduitRepository catProduitRepository;
    
    @Autowired
    KtProduitRepository produitRepository;
    
    @Autowired
    KtProduitSolideRepository produitSolideRepository;
    @Autowired
    KtProduitLiquideRepository produitLiquideRepository;
    
    @Autowired
    KtOperationStockRepository operationStockRepository;
    
    @Autowired
    KtEntreeStockRepository entreeStockRepository;
    
    @Autowired
    KtSortieStockRepository sortieStockRepository;
    
    

    @Override
    public List<KtSousCategorieProduit> listeSousCategorieProduit() {
        return sousCatProduitRepository.findAll();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse listeSousCategorieProduit(Pageable pageable) {
        return new Reponse(1, "liste sous catégories des produits",sousCatProduitRepository.findAll(pageable));
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<KtCategorieProduit> listeCategorieProduit() {
        return catProduitRepository.findAll();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse listeCategorieProduit(Pageable pageable) {
        return new Reponse(1, "liste  catégories des produits", catProduitRepository.findAll(pageable));
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<KtProduit> listeProduit() {
        return produitRepository.findAll();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse listeProduit(Pageable pageable) {
        return new Reponse(1, "liste  des produits", produitRepository.findAll(pageable));
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtSousCategorieProduit saveSousCategorieProduit(KtSousCategorieProduit sousCatProduit) {
        return sousCatProduitRepository.save(sousCatProduit);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtCategorieProduit saveCategorieProduit(KtCategorieProduit catProduit) {
        return catProduitRepository.save(catProduit);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

    @Override
    public KtProduit saveProduit(KtProduit produit) {
        return produitRepository.save(produit);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtSousCategorieProduit searchSousCategorieProduit(String code) {
        return sousCatProduitRepository.findbyId(code);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtCategorieProduit searchCategorieProduit(String code) {
        return catProduitRepository.findbyId(code);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtProduit searchProduit(String code) {
        try{
            return produitRepository.findbyId(code);    
        }catch(Exception e){
            throw new UnsupportedOperationException(e.getMessage());
            //throw new Exception(e.getMessage());
        }
        //return produitRepository.findbyId(code);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Page<KtSousCategorieProduit> SearchSousCategories(String mc, Pageable pageable) {
        return sousCatProduitRepository.findSousCategorieProduit(mc, pageable);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Page<KtCategorieProduit> SearchCategories(String mc, Pageable pageable) {
        return catProduitRepository.findCategorieProduit(mc, pageable);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Page<KtProduit> SearchProduits(String mc, Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtSousCategorieProduit updateSousCategorieProduit(KtSousCategorieProduit sousCatProduit) {
        return sousCatProduitRepository.saveAndFlush(sousCatProduit);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtCategorieProduit updateCategorieProduit(KtCategorieProduit catProduit) {
        return catProduitRepository.saveAndFlush(catProduit);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtProduit updateProduit(KtProduit produit) {
        return produitRepository.saveAndFlush(produit);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteSousCategorieProduit(String code) {
        sousCatProduitRepository.deleteById(code);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteCategorieProduit(String code) {
        catProduitRepository.deleteById(code);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteProduit(String code) {
        produitRepository.deleteById(code);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse getAllSousCategorieProduit() {
        return new Reponse(1, "liste des sous catégories ", sousCatProduitRepository.findAll());
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse getAllCategorieProduit() {
        return new Reponse(1, "liste des catégories ", catProduitRepository.findAll());
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse getAllProduit() {
        return new Reponse(1, "liste des sous catégories ", produitRepository.findAll());
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean searchExistsScatProduit(String code) {
        return sousCatProduitRepository.existsById(code);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean searchExistsCatProduit(String code) {
        return catProduitRepository.existsById(code);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean searchExistProduit(String code) {
        return produitRepository.existsById(code);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtProduitSolide saveProduit(KtProduitSolide produit) {
        return produitRepository.save(produit);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtProduitLiquide saveProduit(KtProduitLiquide produit) {
        return produitRepository.save(produit);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse listeProduitL(Pageable pageable) {
        return new Reponse(1, "liste  des produits liquides", produitLiquideRepository.findAll(pageable));
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse listeProduitS(Pageable pageable) {
        return new Reponse(1, "liste  des produits solides", produitSolideRepository.findAll(pageable));
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<KtOperationStock> listeOperationStock() {
        return operationStockRepository.findAll();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse ListeOperationStock(Pageable pageable) {
        return new Reponse(1,"liste des opérations de stock", operationStockRepository.findAll(pageable));
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse ListeEntreeStock(Pageable pageable) {
        return new Reponse(1,"liste des opérations d'entrée en stock", entreeStockRepository.findAll(pageable));
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse ListeSortieStock(Pageable pageable) {
        return new Reponse(1,"liste des opérations de sortie de stock", sortieStockRepository.findAll(pageable));
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtOperationStock saveOperationStock(KtOperationStock operation) {
        return operationStockRepository.save(operation);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtEntreeStock saveOperationStock(KtEntreeStock operation) {
        return entreeStockRepository.save(operation);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtSortieStock saveOperationStock(KtSortieStock operation) {
        return sortieStockRepository.save(operation);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtOperationStock SearchOperation(Long id) {
        return operationStockRepository.findbyId(id);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Page<KtOperationStock> SearchOperation(String mc, Pageable pageable) {
        return operationStockRepository.findOperation(mc, pageable);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtOperationStock updateOperation(KtOperationStock operation) {
       return operationStockRepository.saveAndFlush(operation);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteOperationStock(Long id) {
        operationStockRepository.deleteById(id);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse getAllOperation() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean searchExistOperation(Long id) {
        return operationStockRepository.existsById(id);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void entrerStock(String codeProduit, Double quantite, String nom, String description) {
        KtProduit produit = searchProduit(codeProduit);
        KtEntreeStock entreeStock = new KtEntreeStock(quantite, produit, nom, description);
        operationStockRepository.save(entreeStock);
        produit.setQuantiteUnitaire(produit.getQuantiteUnitaire()+quantite);
        produitRepository.save(produit);  
     //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void sortirStock(String codeProduit, Double quantite) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*@Override
    public KtOperationStock SearchOperation(String code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/

   
    
}
