/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dc.keating.web.rest;

import com.dc.keating.config.Reponse;
import com.dc.keating.entities.ConnexionObject;
import com.dc.keating.entities.KtPrivilege;
import com.dc.keating.entities.KtRole;
import com.dc.keating.entities.KtUtilisateur;
import com.dc.keating.service.authentification.IAuthentificationService;
import com.dc.keating.service.commercant.ICommercantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@Api(tags = "API authentification")
@RequestMapping("/keating/api")
public class AuthentificationRestController {

    @Autowired
    private IAuthentificationService authentificationService;

    @Autowired
    private ICommercantService commercantService;

    @ApiOperation("Conversion vers Bcrypt ")
    @PostMapping(value = "/convertToBcrypt")
    public String convertToBcrypt(@RequestParam(name = "input") String input) {
        String output;
        return output = authentificationService.stringToBcrypt(input);

    }

    @ApiOperation("Connexion")
    @PostMapping(value = "/login")
    Reponse connexion(@RequestBody ConnexionObject connexionObject) {
        boolean exists = authentificationService.searchExistsUser(connexionObject.getLogin(), connexionObject.getMotDePasse());
        if (exists) {
            KtUtilisateur user = authentificationService.searchUserByLogin(connexionObject.getLogin());
            return new Reponse(1, "auth réussie", user);
        } else {
            return new Reponse(0, "echec auth", null);
        }
    }

    @ApiOperation("Creer un utilisateur")
    @PostMapping(value = "/utilisateur", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse saveUser(@RequestBody KtUtilisateur utilisateur) {

        String encPassWord = authentificationService.stringToBcrypt(utilisateur.getMotDePasse());
        utilisateur.setMotDePasse(encPassWord);

        utilisateur.setCommercant(commercantService.searchCommercant(utilisateur.getCommercant().getCode()));
        utilisateur.setRole(authentificationService.getOneRole(utilisateur.getRole().getId()));
        boolean exists1 = authentificationService.searchExistLogin(utilisateur.getLogin());
        boolean exists2 = authentificationService.searchExistEmail(utilisateur.getEmail());
        if (exists1) {
            return new Reponse(3, "Login déjà utilisé...", null);
        } else if (exists2) {
            return new Reponse(2, "Email  déjà utilisé...", null);
        } else {
            KtUtilisateur user = authentificationService.saveUser(utilisateur);
            if (user != null) {
                return new Reponse(1, "Enregistré avec succes", user);
            } else {
                return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
            }

        }
    }

    @ApiOperation("Liste des utilisateur par page")
    @GetMapping(value = "/putilisateurs", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllUsersP(@RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        Reponse rep;
        try {
            rep = authentificationService.getAllUserPages(PageRequest.of(page, size));

        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }
        return rep;
        //return fidelisationService.listeOffre(new PageRequest(page, size));       
    }

    @ApiOperation("Créer un role")
    @PostMapping(value = "/rolsavee", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse Role(@RequestBody KtRole role) {
        KtRole r;
        boolean exists = authentificationService.searchExistsRole(role.getLibele());
        if (exists) {
            return new Reponse(2, "le role existe déjà ", null);
        } else {
            r = authentificationService.saveRole(role);
        }
        if (r != null) {

            return new Reponse(1, "enregistré  avec succes", role);
        } else {

            return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
        }
    }

    @ApiOperation("Liste des roles par page")
    @GetMapping(value = "/proles", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllRoles(@RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {

        Reponse rep;
        try {
            rep = authentificationService.getAllRolePages(PageRequest.of(page, size));
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }
        return rep;
    }

    @ApiOperation("Liste des privilège par page")
    @GetMapping(value = "/pprivileges", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse getAllPrivileges(@RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {

        Reponse rep;
        try {
            rep = authentificationService.getAllPrivilegePages(PageRequest.of(page, size));
        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);
        }
        return rep;
    }

  
    @ApiOperation("Mettre à jour un utilisateur ")
    @PutMapping(value = "/utilisateurs/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reponse updateUser(@RequestBody KtUtilisateur utilisateur, @PathVariable("id") Integer id) {
        Reponse rep;
        try {
            utilisateur.setId(id);
            String encPassWord = authentificationService.stringToBcrypt(utilisateur.getMotDePasse());
            utilisateur.setMotDePasse(encPassWord);
            utilisateur.setCommercant(commercantService.searchCommercant(utilisateur.getCommercant().getCode()));
            utilisateur.setRole(authentificationService.getOneRole(utilisateur.getRole().getId()));
            KtUtilisateur u = authentificationService.updateUser(utilisateur);
            rep = new Reponse(1, "mis à jour avec succès", u);

        } catch (Exception e) {
            rep = new Reponse(0, e.getMessage(), null);

        }
        return rep;
    }
    
    @ApiOperation("Mettre à jour un privilège ")
    @RequestMapping(value = "/privileges/{code}", method = RequestMethod.PUT , produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse updateRole(@RequestBody KtPrivilege privilege, @PathVariable("code") String code) {
            Reponse rep;
            try{
                 privilege.setCode(code);
                  KtPrivilege p = authentificationService.updatePrivilege(privilege);
                rep =  new Reponse(1, "mis à jour avec succes", p);   
            }catch(Exception e){
                rep = new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);  
            } 
          return rep; 
        }

    
    @ApiOperation("Mettre à jour un role ")
    @RequestMapping(value = "/privileges/{id}", method = RequestMethod.PUT , produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse updateRole(@RequestBody KtRole role, @PathVariable("code") Integer id) {
            Reponse rep;
            try{
                 role.setId(id);
                 KtRole r = authentificationService.updateRole(role);
                 rep =  new Reponse(1, "mis à jour avec succes", r);   
            }catch(Exception e){
                rep = new Reponse(0, "Une erreur s'est produite pendant la mise à jour", null);  
            } 
          return rep; 
        }

    @ApiOperation("supprimer un utilisateur")
    @RequestMapping(value = "/utilisateurs/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") Integer id) {
        authentificationService.deleteUser(id);
    }

    @ApiOperation("supprimer un role")
    @RequestMapping(value = "/roles/{id}", method = RequestMethod.DELETE)
    public void deleteRole(@PathVariable("id") Integer id) {
        authentificationService.deleteRole(id);
    }

    @ApiOperation("supprimer un privilège")
    @RequestMapping(value = "/privileges/{code}", method = RequestMethod.DELETE)
    public void deletePrivilege(@PathVariable("code") String code) {
        authentificationService.deletePrivilege(code);
    }

}
