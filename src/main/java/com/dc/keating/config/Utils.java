/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dc.keating.config;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author user
 */
@Configuration 
public class Utils {
      /**
     * Hashing with SHA1
     *
     * @param input String to hash
     * @return String hashed
     */
    public static String sha1(String input) {
        String sha1 = null;

        try {
            MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
            msdDigest.update(input.getBytes("UTF-8"), 0, input.length());
            sha1 = DatatypeConverter.printHexBinary(msdDigest.digest()).toLowerCase();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
           // Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
            
        }

        return sha1;
    }
    
    
 @Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
    
    
}
