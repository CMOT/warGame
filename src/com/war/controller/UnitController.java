/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.controller;

import com.war.model.Bullet;
import com.war.model.CatalogUnit;
import com.war.model.Unit;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class UnitController {
    
    private ArrayList<Unit> listEnemies;
    private ArrayList<Unit> listAllies;
    CatalogUnit units;
    
    public UnitController(){
        listEnemies= new ArrayList<Unit>();
        listAllies= new ArrayList<Unit>();
        units= new CatalogUnit();
    }
    
    public void fillListEnemies(int size, int radioX, int radioY){
        
        for(int i=0; i < size; i++){
            getListEnemies().add(units.getWolf(radioX+(int)(Math.random()*80 + 1), radioY +(int)(Math.random()*30 + 120)*i, 2));
        }
        
    }
    
    public void fillListAllies(int x, int y){
        getListAllies().add(units.getKratos(x, y, 1));
        getListAllies().add(units.getMasterChief(x*2, y+100, 1));
        
    }

    public boolean moveUnit( Unit selected){
        if(selected!= null){
            if(selected.getX()!=selected.getLimit().x){
                selected.setX(selected.getX()+ selected.getMoveX());
            }
            if(selected.getY()!=selected.getLimit().y){
                selected.setY(selected.getY()+ selected.getMoveY());
            }
            return !(selected.getX()== selected.getLimit().x && selected.getY()== selected.getLimit().y);
        }else{
            return false;
        }
    }
    
    public boolean unitShooter(Bullet shooted){
        if(shooted.isShooted()){
            shooted.setX(shooted.getX()+3);
        }
        return true;
    }
    /**
     * @return the listEnemies
     */
    public ArrayList<Unit> getListEnemies() {
        return listEnemies;
    }

    /**
     * @return the listAllies
     */
    public ArrayList<Unit> getListAllies() {
        return listAllies;
    }
    
    
    
}
