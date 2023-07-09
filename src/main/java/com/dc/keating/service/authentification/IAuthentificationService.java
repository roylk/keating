package com.dc.keating.service.authentification;


import com.dc.keating.config.Reponse;
import com.dc.keating.entities.KtPrivilege;
import com.dc.keating.entities.KtRole;
import com.dc.keating.entities.KtUtilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author user
 */
public interface IAuthentificationService {
    
    public boolean searchExistsUser(String login, String motDePasse);
    
    public boolean searchExistUserById(Integer id);
    
    public boolean searchExistLogin(String login);
    
    public boolean searchExistEmail(String email);
    
    
    
    public KtUtilisateur searchUserByLogin(String code);
    
    public KtUtilisateur saveUser(KtUtilisateur utilisateur);
    public Reponse getAllUsers();
    public Page<KtUtilisateur> listeUser (Pageable pageable);
    public Reponse getAllUserPages(Pageable pageable);
    
    public KtRole saveRole(KtRole role);
    public KtRole getOneRole(Integer id);
    public Reponse getAllRolePages(Pageable pageable);
    public boolean searchExistsRole(String libele);
    
    public KtPrivilege savePrivilege(KtPrivilege privilege);
    public KtPrivilege getOnePrivilege(String code);
    public Reponse getAllPrivilegePages(Pageable pageable);
    public boolean searchExistsPrivilege(String code);
    
    public KtUtilisateur updateUser(KtUtilisateur user);
    public KtRole updateRole(KtRole role);
    public KtPrivilege updatePrivilege(KtPrivilege privilege); 
    
    public void deleteUser(Integer id);
    public void deleteRole(Integer id);
    public void deletePrivilege(String code);
     
    public String stringToBcrypt(String input);
    
    
    
}
