package com.ibolt.services;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ibolt.util.ConnectFilemaker;

import jersey.repackaged.com.google.common.collect.Lists;

public class ControlServices {
    ConnectFilemaker cf;
    Statement sttm;

    public void CreateConnection() throws Exception {
        System.out.println("Criando a Conexão");
        this.cf = new ConnectFilemaker();
        this.sttm = this.cf.getCon().createStatement();
    }

    public void CloseConnection() {
        System.out.println("Fechou a Conexão");
        try {
            this.sttm.close();
            this.cf.getCon().close();
            super.finalize();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public ConnectFilemaker getCf() {
        return this.cf;
    }

    public void setCf(ConnectFilemaker cf) {
        this.cf = cf;
    }

    public Statement getSttm() {
        return this.sttm;
    }

    public void setSttm(Statement sttm) {
        this.sttm = sttm;
    }
    
    protected void removeCaracteres(Object obj) throws IllegalArgumentException, IllegalAccessException{
		Class<?> classe = obj.getClass();      
        Field[] campos = classe.getDeclaredFields();        

        for (Field campo : campos) {    
        	if (campo.getType().isAssignableFrom(String.class)) {
        		campo.setAccessible(true);
        		String string = (String) campo.get(obj);   
        		if (string != null){
	        		int position = string.indexOf("'");
	        		List<Integer> lstP = new ArrayList<Integer>();
	        		
	        		while (position != -1){
	        			lstP.add(position);
	        			string = string.replaceFirst("'", "");
	        			position = string.indexOf(("'"));
	        		}
	        		for (Integer pos : Lists.reverse(lstP)) {
	        			string = string.substring(0, pos) + "''" + string.substring(pos);//p.setEntregaRua(p.getEntregaRua().substring(0, pos) + "''" + p.getEntregaRua().substring(pos));
	        			
	        		}
	        		lstP.clear();
	        		
	        		string = string.replaceAll("🏠", "");
	        		
	        		campo.set(obj, string);
        		}
        	}
        }       
	}
}