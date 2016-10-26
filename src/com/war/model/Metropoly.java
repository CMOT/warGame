/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.model;

import com.war.utils.CommonUtils;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author ASUS
 */
public class Metropoly extends Build{

    
    
    public Metropoly() {
        super();
    }
    
    public Metropoly(String name, int lifePoints, int capacity, int x, int y, String build, int team){
        super(name, lifePoints, capacity, x, y,  build, team);
        
        
    }
    
    @Override
    public void paint(Graphics2D g){
        
        g.setColor(Color.red);
        g.fillRect(super.getX()+5, super.getY()-10, super.getImage().getIconWidth()-10, 4);
        g.setColor(Color.green);
        g.fillRect(super.getX()+5, super.getY()-10, CommonUtils.getPercent(super.getHealtPoints(), super.getLifePoints(),super.getImage().getIconWidth()-10), 4);
//        g.setColor(Color.green);
//        g.fillRect(super.getX(), super.getY()-10, super.getImage().getIconWidth(), 4);
        g.drawImage(super.getImage().getImage(), super.getX(), super.getY(),  null);
    }
    
}
