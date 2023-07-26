/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dc.keating.web.rest;

import com.dc.keating.config.Reponse;
import com.dc.keating.entities.KtCommercant;
import com.dc.keating.entities.KtPointDeVente;
import com.dc.keating.service.commercant.ICommercantService;
import com.dc.keating.service.regionalisation.IRegionalisationService;
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
@Api(tags = "API Commercant")
@RequestMapping("/keating/api") 
public class CommercantRestController {
    
    @Autowired
    private ICommercantService commercantService;
    @Autowired
    private IRegionalisationService regionalisationService;
    
    @ApiOperation("Créer un commerçant ")
    @PostMapping(value = "/commercant", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse saveCommercant(@RequestBody KtCommercant commercant) {
        Reponse rep;
        if (commercantService.searchExistsCom(commercant.getCode())){
            rep = new Reponse(0,"le commercant existe déjà",null);
        }else{
            try {
                commercant.setVille(regionalisationService.getOneVille(commercant.getVille().getId()));
                KtCommercant c = commercantService.saveCommercant(commercant);
                rep = new Reponse(1, "commercant  enregistré(e)  avec succes", c);

            } catch (Exception e) {
                rep = new Reponse(0, e.getMessage(), null);
            }
        }
        return rep;
    }
    
    @ApiOperation("Créer un point de vente ")
    @PostMapping(value = "/pointdevente", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse savePointDeVente(@RequestBody KtPointDeVente pointDeVente) {
        Reponse rep;
        if (commercantService.searchExistsPv(pointDeVente.getCode())){
            rep = new Reponse(0,"le point de vente existe deja",null);
        }else{
            try {
                pointDeVente.setVille(regionalisationService.getOneVille(pointDeVente.getVille().getId()));
                pointDeVente.setCommercantCode(commercantService.searchCommercant(pointDeVente.getCommercantCode().getCode()));
                KtPointDeVente p = commercantService.savePointDeVente(pointDeVente);
                rep = new Reponse(1, "commercant  enregistré(e)  avec succes", p);

            } catch (Exception e) {
                rep = new Reponse(0, e.getMessage(), null);
            }
        }
        return rep;
    }
    
    
    @ApiOperation("Mettre à jour un commerçant")
    @PutMapping(value = "/commercants/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse updateCommercant(@RequestBody KtCommercant commercant, @PathVariable("code") String code) {
        Reponse rep;
        try {
            commercant.setCode(code);
            KtCommercant c = commercantService.updateCommercant(commercant);
            rep = new Reponse(1, "mis à jour avec succes", c);

        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }

        return rep;
    }
    
    
    @ApiOperation("Mettre à jour un point de vente")
    @PutMapping(value = "/pointdeventes/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse updatePointDeVente(@RequestBody KtPointDeVente pointDeVente, @PathVariable("code") String code) {
        Reponse rep;
        try {
            pointDeVente.setCode(code);
            KtPointDeVente p = commercantService.updatePointsDeVente(pointDeVente);
            rep = new Reponse(1, "mis à jour avec succes", p);

        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }

        return rep;
    }
    
    @ApiOperation("Supprimer un commercant")
    @DeleteMapping(value = "/commercants/{code}")
    public Reponse deleteRegion(@PathVariable("code") String code) {
        Reponse rep;
        try {
            commercantService.deleteCommercant(code);
            rep = new Reponse(1, "suppression réussie", null);
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }

        return rep;
    } 
    
    @ApiOperation("Supprimer un point de vente")
    @DeleteMapping(value = "/pointDeVentes/{code}")
    public Reponse deletePointDeVente(@PathVariable("code") String code) {
        Reponse rep;
        try {
            commercantService.deletePointsDeVente(code);
            rep = new Reponse(1, "suppression réussie", null);
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }

        return rep;
    }
    
    @ApiOperation("Liste des commerçants")
    @GetMapping(value = "/commercants", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllCommercant() {
        Reponse rep;
        try {
            rep = commercantService.getAllCommercant();
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }
        return rep;
    }
    
    @ApiOperation("Liste des commerçants par page")
    @GetMapping(value = "/pcommercants", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllCommercantPage(@RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        Reponse rep;
        try {
            rep = commercantService.listeCommercant(PageRequest.of(page, size));
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);

        }
        return rep;
    }
    
    @ApiOperation("Liste des points de vente")
    @GetMapping(value = "/pointsdeventes", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllPointDeVente() {
        Reponse rep;
        try {
            rep = commercantService.getAllPointDeVente();
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }
        return rep;
    }
    
    
    @ApiOperation("Liste des points de vente  par page")
    @GetMapping(value = "/ppointsdeventes", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllPointDeVentePage(@RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        Reponse rep;
        try {
            rep = commercantService.listePointDeVente(PageRequest.of(page, size));
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);

        }
        return rep;
    }
    
    @ApiOperation("Liste des points de vente  par  commercant")
    @GetMapping(value = "/pvparcommercant", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllPvByCommercant(String codeC, @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        Reponse rep;
        try {
            rep = commercantService.ListPointDeVenteByCommercant(codeC, PageRequest.of(page, size));
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);

        }
        return rep;
    }
  
}
