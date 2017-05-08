/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.model;

import java.awt.Graphics2D;

/**
 *
 * @author Cesar
 */
public class Health extends Item{
    
    public Health(int power, int x, int y, String item, int duration, int team) {
        super(power, x, y, item, duration, team);
        super.setActive(true);
    }
    
    public void paint(Graphics2D g2d){
        g2d.drawImage(super.getImage().getImage(), super.getX(), super.getY(), null);
    }
    
    public boolean isCuring(){
        if(getCounter()%30==0){
            return true;
        }
        return false;
    }
    
}
