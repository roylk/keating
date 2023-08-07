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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
        if (stockService.searchExistsScatProduit(sCatProduit.getCode())) {
            rep = new Reponse(0, "la sous catégorie existe déjà", null);
        } else {
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
        if (stockService.searchExistsCatProduit(catProduit.getCode())) {
            rep = new Reponse(0, "la catégorie  existe déjà", null);
        } else {
            try {

                KtCategorieProduit cp = stockService.saveCategorieProduit(catProduit);
                rep = new Reponse(1, "sous catégorie enregistrée avec succes", cp);

            } catch (Exception e) {
                rep = new Reponse(0, e.getMessage(), null);
            }
        }
        return rep;
    }

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
                Double poidsTotal = produit.getPoidsUnitaire() * quantiteTotale;
                produit.setPoidsTotal(poidsTotal);
                KtProduit savedProduit = stockService.saveProduit(produit);

                rep = new Reponse(1, "Produit enregistré avec succès", savedProduit);

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
                Double volumeTotal = produit.getVolumeUnitaire() * quantiteTotale;
                produit.setVolumeTotal(volumeTotal);
                KtProduit savedProduit = stockService.saveProduit(produit);

                rep = new Reponse(1, "Produit enregistré avec succès", savedProduit);

            }
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }

        return rep;
    }

    @ApiOperation("effectuer une entrée  en  stock")
    @PostMapping(value = "/entreeStock", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse stockIn(@RequestParam(name = "codeProduit") String codeProduit, @RequestParam(name = "quantite") Double quantite, @RequestParam(name = "nom") String nom, @RequestParam(name = "description") String description) {
        Reponse rep;

        try {
            stockService.entrerStock(codeProduit, quantite, nom, description);
            //page<KtOperationStock> listeOperationStock = stockService.
            rep = new Reponse(1, "Entrée en stock effectué avec succes", null);
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }
        return rep;
    }

    @ApiOperation("effectuer une   sortie de  stock")
    @PostMapping(value = "/sortieStock", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse stockOut(@RequestParam(name = "codeProduit") String codeProduit, @RequestParam(name = "quantite") Double quantite, @RequestParam(name = "nom") String nom, @RequestParam(name = "description") String description) {
        Reponse rep;
        try {
            stockService.sortirStock(codeProduit, quantite, nom, description);
            //page<KtOperationStock> listeOperationStock = stockService.
            rep = new Reponse(1, "Sortie de stock effectué avec succes", null);
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), stockService.ListOperationByProduct(codeProduit, PageRequest.of(0, 20)));
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

    @ApiOperation("Mettre à jour un produit ")
    @PutMapping(value = "/produits/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse updateProduit(@RequestBody KtProduit produit, @PathVariable("code") String code) {
        Reponse rep;
        try {
            produit.setCode(code);
            KtProduit p = stockService.updateProduit(produit);
            rep = new Reponse(1, "mis à jour avec succes", p);

        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }

        return rep;
    }

    @ApiOperation("Mettre à jour une opération de stock ")
    @PutMapping(value = "/operationStocks/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse updateProduit(@RequestBody KtOperationStock operation, @PathVariable("id") Long id) {
        Reponse rep;
        try {
            operation.setId(id);
            KtOperationStock op = stockService.updateOperation(operation);
            rep = new Reponse(1, "mis à jour avec succes", op);

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

    @ApiOperation("Supprimer une opération de stock")
    @DeleteMapping(value = "/operationStock/{id}")
    public Reponse deleteOperationStock(@PathVariable("id") Long id) {
        Reponse rep;
        try {
            stockService.deleteOperationStock(id);
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
            List<KtProduit> listProduit = stockService.listeProduit();
            stockService.updateProduitStatus(listProduit);
            rep = stockService.listeProduit(PageRequest.of(page, size));
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);

        }
        return rep;
    }
    
    @ApiOperation("Liste des produits par  point de vente")
    @GetMapping(value = "/produitparpv", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllProduitByPV(String codeP, @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        Reponse rep;
        try {
            rep = stockService.ListProduitByPV(codeP, PageRequest.of(page, size));
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

    @ApiOperation("Liste des produits recherchés par mot clé ")
    @GetMapping(value = "/rechproduit", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllProduitBy(String mc, @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        Reponse rep;
        try {
            Page<KtProduit> listeProduits = stockService.SearchProduits("%" + mc + "%", PageRequest.of(page, size));
            rep = new Reponse(1, "liste des produits trouvés", listeProduits);

        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);

        }
        return rep;
    }
    
    @ApiOperation("Liste des opérations recherchées par mot clé ")
    @GetMapping(value = "/rechoperation", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllOperationBy(String mc, @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        Reponse rep;
        try {
            Page<KtOperationStock> listeOperations = stockService.SearchOperation("%" + mc + "%", PageRequest.of(page, size));
            rep = new Reponse(1, "liste des produits trouvés", listeOperations);

        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);

        }
        return rep;
    }

    @ApiOperation("Liste des opérations par  produit")
    @GetMapping(value = "/operationparproduit", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllOperationByProduit(String codeP, @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        Reponse rep;
        try {
            rep = stockService.ListOperationByProduct(codeP, PageRequest.of(page, size));
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);

        }
        return rep;
    }

    @ApiOperation("Liste des opérations de stock par page")
    @GetMapping(value = "/poperationsStock", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllOperationsSPage(@RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        Reponse rep;
        try {
            rep = stockService.ListeOperationStock(PageRequest.of(page, size));
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);

        }
        return rep;
    }

    @ApiOperation("Liste des entrées  en stock par page")
    @GetMapping(value = "/pentreeStock", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllEntreeSPage(@RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        Reponse rep;
        try {
            rep = stockService.ListeEntreeStock(PageRequest.of(page, size));
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);

        }
        return rep;
    }

    @ApiOperation("Liste des sorties de  stock par page")
    @GetMapping(value = "/psortieStock", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllSortieSPage(@RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        Reponse rep;
        try {
            rep = stockService.ListeSortieStock(PageRequest.of(page, size));
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);

        }
        return rep;
    }

}
