/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dc.keating.service.commercant;

import com.dc.keating.config.Reponse;
import com.dc.keating.dao.KtCommercantRepository;
import com.dc.keating.dao.KtPointDeVenteRepository;
import com.dc.keating.entities.KtCommercant;
import com.dc.keating.entities.KtPointDeVente;
import com.dc.keating.entities.UfTerminal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */

@Service 
@Transactional
public class CommercantServiceImpl implements ICommercantService {
    @Autowired
    KtCommercantRepository commercantRepository;
    
    @Autowired
    KtPointDeVenteRepository pointDeVenteRepository;
    
    

    @Override
    public List<KtCommercant> listeCommercant() {
        return commercantRepository.findAll();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse listeCommercant(Pageable pageable) {
        return new Reponse(1, "liste des commercants", commercantRepository.findAll(pageable));
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<KtPointDeVente> listePointDeVente() {
        return pointDeVenteRepository.findAll();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse listePointDeVente(Pageable pageable) {
        return new Reponse(1, "liste des points de vente",pointDeVenteRepository.findAll(pageable));
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<UfTerminal> listeTerminal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse listeTerminal(Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtCommercant saveCommercant(KtCommercant commercant) {
        return commercantRepository.save(commercant);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtPointDeVente savePointDeVente(KtPointDeVente pointDeVente) {
        return pointDeVenteRepository.save(pointDeVente);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UfTerminal saveTerminal(UfTerminal terminal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtCommercant searchCommercant(String code) {
        return  commercantRepository.findbyId(code);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Page<KtCommercant> SearchCommercants(String mc, Pageable pageable) {
        return commercantRepository.findCommercant(mc, pageable);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtCommercant updateCommercant(KtCommercant commercant) {
        return commercantRepository.saveAndFlush(commercant);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteCommercant(String code) {
        commercantRepository.deleteById(code);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtPointDeVente searchPointDeVente(String code) {
        return pointDeVenteRepository.findbyId(code);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Page<KtPointDeVente> searchPointsDeVente(String mc, Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtPointDeVente updatePointsDeVente(KtPointDeVente pointDeVente) {
        return pointDeVenteRepository.saveAndFlush(pointDeVente);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deletePointsDeVente(String code) {
        pointDeVenteRepository.deleteById(code);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UfTerminal searchTerminal(String code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Page<UfTerminal> searchTerminal(String mc, Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UfTerminal updateTerminal(UfTerminal terminal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteTerminal(String code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse getAllCommercant() {
        return new Reponse(1,"liste des commerçants",listeCommercant());
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse getAllPointDeVente() {
        return new Reponse(1, "liste des points de ventes", pointDeVenteRepository.findAll());
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse getAllTerminal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean searchExistsCom(String code) {
        return commercantRepository.existsById(code);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean searchExistTerm(String code) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean searchExistsPv(String code) {
        return pointDeVenteRepository.existsById(code);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse ListPointDeVenteByCommercant(String codeC, Pageable pageable) {
        return new Reponse(1, "liste des points de vente par commercant ",pointDeVenteRepository.findAllPointDeVenteByCommercant(codeC, pageable));
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
      
}
