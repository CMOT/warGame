/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.model;

import com.war.utils.CommonUtils;

/**
 *
 * @author ASUS
 */
public class CatalogBuild {

    public CatalogBuild() {
    }
    
    public Build getMetropoly(int x, int y, int team){
        return new Metropoly("Fun House", 100*CommonUtils.difficult, 30 , x, y , "funhouse", team );
    }
    
    public Build getTower(int power ,int x, int y, int team){
        return new Tower(power, 50,"Tower", 40*CommonUtils.difficult, 10 , x, y , "tower", team , "arrow");
    }
    
    public Build getPyramid(int x, int y, int team){
        return new Metropoly("Pyramid", 100*CommonUtils.difficult, 30 , x, y , "piramide", team );
    }
    
    public Build getMansion(int x, int y, int team){
        return new Metropoly("Mansion", 100*CommonUtils.difficult, 30 , x, y , "mansion", team );
    }
    
    public Build getTrainningBuild(int x, int y, int team){
        return new Metropoly("Castle", 100, 30 , x, y , "castillo", team );
    }
    
}
