package com.dc.keating;

import com.dc.keating.dao.KtPaysRepository;
import com.dc.keating.dao.KtRegionRepository;
import com.dc.keating.dao.KtVilleRepository;
import com.dc.keating.entities.KtPays;
import com.dc.keating.entities.KtRegion;
import com.dc.keating.entities.KtVille;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableJpaAuditing // Enabling JPA Auditing
public class KeatingApplication implements CommandLineRunner{
    @Autowired
    private KtPaysRepository paysRepository;
    
    @Autowired
    private KtRegionRepository regionRepository;
    
    @Autowired
    private KtVilleRepository villeRepository;

	public static void main(String[] args) {
		SpringApplication.run(KeatingApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        /* KtPays p1= paysRepository.save(new KtPays("CMR", "CAMEROUN", new Date()));
         KtRegion r2 =regionRepository.save(new KtRegion("CTR", "CENTRE", new Date(), p1));
                
         KtVille v1=villeRepository.save(new KtVille("YDE","YAOUNDE", new Date(), r2)); 
                
         // KtVille v2=villeRepository.save(new UfVille("YDE", "YAOUNDE", new Date(), r2));µ*/
    }

}
