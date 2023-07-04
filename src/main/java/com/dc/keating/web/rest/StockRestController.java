/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dc.keating.web.rest;

import com.dc.keating.config.Reponse;
import com.dc.keating.entities.KtCategorieProduit;
import com.dc.keating.entities.KtEntreeStock;
import com.dc.keating.entities.KtOperationStock;
import com.dc.keating.entities.KtProduit;
import com.dc.keating.entities.KtProduitLiquide;
import com.dc.keating.entities.KtProduitSolide;
import com.dc.keating.entities.KtSortieStock;
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
    
   /* @ApiOperation("Créer un produit ")
    @PostMapping(value = "/produit", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse saveProduit(@RequestBody KtProduit produit) {
        Reponse rep = null;
        KtProduit p;
        p = null;
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
                     //KtProduit p = produitSolide;
                     //System.out.println("produit solide :" +p);
                     p = stockService.saveProduit(produitSolide);
                     System.out.println(p);
                     //rep = new Reponse(1, "produit enregistré solide", p);
                     //return rep;
                }
                else if (produit instanceof KtProduitLiquide){
                    KtProduitLiquide produitLiquide =(KtProduitLiquide)produit;
                    double volumeTotal = produitLiquide.getVolumeUnitaire()*quantiteTotale;
                    produitLiquide.setVolumeTotal(volumeTotal);
                    //p = produitLiquide;
                    //System.out.println("produit liquide: " +p);
                     p = stockService.saveProduit(produitLiquide);
                     System.out.println(p);
                     //rep = new Reponse(1, "produit liquide enregistré avec succes", p);
                     //return rep;
                }
                //KtProduit p= stockService.saveProduit(produit);
                //System.out.println(p);
               rep = new Reponse(1, "produit enregistrée avec succes", p);

            } catch (Exception e) {
                rep = new Reponse(0, e.getMessage(), null);
            }
        }
        return rep;
    }*/
    
@ApiOperation("Créer un produit solide")
@PostMapping(value = "/produitS", produces = MediaType.APPLICATION_JSON_VALUE)
public Reponse saveProduit(@RequestBody KtProduitSolide produit) {
    Reponse rep;
    try {
        if (stockService.searchExistProduit(produit.getCode())) {
            rep = new Reponse(0, "Le produit existe déjà", null);
        } else {
            produit.setSousCategorieProduit(stockService.searchSousCategorieProduit(produit.getSousCategorieProduit().getCode()));
            produit.setPointDeVente(commercantService.searchPointDeVente(produit.getPointDeVente().getCode()));
            Double quantiteTotale = produit.getPackaging() * produit.getQuantiteUnitaire();
            produit.setQuantiteTotale(quantiteTotale);
            Double poidsTotal = produit.getPoidsUnitaire()*quantiteTotale;
            produit.setPoidsTotal(poidsTotal);
            KtProduit savedProduit = stockService.saveProduit(produit);
            
            rep = new Reponse(1, "Produit enregistré avec succès", savedProduit);

            /*if (produit instanceof KtProduitSolide || produit instanceof KtProduitLiquide) {
                if (produit instanceof KtProduitSolide) {
                    KtProduitSolide produitSolide = (KtProduitSolide) produit;
                    double poidsTotal = produitSolide.getPoidsUnitaire() * quantiteTotale;
                    produitSolide.setPoidsTotal(poidsTotal);
                    KtProduitSolide savedProduit = stockService.saveProduit(produitSolide);
                    rep = new Reponse(1, "Produit solide enregistré avec succès", savedProduit);
                } else {
                    KtProduitLiquide produitLiquide = (KtProduitLiquide) produit;
                    double volumeTotal = produitLiquide.getVolumeUnitaire() * quantiteTotale;
                    produitLiquide.setVolumeTotal(volumeTotal);
                    KtProduitLiquide savedProduit = stockService.saveProduit(produitLiquide);
                    rep = new Reponse(1, "Produit liquide enregistré avec succès", savedProduit);
                }
            } else {
                // Si le produit n'est ni solide ni liquide, vous pouvez enregistrer le produit générique
                KtProduit savedProduit = stockService.saveProduit(produit);
                rep = new Reponse(1, "Produit enregistré avec succès", savedProduit);
            }*/
        }
    } catch (Exception e) {
        rep = new Reponse(0, e.getMessage(), null);
    }

    return rep;
}

