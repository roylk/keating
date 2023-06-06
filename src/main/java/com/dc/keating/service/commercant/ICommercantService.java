/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dc.keating.service.commercant;

import com.dc.keating.config.Reponse;
import com.dc.keating.entities.KtCommercant;
import com.dc.keating.entities.KtPointDeVente;
import com.dc.keating.entities.UfTerminal;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author user
 */
public interface ICommercantService {
    public List<KtCommercant> listeCommercant();
    public Reponse listeCommercant(Pageable pageable);
    
    
    public List<KtPointDeVente> listePointDeVente();
    public Reponse listePointDeVente(Pageable pageable);
    
    public List<UfTerminal> listeTerminal();
    public Reponse listeTerminal(Pageable pageable);
    
    public KtCommercant saveCommercant(KtCommercant commercant);
    public KtPointDeVente savePointDeVente(KtPointDeVente pointDeVente);
    public UfTerminal saveTerminal(UfTerminal terminal);
   
    
    public KtCommercant searchCommercant(String code);
    
    public Page<KtCommercant> SearchCommercants(String mc, Pageable pageable);
    
    public KtCommercant updateCommercant(KtCommercant commercant);
    
    public void deleteCommercant(String code);
    
    public KtPointDeVente searchPointDeVente(String code);
    

    public Page<KtPointDeVente> searchPointsDeVente(String mc, Pageable pageable);
    
    public KtPointDeVente updatePointsDeVente(KtPointDeVente pointDeVente);
    
    public void deletePointsDeVente(String code);
    
    public UfTerminal searchTerminal(String code);
    
    public Page<UfTerminal> searchTerminal(String mc, Pageable pageable);
    
    public UfTerminal updateTerminal(UfTerminal terminal);
    
    public void deleteTerminal(String code);
     
    public Reponse getAllCommercant();
    public Reponse getAllPointDeVente();
    public Reponse getAllTerminal();
    
    public boolean searchExistsCom(String code);
    public boolean searchExistTerm(String code);
    
    
}
