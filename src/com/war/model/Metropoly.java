/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.model;

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
        g.drawImage(super.getImage().getImage(), super.getX(), super.getY(),  null);
    }
    
}
