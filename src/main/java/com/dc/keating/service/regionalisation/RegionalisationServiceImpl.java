/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dc.keating.service.regionalisation;

import com.dc.keating.config.Reponse;
import com.dc.keating.dao.KtPaysRepository;
import com.dc.keating.dao.KtRegionRepository;
import com.dc.keating.dao.KtVilleRepository;
import com.dc.keating.entities.KtPays;
import com.dc.keating.entities.KtRegion;
import com.dc.keating.entities.KtVille;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */

@Service
@Transactional
public class RegionalisationServiceImpl implements IRegionalisationService{
    
    @Autowired
    private KtVilleRepository villeRepository;
    
    @Autowired
    private KtRegionRepository regionRepository;
    
    @Autowired
    private KtPaysRepository paysRepository;

    @Override
    public List<KtVille> listeVille() {
        return villeRepository.findAll();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<KtRegion> listeRegion() {
        return regionRepository.findAll();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<KtPays> listePays() {
        return paysRepository.findAll();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse listeVille(Pageable pageable) {
        return new Reponse(1, "liste des viles",villeRepository.findAll(pageable));
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse listeRegion(Pageable pageable) {
        return new Reponse(1, "liste des régions",regionRepository.findAll(pageable));
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse listePays(Pageable pageable) {
        return new Reponse(1, "liste des pays", paysRepository.findAll(pageable));
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<KtRegion> getAllRegionByPays(String codeP) {
        return regionRepository.findAllRegionByPays(codeP);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<KtVille> getAllVilleByRegion(Integer codeR) {
        return villeRepository.findAllVilleByRegion(codeR);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtPays SavePays(KtPays pays) {
        return paysRepository.save(pays);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtVille saveVille(KtVille ville) {
        return villeRepository.save(ville);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtRegion saveRegion(KtRegion region) {
        return regionRepository.save(region);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtVille getOneVille(Integer id) {
        return villeRepository.findByIdVille(id);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtRegion getOneRegion(Integer id) {
        return regionRepository.findByIdRegion(id);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtPays getOnePays(String code) {
        return paysRepository.findByCodePays(code);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtVille getOneVilleByCode(String code) {
        return villeRepository.getOneByCode(code);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtPays updatePays(KtPays pays) {
        return paysRepository.saveAndFlush(pays);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtVille updateVille(KtVille ville) {
        return villeRepository.saveAndFlush(ville);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KtRegion updateRegion(KtRegion region) {
        return regionRepository.saveAndFlush(region);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deletePays(String code) {
        paysRepository.deleteById(code);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteVille(Integer id) {
        villeRepository.deleteById(id);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteRegion(Integer id) {
        regionRepository.deleteById(id);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse GetAllPays() {
        return new Reponse(1, "liste des pays",paysRepository.findAll());
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse getAllRegion() {
        return new Reponse(1, "liste des régions",listeRegion());
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Reponse getAllVille() {
        return new Reponse(1, "liste des villes",villeRepository.findAll());
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
