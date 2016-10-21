/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.model;

/**
 *
 * @author ASUS
 */
public class CatalogUnit {
    
    public CatalogUnit(){
    }
    
    public Unit getMarine(int x, int y, int team){
        return new Marine("Marine", 50, x, y , 8 , "marine"+team, team);
    }
    
    public Unit getKratos(int x, int y, int team){
        return new Marine("Kratos", 100, x, y , 16 , "units/s2", team);
    }
    
    public Unit getMasterChief(int x, int y, int team){
        return new Marine("Master Chief", 70, x, y , 12 , "units/s3", team);
    }
    
    public Unit getZombie(int x, int y, int team){
        return new Marine("Momia", 30, x, y , 9 , "units/momia", team);
    }
    
    public Unit getWolf(int x, int y, int team){
        return new Marine("Lobo", 45, x, y , 9 , "units/payaso1", team);
    }
    
}
