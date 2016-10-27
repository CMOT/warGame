/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.controller;

import com.war.model.Build;
import com.war.model.CatalogBuild;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author TMK
 */
public class BuildController {
    
    private ArrayList<Build> listBuilds;
    private ArrayList<Build> listBuildAllies;
    private CatalogBuild catalog;
    
    public BuildController(){
        listBuilds= new ArrayList();
        catalog= new CatalogBuild();
    }
    
    public void fillBuildEnemies(int x, int y, int team){
        getListBuilds().add(catalog.getMetropoly(x, y, team));
        getListBuilds().add(catalog.getTrainningBuild(20, 200, team));
    }

    public ImageIcon getBuildImage(int state, String nameImage){
        
        switch(state){
            case 0:
                return new ImageIcon("images/builds/"+nameImage+state+".png");
            case 1:
                return new ImageIcon("images/builds/"+nameImage+state+".png");
            case 2:
                return new ImageIcon("images/builds/"+nameImage+state+".gif");
        }
        return null;
        
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
