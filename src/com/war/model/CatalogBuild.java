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
public class CatalogBuild {

    public CatalogBuild() {
    }
    
    
    public Build getMetropoly(int x, int y, int team){
        return new Metropoly("Fun House", 400, 30 , x, y , "funhouse", team );
    }
    
    public Build getTrainningBuild(int x, int y, int team){
        return new Metropoly("Trainning Build", 100, 30 , x, y , "castillo", team );
    }
    
}
