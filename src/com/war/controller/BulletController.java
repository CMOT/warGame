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
    private volatile ArrayList<Bullet> listBulletsEnemies;
    
    public BulletController(){
        listBullets= new ArrayList<>();
        listBulletsEnemies= new ArrayList<>();
    }
    
    public Unit shootEnemies(ArrayList<Unit> list){
        boolean removed=false;
        Unit removedUnit= null;
        for( Bullet bullet :listBullets){
            for(Unit unit:list ){
                if(bullet.getCollisionRec().intersects(unit.getCollisionRec())){
                    unit.setHealtPoints(unit.getHealtPoints()-bullet.getPower());
                    removed=true;
                    if(unit.getHealtPoints()<0){
                        CommonUtils.points+=unit.getLifePoints();
//                        CommonUtils.selected=null;
                        list.remove(unit);
                        removedUnit= unit;
                    }
                    break;
                }
            }
            if(removed || bullet.getX()>CommonUtils.width){
                listBullets.remove(bullet);
                break;
            }
        }
        return removedUnit;
    }
    public void shootBoss(Unit boss){
        for(Bullet bullet: getListBullets()){
            if(bullet.getCollisionRec().intersects(boss.getCollisionRec())){
                boss.setHealtPoints(boss.getHealtPoints()-bullet.getPower());
                getListBullets().remove(bullet);
                break;
            }
        }
    }
    
     public Unit shootAllies(ArrayList<Unit> list){
        boolean removed=false;
        Unit removedUnit= null;
        for( Bullet bullet :listBulletsEnemies){
            for(Unit unit:list ){
                if(bullet.getCollisionRec().intersects(unit.getCollisionRec())){
                    unit.setHealtPoints(unit.getHealtPoints()-bullet.getPower());
                    removed=true;
                    if(unit.getHealtPoints()<0){
//                        CommonUtils.points+=unit.getLifePoints();
//                        CommonUtils.selected=null;
                        list.remove(unit);
                        removedUnit= unit;
                    }
                    break;
                }
            }
            if(removed || bullet.getX()<0){
                listBulletsEnemies.remove(bullet);
                break;
            }
        }
        return removedUnit;
    }
     
    public Build shootBuildsAllies(ArrayList<Build> list){
        boolean removed=false;
        Build removedBuild=null;
        for( Bullet bullet :listBulletsEnemies){
            for(Build build:list ){
                if(bullet.getCollisionRec().intersects(build.getCollisionRec())){
                    build.setHealtPoints(build.getHealtPoints()-bullet.getPower());
                    removed=true;
                    if(build.getHealtPoints()<0){
//                        CommonUtils.points+=build.getLifePoints()/10;
                        list.remove(build);
                        removedBuild=build;
                    }
                    break;
                }
            }
            if(removed || bullet.getX()<0){
                listBulletsEnemies.remove(bullet);
                break;
            }
        }
        return removedBuild;
    }
     
    public Build shootBuilds(ArrayList<Build> list){
        boolean removed=false;
        Build removedBuild=null;
        for( Bullet bullet :listBullets){
            for(Build build:list ){
                if(bullet.getCollisionRec().intersects(build.getCollisionRec())){
                    build.setHealtPoints(build.getHealtPoints()-bullet.getPower());
                    removed=true;
                    if(build.getHealtPoints()<0){
                        CommonUtils.points+=build.getLifePoints()/10;
                        list.remove(build);
                        removedBuild=build;
                    }
                    break;
                }
            }
            if(removed || bullet.getX()>CommonUtils.width){
                listBullets.remove(bullet);
                break;
            }
        }
        return removedBuild;
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

    public ArrayList<Bullet> getListBulletsEnemies() {
        return listBulletsEnemies;
    }

    public void setListBulletsEnemies(ArrayList<Bullet> listBulletsEnemies) {
        this.listBulletsEnemies = listBulletsEnemies;
    }
    
    
    
}
