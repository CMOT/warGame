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
        return new Metropoly("Metropoly", 150, 30 , x, y , "center1", team );
    }
    
}
