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
        return new Marine("Marine", 50, x, y , 8 , "soldado", team, "bala", 80);
    }
    
    public Unit getKratos(int x, int y, int team){
        return new Marine("Kratos", 300, x, y , 42 , "s2", team, "espada", 90);
    }
    
    public Unit getMasterChief(int x, int y, int team){
        return new Marine("Master Chief", 250, x, y , 15 , "soldado", team, "bala", 40);
    }
    
    public Unit getAmetrallador(int x, int y, int team){
        return new Marine("Ametrallador", 200, x, y , 9 , "ametrallador", team, "metralleta", 60);
    }
    
    public Unit getZombie(int x, int y, int team){
        return new Marine("Momia", 30, x, y , 9 , "momia", team, "bala", 80);
    }
    
    public Unit getClown(int x, int y, int team){
        return new Marine("Clown", 40, x, y , 9 , "payaso", team, "bala", 80);
    }
    
    public Unit getClownBoss(int x, int y, int team){
        return new Marine("CLow Bot", 600, x, y , 140 , "payasobot", team, "bomb", 170);
    }
    
}
