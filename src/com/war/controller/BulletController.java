/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.controller;

import com.war.model.Build;
import com.war.model.Bullet;
import com.war.model.Unit;
import com.war.utils.CommonUtils;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class BulletController {
    
    private volatile ArrayList<Bullet> listBullets;
    
    public BulletController(){
        listBullets= new ArrayList<>();
    }
    
    public void addBullet(Bullet bullet){
        
        getListBullets().add(bullet);
        getListBullets().add(new Bullet());
    }

    public void shootEnemies(ArrayList<Unit> list){
        boolean removed=false;
        for( Bullet bullet :listBullets){
            for(Unit unit:list ){
                if(bullet.getCollisionRec().intersects(unit.getCollisionRec())){
                    unit.setHealtPoints(unit.getHealtPoints()-bullet.getPower());
                    removed=true;
                    if(unit.getHealtPoints()<0){
                        list.remove(unit);
                    }
                    break;
                }
            }
            if(removed || bullet.getX()>CommonUtils.width){
                listBullets.remove(bullet);
                break;
            }
        }
        
    }
    public void shootBuilds(ArrayList<Build> list){
        boolean removed=false;
        for( Bullet bullet :listBullets){
            for(Build build:list ){
                if(bullet.getCollisionRec().intersects(build.getCollisionRec())){
                    build.setHealtPoints(build.getHealtPoints()-bullet.getPower());
                    removed=true;
                    if(build.getHealtPoints()<0){
                        list.remove(build);
                    }
                    break;
                }
            }
            if(removed || bullet.getX()>CommonUtils.width){
                listBullets.remove(bullet);
                break;
            }
        }
        
    }
    /**
     * @return the listBullets
     */
    public ArrayList<Bullet> getListBullets() {
        return listBullets;
    }

    /**
     * @param listBullets the listBullets to set
     */
    public void setListBullets(ArrayList<Bullet> listBullets) {
        this.listBullets = listBullets;
    }
    
    
    
}
