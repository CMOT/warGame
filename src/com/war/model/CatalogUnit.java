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
        return new Marine("Marine", 100, x, y , 30 , "soldado", team, "bala", 80);
    }
    
    public Unit getKratos(int x, int y, int team){
        return new Marine("Kratos", 300, x, y , 42 , "s2", team, "espada", 90);
    }
    
    public Unit getMasterChief(int x, int y, int team){
        return new Marine("Master Chief", 250, x, y , 15 , "soldadon", team, "bala", 40);
    }
    
    public Unit getTank(int x, int y, int team){
        return new Marine("Tanque", 350, x, y , 11 , "tanque", team, "metralleta", 60);
    }
    
    public Unit getMomia(int x, int y, int team){
        return new Marine("Momia", 50, x, y , 4 , "momia", team, "bala", 80);
    }
    
    public Unit getVampiro(int x, int y, int team){
        return new Marine("Momia", 80, x, y , 10 , "vampiro", team, "bala", 80);
    }
    
    public Unit getClown(int x, int y, int team){
        return new Marine("Clown", 40, x, y , 9 , "payaso", team, "bala", 80);
    }
    
    public Unit getClownBoss(int x, int y, int team){
        return new Marine("CLow Bot", 40, x, y , 140 , "payasobot", team, "bomb", 130);
    }
    public Unit getMomBoss(int x, int y, int team){
        return new Marine("Mom Momia", 40, x, y , 140 , "bossMom", team, "papeleta", 130);
    }
    
    public Unit getVampireBoss(int x, int y, int team){
        return new Marine("Vampire Boss", 40, x, y , 140 , "vampireBoss", team, "bat", 130);
    }
    
}
