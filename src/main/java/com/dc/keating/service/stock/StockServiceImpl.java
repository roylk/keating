/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dc.keating.service.stock;

import com.dc.keating.config.Reponse;
import com.dc.keating.dao.KtCategorieProduitRepository;
import com.dc.keating.dao.KtProduitRepository;
import com.dc.keating.dao.KtSousCategorieProduitRepository;
import com.dc.keating.entities.KtCategorieProduit;
import com.dc.keating.entities.KtProduit;
import com.dc.keating.entities.KtProduitLiquide;
import com.dc.keating.entities.KtProduitSolide;
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
    
    

    @Override
    public List<KtSousCategorieProduit> listeSousCategorieProduit() {
        return sousCatProduitRepository.findAll();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse listeSousCategorieProduit(Pageable pageable) {
        return new Reponse(1, "liste sous catégories des produits",sousCatProduitRepository.findAll());
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
        return produitRepository.findbyId(code);
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
