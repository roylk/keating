/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dc.keating.web.rest;

import com.dc.keating.config.Reponse;
import com.dc.keating.entities.KtCommercant;
import com.dc.keating.service.commercant.ICommercantService;
import com.dc.keating.service.regionalisation.IRegionalisationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    
    
    
}
