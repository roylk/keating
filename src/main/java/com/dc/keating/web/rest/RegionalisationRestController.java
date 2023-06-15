/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dc.keating.web.rest;

import com.dc.keating.config.Reponse;
import com.dc.keating.entities.KtPays;
import com.dc.keating.entities.KtRegion;
import com.dc.keating.entities.KtVille;
import com.dc.keating.service.regionalisation.IRegionalisationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@CrossOrigin(origins = "*")
// @CrossOrigin(origins = "http://localhost:4200")
@RestController
@Api(tags = "API Regionalisation")
@RequestMapping("/keating/api")
public class RegionalisationRestController {

    @Autowired
    private IRegionalisationService regionalisationService;
    
    @ApiOperation("Créer un nouveau pays")
    @PostMapping(value = "/pays", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse savePays(@RequestBody KtPays pays) {
        Reponse rep;
        try {
            KtPays p = regionalisationService.SavePays(pays);
            rep = new Reponse(1, "pays enregistré  avec succes", p);
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);

        }
        return rep;
    }
    
    @ApiOperation("Créer une nouvelle region")
    @PostMapping(value = "/region", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse saveRegion(@RequestBody KtRegion region) {
        Reponse rep;
        try {
            region.setPays(regionalisationService.getOnePays(region.getPays().getCode()));
            KtRegion r = regionalisationService.saveRegion(region);
            rep = new Reponse(1, "région enregistré(e)  avec succes", r);

        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }
        return rep;
    }
    @ApiOperation("Créer une nouvelle ville")
    @PostMapping(value = "/ville", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse saveVille(@RequestBody KtVille ville) {
        Reponse rep;
        try {
            ville.setRegion(regionalisationService.getOneRegion(ville.getRegion().getId()));
            KtVille v = regionalisationService.saveVille(ville);
            rep = new Reponse(1, "ville enregistré(e)  avec succes", v);
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }
        return rep;

    }
    @ApiOperation("Mettre à jour un pays existant")
    @PutMapping(value = "/payss/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse updatePays(@RequestBody KtPays pays, @PathVariable("code") String code) {
        Reponse rep;
        try {
            pays.setCode(code);
            KtPays p = regionalisationService.updatePays(pays);
            rep = new Reponse(1, "mis à jour avec succes", p);

        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }

        return rep;
    }
     @ApiOperation("Mettre à jour une région")
    @PutMapping(value = "/regions/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse updateRegion(@RequestBody KtRegion region, @PathVariable("id") Integer id) {
        Reponse rep;
        try {
            region.setId(id);
            KtRegion r = regionalisationService.updateRegion(region);
            rep = new Reponse(1, "mis à jour avec succes", r);

        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }

        return rep;
    }
    
    @ApiOperation("Mettre à jour une ville")
    @PutMapping(value = "/villes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse updateVille(@RequestBody KtVille ville, @PathVariable("id") Integer id) {
        Reponse rep;
        try {
            ville.setId(id);
            KtVille v = regionalisationService.updateVille(ville);
            rep = new Reponse(1, "mis à jour avec succes", v);

        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }

        return rep;
    }

    /*@RequestMapping(value = "/payss/{code}", method = RequestMethod.DELETE)
	public void deletePays(@PathVariable("code") String code) {
		regionalisationService.deletePays(code);
	}*/
    
    @ApiOperation("Supprimer un pays")
    @DeleteMapping(value = "/payss/{code}")
    public Reponse deletePays(@PathVariable("code") String code) {
        Reponse rep;
        try {
            regionalisationService.deletePays(code);
            rep = new Reponse(1, "suppression réussie", null);
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }

        return rep;
    }
    
    @ApiOperation("Supprimer une région")
    @DeleteMapping(value = "/regions/{id}")
    public Reponse deleteRegion(@PathVariable("id") Integer id) {
        Reponse rep;
        try {
            regionalisationService.deleteRegion(id);
            rep = new Reponse(1, "suppression réussie", null);
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }

        return rep;
    }

    @ApiOperation("Supprimer une ville")
    @DeleteMapping(value = "/villes/{id}")
    public Reponse deleteVille(@PathVariable("id") Integer id) {
        Reponse rep;
        try {
            regionalisationService.deleteVille(id);
            rep = new Reponse(1, "suppression réussie", null);
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }
        return rep;
    }
    
    @ApiOperation("Liste des pays")
    @GetMapping(value = "/payss", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllPays() {
        Reponse rep;
        try {
            rep = regionalisationService.GetAllPays();
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }
        return rep;
    }
    
    @ApiOperation("Liste des pays par page")
    @GetMapping(value = "/ppays", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllPayss(@RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        Reponse rep;
        try {
            rep = regionalisationService.listePays(PageRequest.of(page, size));
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);

        }
        return rep;
    }

    @ApiOperation("Liste des regions par page")
    @GetMapping(value = "/pregions", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllRegion(@RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        Reponse rep;
        try {
            rep = regionalisationService.listeRegion(PageRequest.of(page, size));
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);

        }
        return rep;

    }
    
    @ApiOperation("Liste des regions")
    @GetMapping(value = "/regions", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllRegions() {
        Reponse rep;
        try {
            rep = regionalisationService.getAllRegion();
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }
        return rep;
    }
    
    @ApiOperation("Liste des villes par page")
    @GetMapping(value = "/pvilles", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllVille(@RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        Reponse rep;
        try {
            rep = regionalisationService.listeVille(PageRequest.of(page, size));
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);

        }
        return rep;
    }
    
    @ApiOperation("Liste des villes")
    @GetMapping(value = "/villes", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllVilles() {
        Reponse rep;
        try {
            rep = regionalisationService.getAllVille();
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }
        return rep;
    }

    @ApiOperation("Liste des regions par pays")
    @GetMapping(value = "/regionparpays", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllRegionByPays(String codeP) {
        Reponse rep;
        try {
            List<KtRegion> listRparP = regionalisationService.getAllRegionByPays(codeP);
            rep = new Reponse(1, "régions par pays", listRparP);
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }

        return rep;
    }
    
    @ApiOperation("Liste des villes par region")
    @GetMapping(value = "/villeparregion", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllVilleByPays(String codeR) {
        Reponse rep;
        try {
            List<KtRegion> listVparR = regionalisationService.getAllRegionByPays(codeR);
            rep = new Reponse(1, "régions par pays", listVparR);
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }
        return rep;
    }
    
    
    @ApiOperation("Obtenir un pays par code")
    @GetMapping(value = "/payss/{code}")
    public Reponse getOnePays(@PathVariable("code") String code) {
        Reponse rep;
        try {
            KtPays p = regionalisationService.getOnePays(code);
            rep = new Reponse(1, "réussi", p);
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }

        return rep;
    }
    
    @ApiOperation("Obtenir une région")
    @GetMapping(value = "/regions/{id}")
    public Reponse getOneRegion(@PathVariable("id") Integer id) {
        Reponse rep;
        try {
            KtRegion r = regionalisationService.getOneRegion(id);
            rep = new Reponse(1, "réussi", r);
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }

        return rep;
    }
    
    @ApiOperation("Obtenir une ville")
    @GetMapping(value = "/villes/{id}")
    public Reponse getOneVille(@PathVariable("id") Integer id) {
        Reponse rep;
        try {
            KtVille v = regionalisationService.getOneVille(id);
            rep = new Reponse(1, "réussi", v);
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }

        return rep;
    }

}
