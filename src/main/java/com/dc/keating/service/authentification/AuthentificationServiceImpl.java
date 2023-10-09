/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dc.keating.service.authentification;

import com.dc.keating.config.Reponse;
import com.dc.keating.dao.KtPrivilegeRepository;
import com.dc.keating.dao.KtRoleRepository;
import com.dc.keating.dao.KtUtilisateurRepository;
import com.dc.keating.entities.KtPrivilege;
import com.dc.keating.entities.KtRole;
import com.dc.keating.entities.KtUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */

@Service
@Transactional
public class AuthentificationServiceImpl implements IAuthentificationService {
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private KtUtilisateurRepository utilisateurRepository;
    
    @Autowired
    private KtRoleRepository roleRepository;
    
    @Autowired
    private KtPrivilegeRepository privilegeRepository;

    @Override
    public boolean searchExistsUser(String login, String motDePasse) {
        KtUtilisateur user;
        
        user = utilisateurRepository.findbyLogin(login);
        System.out.println("utilisateur.........."+user);
        if (user != null) {
            System.out.println("mot de passe.........."+user.getMotDePasse());
            String cryptMotDePasse=passwordEncoder.encode(motDePasse);
           System.out.println("mot de passe encodé.........."+cryptMotDePasse);
          return passwordEncoder.matches(motDePasse,user.getMotDePasse());  
        } else {
            return false;
        }
         
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean searchExistUserById(Integer id) {
        return utilisateurRepository.existsById(id);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean searchExistLogin(String login) {
        KtUtilisateur user=utilisateurRepository.findbyLogin(login);
        return user != null;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean searchExistEmail(String email) {
         KtUtilisateur user=utilisateurRepository.findbyEmail(email);
        return user != null;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtUtilisateur searchUserByLogin(String code) {
        return utilisateurRepository.findbyLogin(code);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtUtilisateur saveUser(KtUtilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse getAllUsers() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Page<KtUtilisateur> listeUser(Pageable pageable) {
        return utilisateurRepository.findAll(pageable);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse getAllUserPages(Pageable pageable) {
        return new Reponse(1, "pages des utilisateurs", utilisateurRepository.findAll(pageable));
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtRole saveRole(KtRole role) {
        return roleRepository.save(role);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtRole getOneRole(Integer id) {
        return roleRepository.getOneById(id);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse getAllRolePages(Pageable pageable) {
        return new Reponse (1, "liste des roles", roleRepository.findAll(pageable));
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean searchExistsRole(String libele) {
        KtRole role=roleRepository.getOneByCode(libele);
        return role != null;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtPrivilege savePrivilege(KtPrivilege privilege) {
        return privilegeRepository.save(privilege);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtPrivilege getOnePrivilege(String code) {
        return privilegeRepository.findbyCode(code);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse getAllPrivilegePages(Pageable pageable) {
        return new Reponse(1, "liste des privilèges", privilegeRepository.findAll(pageable));
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean searchExistsPrivilege(String code) {
        return privilegeRepository.existsById(code);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtUtilisateur updateUser(KtUtilisateur user) {
        return utilisateurRepository.saveAndFlush(user);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtRole updateRole(KtRole role) {
        return roleRepository.saveAndFlush(role);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtPrivilege updatePrivilege(KtPrivilege privilege) {
        return privilegeRepository.saveAndFlush(privilege);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteUser(Integer id) {
        utilisateurRepository.deleteById(id);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteRole(Integer id) {
        roleRepository.deleteById(id);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deletePrivilege(String code) {
        privilegeRepository.deleteById(code);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String stringToBcrypt(String input) {
        return passwordEncoder.encode(input);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
