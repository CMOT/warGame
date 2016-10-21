/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.model;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author ASUS
 */
public class Marine extends Unit{
    
    
    public Marine() {
        super();
    }
    
    public Marine(String name, int lifePoints, int x, int y, int force, String unit, int team){
        super(name, lifePoints, x, y, force, unit, team);
    }
    
    @Override
    public void paint(Graphics2D g){
        switch(super.getTeam()){
            case 1:
                g.setColor(Color.blue);
                break;
            case 2:
                g.setColor(Color.red);
                break;
        }
        g.drawRect(super.getX()-super.getImage().getIconWidth(), super.getY()-super.getImage().getIconHeight(), super.getRatio().width, super.getRatio().height);
        g.drawImage(super.getImage().getImage(), super.getX(), super.getY(), null);
        super.getBullet().paint(g);
    }
    
}
