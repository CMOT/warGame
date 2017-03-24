/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.controller;

import com.war.GUI.Menu;
import com.war.model.Build;
import com.war.model.CatalogBuild;
import com.war.model.Unit;
import com.war.utils.CommonUtils;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author TMK
 */
public class BuildController {
    
    private ArrayList<Build> listBuilds;
    private ArrayList<Build> listBuildAllies;
    int count;
    private CatalogBuild catalog;
    
    public BuildController(){
        listBuilds= new ArrayList();
        listBuildAllies= new ArrayList();
        catalog= new CatalogBuild();
        count=1;
    }
    
    public void fillBuildEnemies(int x, int y, int team, int difficult){
        switch(Menu.levelNumber){
            case 1:
                getListBuilds().add(catalog.getMetropoly(x, y, team));
                break;
            case 2:
                getListBuilds().add(catalog.getPyramid(x, y, team));
                break;
            case 3:
                getListBuilds().add(catalog.getMansion(x, y, team));
                break;
        }
        
    }
    
    public void fillBuildAllies(int x, int y, int team){
        getListBuildAllies().add(catalog.getTrainningBuild(x, y, team));
    }

    public ImageIcon getBuildImage(int state, String nameImage){
        String url= "";
        switch(state){
            case 0:
                url="/builds/"+nameImage+state+".png";
                break;
            case 1:
                url="/builds/"+nameImage+state+".png";
            case 2:
                url="/builds/"+nameImage+state+".gif";
        }
        return new ImageIcon(getClass().getResource(url));
        
    }
    
    public boolean createUnit(){
        boolean create=false;
        if(CommonUtils.createUnit){
            CommonUtils.timeUnit++;
            if(CommonUtils.timeUnit==100){
                create=true;
                CommonUtils.timeUnit=0;
                CommonUtils.createUnit=false;
            }
        }
        return create;
    }
            
    public boolean equalsGame(int points){
        if(points <= 500 && count ==1){
            count++;
            return true;
        }else if(  points <= 300 && count==2){
            count++;
            return true;
        }else if(points <= 200 && count==3){
            count++;
            return true;
        }else if(points <= 100 && count==4){
            count++;
            return true;
        }else if(points <= 50 && count==5){
            count++;
            return true;
        }else{
            
            return false;
        }
        
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

    /**
     * @return the listBuildAllies
     */
    public ArrayList<Build> getListBuildAllies() {
        return listBuildAllies;
    }

    /**
     * @param listBuildAllies the listBuildAllies to set
     */
    public void setListBuildAllies(ArrayList<Build> listBuildAllies) {
        this.listBuildAllies = listBuildAllies;
    }
    
    
    
}
