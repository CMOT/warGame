/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.model;

import com.war.utils.CommonUtils;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/**
 *
 * @author ASUS
 */
public class Marine extends Unit{
    
    
    public Marine() {
        super();
    }
    
    public Marine(String name, int lifePoints, int x, int y, int force, String unit, int team, String bullet, int shootCold){
        super(name, lifePoints, x, y, force, unit, team, bullet, shootCold);
    }
    
    @Override
    public void paint(Graphics2D g){
        
        if(super.getTeam()!=2){
            g.setColor(Color.gray);
            g.fillRect(super.getX()+5, super.getY()-14, super.getImage().getIconWidth()-5, 4);
            g.setColor(Color.blue);
            g.fillRect(super.getX()+5, super.getY()-14, CommonUtils.getPercent(super.getCountShoot(), super.getShootCold(),super.getImage().getIconWidth()-5), 4);
        }
        g.setColor(Color.red);
        g.fillRect(super.getX()+5, super.getY()-8, super.getImage().getIconWidth()-5, 4);
        g.setColor(Color.green);
        g.fillRect(super.getX()+5, super.getY()-8, CommonUtils.getPercent(super.getHealtPoints(), super.getLifePoints(),super.getImage().getIconWidth()-5), 4);
//        if(super.getTeam()==2){
//            g.setColor(Color.red);
//            g.draw(super.getRatio());
//            g.draw(super.getCollisionRec());
//        }
        if(super.getTarget()== null && super.getLimit().getX()!= super.getX() || super.getLimit().getY()!= super.getY()){
            if( super.getTeam()!=2){
                g.drawImage((new ImageIcon(getClass().getResource("/images/point.png"))).getImage(), (int)super.getLimit().getX(),(int) super.getLimit().getY(),  null);
            }
        }
        if(super.getTarget()!= null){
                g.setColor(Color.red);
                g.drawRect(super.getTarget().getX(), super.getTarget().getY(), super.getTarget().getImage().getIconWidth(), super.getTarget().getImage().getIconHeight());
        }
        g.drawImage(super.getImage().getImage(), super.getX(), super.getY(), null);
    }
    
}
