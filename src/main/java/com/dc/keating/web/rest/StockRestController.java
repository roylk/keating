/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dc.keating.web.rest;

import com.dc.keating.config.Reponse;
import com.dc.keating.entities.KtCategorieProduit;
import com.dc.keating.entities.KtProduit;
import com.dc.keating.entities.KtProduitLiquide;
import com.dc.keating.entities.KtProduitSolide;
import com.dc.keating.entities.KtSousCategorieProduit;
import com.dc.keating.service.commercant.ICommercantService;
import com.dc.keating.service.stock.IStockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */

@CrossOrigin(origins = "*")
// @CrossOrigin(origins = "http://localhost:4200")
@RestController
@Api(tags = "API Stock et approvisionnement")
@RequestMapping("/keating/api") 
public class StockRestController {
    
    @Autowired
    private IStockService stockService;
    
    @Autowired
    private ICommercantService commercantService;
    
    
    @ApiOperation("Créer une sous catégorie de produit ")
    @PostMapping(value = "/souscategorieproduit", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse saveSousCategorieProduit(@RequestBody KtSousCategorieProduit sCatProduit) {
        Reponse rep;
        if (stockService.searchExistsScatProduit(sCatProduit.getCode())){
            rep = new Reponse(0,"la sous catégorie existe déjà",null);
        }else{
            try {
                sCatProduit.setCategorieProduit(stockService.searchCategorieProduit(sCatProduit.getCategorieProduit().getCode()));
                KtSousCategorieProduit scp = stockService.saveSousCategorieProduit(sCatProduit);
                rep = new Reponse(1, "sous catégorie enregistrée avec succes", scp);

            } catch (Exception e) {
                rep = new Reponse(0, e.getMessage(), null);
            }
        }
        return rep;
    }
    
    
    @ApiOperation("Créer une  catégorie de produit ")
    @PostMapping(value = "/categorieproduit", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse saveCategorieProduit(@RequestBody KtCategorieProduit catProduit) {
        Reponse rep;
        if (stockService.searchExistsCatProduit(catProduit.getCode())){
            rep = new Reponse(0,"la catégorie  existe déjà",null);
        }else{
            try {
                
                KtCategorieProduit cp = stockService.saveCategorieProduit(catProduit);
                rep = new Reponse(1, "sous catégorie enregistrée avec succes", cp);

            } catch (Exception e) {
                rep = new Reponse(0, e.getMessage(), null);
            }
        }
        return rep;
    }
    
    @ApiOperation("Créer un produit ")
    @PostMapping(value = "/produit", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse saveProduit(@RequestBody KtProduit produit) {
        Reponse rep = null;
        KtProduit p = null;
        if (stockService.searchExistProduit(produit.getCode())){
            rep = new Reponse(0,"le produit existe déjà",null);
        }else{
            try {
                produit.setSousCategorieProduit(stockService.searchSousCategorieProduit(produit.getSousCategorieProduit().getCode()));
                produit.setPointDeVente(commercantService.searchPointDeVente(produit.getPointDeVente().getCode()));
                double quantiteTotale = produit.getPackaging()*produit.getQuantiteUnitaire();
                produit.setQuantiteTotale(quantiteTotale);
                if (produit instanceof KtProduitSolide ){
                    KtProduitSolide produitSolide = (KtProduitSolide)produit;
                    double poidsTotal = produitSolide.getPoidsUnitaire()*quantiteTotale;
                     produitSolide.setPoidsTotal(poidsTotal);
                     p = produitSolide;
                     System.out.println("produit solide :" +p);
                }
                else if (produit instanceof KtProduitLiquide){
                    KtProduitLiquide produitLiquide =(KtProduitLiquide)produit;
                    double volumeTotal = produitLiquide.getVolumeUnitaire()*quantiteTotale;
                    produitLiquide.setVolumeTotal(volumeTotal);
                    p = produitLiquide;
                    System.out.println("produit liquide: " +p);
                }
                p = stockService.saveProduit(p);
                System.out.println(p);
                rep = new Reponse(1, "produit enregistrée avec succes", p);

            } catch (Exception e) {
                rep = new Reponse(0, e.getMessage(), null);
            }
        }
        return rep;
    }
    
    @ApiOperation("Mettre à jour une sous catégorie de produit")
    @PutMapping(value = "/souscategories/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse updateSousCategorieProduit(@RequestBody KtSousCategorieProduit sCatProduit, @PathVariable("code") String code) {
        Reponse rep;
        try {
            sCatProduit.setCode(code);
            KtSousCategorieProduit scp = stockService.updateSousCategorieProduit(sCatProduit);
            rep = new Reponse(1, "mis à jour avec succes", scp);

        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }

        return rep;
    }
    
    @ApiOperation("Mettre à jour une catégorie de produit")
    @PutMapping(value = "/categories/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse updateCategorieProduit(@RequestBody KtCategorieProduit catProduit, @PathVariable("code") String code) {
        Reponse rep;
        try {
            catProduit.setCode(code);
            KtCategorieProduit scp = stockService.updateCategorieProduit(catProduit);
            rep = new Reponse(1, "mis à jour avec succes", scp);

        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }

        return rep;
    }
    
    @ApiOperation("Supprimer une sous catégorie")
    @DeleteMapping(value = "/souscategories/{code}")
    public Reponse deleteSousCategorieProduit(@PathVariable("code") String code) {
        Reponse rep;
        try {
            stockService.deleteSousCategorieProduit(code);
            rep = new Reponse(1, "suppression réussie", null);
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }

        return rep;
    } 
    
    @ApiOperation("Supprimer une  catégorie")
    @DeleteMapping(value = "/categories/{code}")
    public Reponse deleteCategorieProduit(@PathVariable("code") String code) {
        Reponse rep;
        try {
            stockService.deleteCategorieProduit(code);
            rep = new Reponse(1, "suppression réussie", null);
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }

        return rep;
    } 
    
    @ApiOperation("Liste des sous catégories de produit")
    @GetMapping(value = "/souscategories", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllSousCategorie() {
        Reponse rep;
        try {
            rep = stockService.getAllSousCategorieProduit();
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }
        return rep;
    }
    
    @ApiOperation("Liste des sous catégorie de produit par page")
    @GetMapping(value = "/psouscategories", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllSousCategoriePage(@RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        Reponse rep;
        try {
            rep = stockService.listeSousCategorieProduit(PageRequest.of(page, size));
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);

        }
        return rep;
    }
    
    @ApiOperation("Liste des catégories de produit")
    @GetMapping(value = "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllCategorie() {
        Reponse rep;
        try {
            rep = stockService.getAllCategorieProduit();
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }
        return rep;
    }
    
    @ApiOperation("Liste des catégorie de produit par page")
    @GetMapping(value = "/pcategories", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllCategoriePage(@RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        Reponse rep;
        try {
            rep = stockService.listeCategorieProduit(PageRequest.of(page, size));
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);

        }
        return rep;
    }
          
}
