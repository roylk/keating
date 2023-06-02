/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dc.keating.web.rest.regionalisation;

import com.dc.keating.config.Reponse;
import com.dc.keating.entities.KtPays;
import com.dc.keating.entities.KtRegion;
import com.dc.keating.entities.KtVille;
import com.dc.keating.service.regionalisation.IRegionalisationService;
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
@RequestMapping("/keating/api")
public class RegionalisationRestController {

    @Autowired
    private IRegionalisationService regionalisationService;

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

}
