/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dc.keating.service.regionalisation;

import com.dc.keating.config.Reponse;
import com.dc.keating.entities.KtPays;
import com.dc.keating.entities.KtRegion;
import com.dc.keating.entities.KtVille;
import java.util.List;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author user
 */
public interface IRegionalisationService {
    public List<KtVille> listeVille();
    public List<KtRegion> listeRegion();
    public List<KtPays> listePays();
    public Reponse listeVille(Pageable pageable);
    public Reponse listeRegion(Pageable pageable);
    public Reponse listePays(Pageable pageable);
    
    public List<KtRegion> getAllRegionByPays(String codeP);
    
    public List<KtVille> getAllVilleByRegion(Integer codeR);
    
    
    public KtPays SavePays(KtPays pays);
    
    public KtVille saveVille(KtVille ville);
    
    public KtRegion saveRegion(KtRegion region);
    
    public KtVille getOneVille(Integer id);
    
    public KtRegion getOneRegion(Integer id);
    
    public KtPays getOnePays(String code);
    
    public KtVille getOneVilleByCode(String code);
    
    
    
    public KtPays updatePays(KtPays pays);
    public KtVille updateVille(KtVille ville);
    public KtRegion updateRegion(KtRegion region);
    
    
    public void deletePays(String code);
    public void  deleteVille(Integer id);
    public void deleteRegion(Integer id);
    public Reponse GetAllPays();
    public Reponse getAllRegion();
    public Reponse getAllVille();
    
}
