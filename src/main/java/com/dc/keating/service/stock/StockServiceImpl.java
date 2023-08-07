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
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
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
        //updateProduitStatus(listeProduit());
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
            return produitRepository.findbyId(code);    
        }
        //return produitRepository.findbyId(code);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    

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
        return produitRepository.findProduit(mc, pageable);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public void entrerStock(String codeProduit, Double quantite, String description, String nom) {
        Double poidsEntre, volumeEntre ;
        KtProduit produit = produitRepository.findbyId(codeProduit);
        produit.setQuantiteUnitaire(quantite+produit.getQuantiteUnitaire());
        produit.setQuantiteTotale(produit.getQuantiteTotale()+(produit.getPackaging()*quantite));
        if(produit instanceof KtProduitLiquide){
            poidsEntre = 0.0;
            volumeEntre = quantite * ((KtProduitLiquide) produit).getVolumeUnitaire()*produit.getPackaging();
            ((KtProduitLiquide) produit).setVolumeTotal(volumeEntre+((KtProduitLiquide) produit).getVolumeTotal());
            KtEntreeStock entreeStock = new KtEntreeStock(volumeEntre, poidsEntre, quantite, nom, description, produit);
            operationStockRepository.save(entreeStock);
            
        }
        if(produit instanceof KtProduitSolide){
            volumeEntre = 0.0;
            poidsEntre = quantite * ((KtProduitSolide) produit).getPoidsUnitaire();
            ((KtProduitSolide) produit).setPoidsTotal(poidsEntre + ((KtProduitSolide) produit).getPoidsTotal());
            KtEntreeStock entreeStock = new KtEntreeStock(volumeEntre, poidsEntre, quantite, nom, description, produit);
            operationStockRepository.save(entreeStock);
        }  
        produitRepository.save(produit);
        
     //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void sortirStock(String codeProduit, Double quantite, String nom, String description) {
        Double poidsSorti, volumeSorti ;
        KtProduit produit = produitRepository.findbyId(codeProduit);
        Double quantiteDisponible = produit.getQuantiteTotale();
        if(quantite > quantiteDisponible)
            throw new UnsupportedOperationException("quantite disponible insuffisante");
        produit.setQuantiteUnitaire(produit.getQuantiteUnitaire()-(quantite/produit.getPackaging()));
        produit.setQuantiteTotale(quantiteDisponible-quantite);
        if(produit instanceof KtProduitLiquide){
            poidsSorti = 0.0;
            volumeSorti = quantite * ((KtProduitLiquide) produit).getVolumeUnitaire();
            ((KtProduitLiquide) produit).setVolumeTotal(((KtProduitLiquide) produit).getVolumeTotal()- volumeSorti);
            KtSortieStock sortieStock = new KtSortieStock(volumeSorti, poidsSorti, quantite, nom, description, produit);
            operationStockRepository.save(sortieStock);
            
        }
        if(produit instanceof KtProduitSolide){
            volumeSorti = 0.0;
            poidsSorti = quantite * ((KtProduitSolide) produit).getPoidsUnitaire();
            ((KtProduitSolide) produit).setPoidsTotal(((KtProduitSolide) produit).getPoidsTotal()-poidsSorti);
            KtSortieStock sortieStock = new KtSortieStock(volumeSorti, poidsSorti, quantite,null, null, produit);
            operationStockRepository.save(sortieStock);
        }  
        produitRepository.save(produit);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*@Override
    public KtOperationStock SearchOperation(String code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/

    @Override
    public Reponse ListOperationByProduct(String codeP, Pageable pageable) {
        return new Reponse(1, "liste des opérations par produit",operationStockRepository.findAllOperationByProduit(codeP, pageable));
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Page<KtOperationStock> ListeOperationByProduit(String codeP, Pageable pageable) {
        return operationStockRepository.findAllOperationByProduit(codeP, pageable);
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse ListProduitByPV(String codeP, Pageable pageable) {
        return new Reponse(1, "liste des produits par point de vente",produitRepository.findAllProduitByPV(codeP, pageable));
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    /*public void updateProduitStatus(List<KtProduit> listeProduit) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        
        for (KtProduit produit : listeProduit){
            Duration dlcDiff = Duration.between(produit.getDlc(), currentDateTime);
            Duration ddmDiff = Duration.between(produit.getDdm(), currentDateTime);
            if (produit.getDdm().isAfter(currentDateTime) || produit.getDlc().isAfter(currentDateTime) || produit.getQuantiteTotale()==0){
                produit.setStatut((short)0);}
            else if (produit.getQuantiteTotale()<=15){
                produit.setStatut((short)2);
            }else if (dlcDiff.toDays()<=15 || ddmDiff.toDays()<=15){
                produit.setStatut((short)3);
            }
            else{
                produit.setStatut((short)1);
            }   
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
    
    public void updateProduitStatus(List<KtProduit> listeProduit) {
    LocalDateTime currentDateTime = LocalDateTime.now();

    for (KtProduit produit : listeProduit) {
        Duration dlcDiff = Duration.between(currentDateTime, produit.getDlc());
        Duration ddmDiff = Duration.between(currentDateTime, produit.getDdm());
        long minDiff = Math.min(Math.abs(dlcDiff.toDays()), Math.abs(ddmDiff.toDays()));

        if (produit.getDdm().isAfter(currentDateTime) || produit.getQuantiteTotale() == 0) {
            produit.setStatut((short) 0);
        } else if (produit.getQuantiteTotale() <= 15) {
            produit.setStatut((short) 2);
        } else if (minDiff <= 15) {
            produit.setStatut((short) 3);
        } else {
            produit.setStatut((short) 1);
        }
    }
}







    
    

   
    
}