@ApiOperation("Créer un produit liquide")
@PostMapping(value = "/produitL", produces = MediaType.APPLICATION_JSON_VALUE)
public Reponse saveProduitL(@RequestBody KtProduitLiquide produit) {
    Reponse rep;
    try {
        if (stockService.searchExistProduit(produit.getCode())) {
            rep = new Reponse(0, "Le produit existe déjà", null);
        } else {
            produit.setSousCategorieProduit(stockService.searchSousCategorieProduit(produit.getSousCategorieProduit().getCode()));
            produit.setPointDeVente(commercantService.searchPointDeVente(produit.getPointDeVente().getCode()));
            Double quantiteTotale = produit.getPackaging() * produit.getQuantiteUnitaire();
            produit.setQuantiteTotale(quantiteTotale);
            Double volumeTotal = produit.getVolumeUnitaire()*quantiteTotale;
            produit.setVolumeTotal(volumeTotal);
            KtProduit savedProduit = stockService.saveProduit(produit);
            
            rep = new Reponse(1, "Produit enregistré avec succès", savedProduit);

            /*if (produit instanceof KtProduitSolide || produit instanceof KtProduitLiquide) {
                if (produit instanceof KtProduitSolide) {
                    KtProduitSolide produitSolide = (KtProduitSolide) produit;
                    double poidsTotal = produitSolide.getPoidsUnitaire() * quantiteTotale;
                    produitSolide.setPoidsTotal(poidsTotal);
                    KtProduitSolide savedProduit = stockService.saveProduit(produitSolide);
                    rep = new Reponse(1, "Produit solide enregistré avec succès", savedProduit);
                } else {
                    KtProduitLiquide produitLiquide = (KtProduitLiquide) produit;
                    double volumeTotal = produitLiquide.getVolumeUnitaire() * quantiteTotale;
                    produitLiquide.setVolumeTotal(volumeTotal);
                    KtProduitLiquide savedProduit = stockService.saveProduit(produitLiquide);
                    rep = new Reponse(1, "Produit liquide enregistré avec succès", savedProduit);
                }
            } else {
                // Si le produit n'est ni solide ni liquide, vous pouvez enregistrer le produit générique
                KtProduit savedProduit = stockService.saveProduit(produit);
                rep = new Reponse(1, "Produit enregistré avec succès", savedProduit);
            }*/
        }
    } catch (Exception e) {
        rep = new Reponse(0, e.getMessage(), null);
    }

    return rep;
}

@ApiOperation("effectuer une entrée  en  stock")
@PostMapping(value = "/EntreeStock", produces = MediaType.APPLICATION_JSON_VALUE)
public Reponse stockIn(@RequestParam(name = "codeProduit")String  codeProduit, @RequestParam(name = "quantite")Double quantite, @RequestParam(name = "nom")String nom, @RequestParam(name = "description" )String description) {
    Reponse rep;
    
    try{
        stockService.entrerStock(codeProduit, quantite, nom, description );
        //page<KtOperationStock> listeOperationStock = stockService.
        rep = new Reponse(1, "Entrée en stock effectué avec succes", null );      
    }catch (Exception e){
        rep = new Reponse(0, e.getMessage(), null);   
    }
    return rep;
}

