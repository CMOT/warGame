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
 * @author Cesar
 */
public class Tower extends Build{
    
    private int power;
    private int counter;
    private int shootColdown;
    private String bulletType;

    public Tower(int power, int shootColdown, String name, int lifePoints, int capacity, int x, int y, String build, int team, String bulletType) {
        super(name, lifePoints, capacity, x, y, build, team);
        this.power = power;
        this.counter = 0;
        this.shootColdown = shootColdown;
        this.bulletType=  bulletType;
    }
    
    @Override
    public void paint(Graphics2D g2d){
        g2d.setColor(Color.red);
        g2d.fillRect(super.getX()+5, super.getY()-10, super.getImage().getIconWidth()-10, 4);
        g2d.setColor(Color.green);
        g2d.fillRect(super.getX()+5, super.getY()-10, CommonUtils.getPercent(super.getHealtPoints(), super.getLifePoints(),super.getImage().getIconWidth()-10), 4);
        g2d.drawImage(super.getImage().getImage(), getX(),getY(), null);
        
    }

    public boolean shoot(){
        if(counter==shootColdown){
            counter=0;
            return true;
        }
        counter++;
        return false;
    }
    
    /**
     * @return the power
     */
    public int getPower() {
        return power;
    }

    /**
     * @param power the power to set
     */
    public void setPower(int power) {
        this.power = power;
    }

    /**
     * @return the counter
     */
    public int getCounter() {
        return counter;
    }

    /**
     * @param counter the counter to set
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }

    /**
     * @return the shootColdown
     */
    public int getShootColdown() {
        return shootColdown;
    }

    /**
     * @param shootColdown the shootColdown to set
     */
    public void setShootColdown(int shootColdown) {
        this.shootColdown = shootColdown;
    }

    /**
     * @return the bulletType
     */
    public String getBulletType() {
        return bulletType;
    }

    /**
     * @param bulletType the bulletType to set
     */
    public void setBulletType(String bulletType) {
        this.bulletType = bulletType;
    }
    
}
