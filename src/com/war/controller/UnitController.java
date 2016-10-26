/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.controller;

import com.war.model.Build;
import com.war.model.Bullet;
import com.war.model.CatalogUnit;
import com.war.model.Unit;
import com.war.utils.CommonUtils;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author ASUS
 */
public class UnitController {
    
    private volatile ArrayList<Unit> listEnemies;
    private volatile ArrayList<Unit> listAllies;
    CatalogUnit units;
    
    public UnitController(){
        listEnemies= new ArrayList<Unit>();
        listAllies= new ArrayList<Unit>();
        units= new CatalogUnit();
    }
    
    public void fillListEnemies(int size, int radioX, int radioY){
        int count =1;
        for(int i=0; i < size; i++){
            if(count==4){
                count=1;
            }
            getListEnemies().add(units.getClown(radioX+(int)(Math.random()*100 + 1), radioY +(int)(Math.random()*120 + 20)*count, 2));
            count++;
            
        }
    }
    
    public void fillListAllies(int x, int y){
        getListAllies().add(units.getKratos(x, y, 1));
        getListAllies().add(units.getMasterChief(x*2, y+100, 1));
    }

    public boolean moveUnit( Unit selected){
         
        if(selected!= null){
            if(selected.getX()!=selected.getLimit().x && selected.getState()==1 ){
                if(selected.getLimit().x-selected.getX()>150 ){
                    selected.setX(selected.getX()+ selected.getMoveX());
                }else{
                    selected.setX(selected.getX()- selected.getMoveX());
                }
            }
            if(selected.getY()!=selected.getLimit().y && selected.getState()==1){
                    selected.setY(selected.getY()+ selected.getMoveY());
            }
            if(selected.getTarget() != null ){
               
                if(selected.getTarget() instanceof Unit){
                    Unit unitT=(Unit) selected.getTarget();
                     selected.setLimit(new Point(unitT.getX(), unitT.getY()));
                     selected.setMoveX(unitT.getX() - selected.getX() > 0 ? 1 : -1);
                     selected.setMoveY(unitT.getY() - selected.getY() > 0 ? 1 : -1);
                    if( CommonUtils.isCloseToThePoint(selected.getY(), unitT.getY(), unitT.getImage().getIconHeight())){
                       selected.setState(2);
                       selected.setImage(getImageState(selected.getNameImage(), 2));
                   }else{
                        selected.setState(1);
                       selected.setImage(getImageState(selected.getNameImage(), 1));
                    }
                }else
                if(selected.getTarget() instanceof Build){
                    Build buildT=(Build) selected.getTarget();
                     selected.setLimit(new Point(buildT.getX(), buildT.getY()));
                     selected.setMoveX(buildT.getX() - selected.getX() > 0 ? 1 : -1);
                     selected.setMoveY(buildT.getY() - selected.getY() > 0 ? 1 : -1);
                    if( CommonUtils.isCloseToThePoint(selected.getY(), buildT.getY(), buildT.getImage().getIconHeight())){
                       selected.setState(2);
                       selected.setImage(getImageState(selected.getNameImage(), 2));
                   }else{
                        selected.setState(1);
                       selected.setImage(getImageState(selected.getNameImage(), 1));
                    }
                }
            }else{
                       selected.setState(1);
                       selected.setImage(getImageState(selected.getNameImage(), 1));
            }
            return !(selected.getX()== selected.getLimit().x && selected.getY()== selected.getLimit().y);
        }else{
            return false;
        }
    }
    
    public Bullet unitShooter(Unit shooted){
        Bullet bullet= null;
        if(shooted.getState()==2 && shooted.getTarget()!=null){
            if(shooted.getLimit().x-shooted.getX()<180 ){
                   shooted.setX(shooted.getX()- shooted.getMoveX());
                   shooted.setImage(getImageState(shooted.getNameImage(), 1));
            }
            if(shooted.getCountShoot()==shooted.getShootCold()){
                bullet= new Bullet((int)shooted.getForce(), shooted.getX()+5, shooted.getY()+5, shooted.getBulletType(), shooted.getTeam(), shooted.getTarget().getX(), shooted.getTarget().getY());
                shooted.setCountShoot(0);
            }
        }
        return bullet;
    }
    
    public void randomMove(Unit unit){
        unit.setMoveCount(unit.getMoveCount()+1);
        if(unit.getMoveCount()==80){
            unit.setState(1);
            unit.setImage(getImageState(unit.getNameImage(), 1));
            double random=Math.random();
            double randomY=Math.random();
            unit.setMoveX(1);
            if(unit.getY()<CommonUtils.height-80 && randomY>.5){
                unit.setMoveY(1); 
            }else{
                if(unit.getY()>40)
                unit.setMoveY(-1);
            }
            if(unit.getX()<CommonUtils.width-80 && random>.5){
                unit.setMoveX(1);
                unit.setLimit(new Point(unit.getX()+ (int)(Math.random()*90), (int)(unit.getY()+randomY*30) ));
            }else{
                unit.setMoveX(-1);
                unit.setLimit(new Point(unit.getX()- (int)(Math.random()*90), (int)(unit.getY()-randomY*30) ));
            }
            unit.setMoveCount(0);
        }
        if(unit.getState()==1 && unit.getX()!=unit.getLimit().x ){
            unit.setX(unit.getX()+ unit.getMoveX());
        }
        if(unit.getState()==1 && unit.getY()!=unit.getLimit().y ){
            unit.setY(unit.getY()+ unit.getMoveY());
        }
        if(unit.getX()== unit.getLimit().x && unit.getY()== unit.getLimit().y){
            unit.setState(0);
            unit.setImage(getImageState(unit.getNameImage(), 0));
        }
    }
    
    public ImageIcon getImageState(String image,int state){
        String url="images/units/"+image+""+state;
        switch(state){
            case 0:
                url+=".png";
                break;
            case 1:
                url+=".gif";
                break;
            case 2:
                url+=".png";
                break;
        }
        return new ImageIcon(url);
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