/*@ApiOperation("Créer une opération de stock")
@PostMapping(value = "/operation", produces = MediaType.APPLICATION_JSON_VALUE)
public Reponse saveOperation(@RequestBody KtOperationStock operation, @RequestParam(name = "codeProduit")String codeProduit) {
    Reponse rep = null;
    try {
        if (stockService.searchExistOperation(operation.getCode())) {
            rep = new Reponse(0, "L'opération existe déjà", null);
        } else {
            KtProduit prod = stockService.searchProduit(codeProduit);
            if (operation instanceof KtEntreeStock){
                KtEntreeStock entreeStock = (KtEntreeStock) operation;
                if (prod instanceof KtProduitSolide){
                    KtProduitSolide prodSolide= (KtProduitSolide) prod;
                    Double totalEntree = entreeStock.getQuantiteEntree()*prodSolide.getPackaging();
                    Double quantiteTotale = prodSolide.getQuantiteTotale()+ totalEntree;
                    Double poidsEntre = totalEntree*prodSolide.getPoidsUnitaire();
                    Double poidsTotal= poidsEntre+prodSolide.getPoidsTotal();
                    prodSolide.setQuantiteTotale(quantiteTotale);
                    prodSolide.setPoidsTotal(poidsTotal);
                    entreeStock.setPoidsEntre(poidsEntre);
                    entreeStock.setProduit(prodSolide);    
                }
                else{
                    KtProduitLiquide prodLiquide= (KtProduitLiquide) prod;
                    Double totalEntree = entreeStock.getQuantiteEntree()*prodLiquide.getPackaging();
                    Double quantiteTotale = prodLiquide.getQuantiteTotale()+ totalEntree;
                    Double volumeEntre = totalEntree*prodLiquide.getVolumeUnitaire();
                    Double volumeTotal = volumeEntre + prodLiquide.getVolumeTotal();
                    prodLiquide.setQuantiteTotale(quantiteTotale);
                    prodLiquide.setVolumeTotal(volumeTotal);
                    entreeStock.setVolumeEntre(volumeEntre);
                    entreeStock.setProduit(prodLiquide);        
                }
                KtEntreeStock operationSaved = stockService.saveOperationStock(entreeStock);
                rep = new Reponse(1, "Operation d'entrée de stock effectuée succès", operationSaved);            
            }
            else if(operation instanceof KtSortieStock){
                KtSortieStock sortieStock  = (KtSortieStock)operation;
                if (prod instanceof KtProduitSolide){
                    KtProduitSolide prodSolide= (KtProduitSolide) prod;
                    //Double totalSortie = sortieStock.getQuantiteSortie()*prodSolide.getPackaging();
                    Double quantiteTotale = prodSolide.getQuantiteTotale() - totalSortie;
                    //Double poidsSortie = totalSortie*prodSolide.getPoidsUnitaire();
                    Double poidsTotal = prodSolide.getPoidsTotal()-poidsSortie;
                    sortieStock.setPoidsEntre(poidsSortie);
                    prodSolide.setQuantiteTotale(quantiteTotale);
                    prodSolide.setPoidsTotal(poidsTotal);
                    sortieStock.setProduit(prodSolide);    
                }
                else{
                    KtProduitLiquide prodLiquide= (KtProduitLiquide) prod;
                    Double totalSortie = sortieStock.getQuantiteSortie()*prodLiquide.getPackaging();
                    Double quantiteTotale = prodLiquide.getQuantiteTotale()- totalSortie;
                    Double volumeSorti = totalSortie*prodLiquide.getVolumeUnitaire();
                    Double volumeTotal = prodLiquide.getVolumeTotal()-volumeSorti;
                    prodLiquide.setQuantiteTotale(quantiteTotale);
                    prodLiquide.setVolumeUnitaire(volumeTotal);
                    sortieStock.setVolumeSorti(volumeSorti);
                    sortieStock.setProduit(prodLiquide);        
                }
                KtSortieStock operationSaved = stockService.saveOperationStock(sortieStock);
                rep = new Reponse(1, "Operation de sortie de stock effectuée succès", operationSaved);   
            } 
                
            //if (prod instanceof KtProduitSolide)
            /*produit.setSousCategorieProduit(stockService.searchSousCategorieProduit(produit.getSousCategorieProduit().getCode()));
            produit.setPointDeVente(commercantService.searchPointDeVente(produit.getPointDeVente().getCode()));
            Double quantiteTotale = produit.getPackaging() * produit.getQuantiteUnitaire();
            produit.setQuantiteTotale(quantiteTotale);
            Double poidsTotal = produit.getPoidsUnitaire()*quantiteTotale;
            produit.setPoidsTotal(poidsTotal);
            KtProduit savedProduit = stockService.saveProduit(produit);*/
            
            //rep = new Reponse(1, "Produit enregistré avec succès", savedProduit);

            /*if (produit instanceof KtProduitSolide || produit instanceof KtProduitLiquide) {
                if (produit instanceof KtProduitSolide) {
                    KtProduitSolide produitSolide = (KtProduitSolide) produit;
                    double poidsTotal = produitSolide.getPoidsUnitaire() * quantiteTotale;
                    produitSolide.setPoidsTotal(poidsTotal);
                    KtProduitSolide savedProduit = stockService.saveProduit(produitSolide);
                    rep = new Reponse(1, "Produit solide enregistré avec succès", savedProduit);
                } else {
                    KtProduitLiquide produitLiquide = (KtProduitLiquide) produit;
                    double volumeTotal = produitLiquide.getVolumeUnitaire() * quantiteTotale;
                    produitLiquide.setVolumeTotal(volumeTotal);
                    KtProduitLiquide savedProduit = stockService.saveProduit(produitLiquide);
                    rep = new Reponse(1, "Produit liquide enregistré avec succès", savedProduit);
                }
            } else {
                // Si le produit n'est ni solide ni liquide, vous pouvez enregistrer le produit générique
                KtProduit savedProduit = stockService.saveProduit(produit);
                rep = new Reponse(1, "Produit enregistré avec succès", savedProduit);
            }
        }
    } catch (Exception e) {
        rep = new Reponse(0, e.getMessage(), null);
    }
    return rep;
}*/


    
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
    
     @ApiOperation("Supprimer un  produit")
    @DeleteMapping(value = "/produit/{code}")
    public Reponse deleteProduit(@PathVariable("code") String code) {
        Reponse rep;
        try {
            stockService.deleteProduit(code);
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
    @GetMapping(value = "/categorieproduits", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllCategorieProduits() {
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
    
    
    @ApiOperation("Liste des produits par page")
    @GetMapping(value = "/pproduits", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllProduitPage(@RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        Reponse rep;
        try {
            rep = stockService.listeProduit(PageRequest.of(page, size));
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);

        }
        return rep;
    }
    
    @ApiOperation("Liste des produits liquides par page")
    @GetMapping(value = "/pproduitsLiq", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllProduitLPage(@RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        Reponse rep;
        try {
            rep = stockService.listeProduitL(PageRequest.of(page, size));
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);

        }
        return rep;
    }
    
    @ApiOperation("Liste des produits solides par page")
    @GetMapping(value = "/pproduitsSol", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllProduitSPage(@RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        Reponse rep;
        try {
            rep = stockService.listeProduitS(PageRequest.of(page, size));
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);

        }
        return rep;
    }
          
}
