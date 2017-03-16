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
        return new Metropoly("Fun House", 20*CommonUtils.difficult, 30 , x, y , "funhouse", team );
    }
    
    public Build getPyramid(int x, int y, int team){
        return new Metropoly("Pyramid", 20*CommonUtils.difficult, 30 , x, y , "píramide", team );
    }
    
    public Build getTrainningBuild(int x, int y, int team){
        return new Metropoly("Castle", 100, 30 , x, y , "castillo", team );
    }
    
}
