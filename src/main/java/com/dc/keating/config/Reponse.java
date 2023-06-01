/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dc.keating.config;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class Reponse implements Serializable{
	
	private int status;
	private String message;
        private Object data;
	
	public Reponse(int status, String message, Object data) {
		super();
		this.status = status;
		this.message = message;
                this.data=data;
	}
	public Reponse() {
		super();
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
        
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
        
        public Object getData(){
            return data;
        }
	
        public void setData(Object data) {
		this.data= data;
	}

}
