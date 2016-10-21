/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.controller;

import com.war.model.Build;
import com.war.model.CatalogBuild;
import java.util.ArrayList;

/**
 *
 * @author TMK
 */
public class BuildController {
    
    private ArrayList<Build> listBuilds;
    private CatalogBuild catalog;
    
    public BuildController(){
        listBuilds= new ArrayList();
        catalog= new CatalogBuild();
    }
    
    public void fillBuildEnemies(int x, int y, int team){
        getListBuilds().add(catalog.getMetropoly(x, y, team));
    }

    /**
     * @return the listBuilds
     */
    public ArrayList<Build> getListBuilds() {
        return listBuilds;
    }

    /**
     * @param listBuilds the listBuilds to set
     */
    public void setListBuilds(ArrayList<Build> listBuilds) {
        this.listBuilds = listBuilds;
    }
    
    
    
}
