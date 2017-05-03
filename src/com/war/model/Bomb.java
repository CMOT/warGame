/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.model;

import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/**
 *
 * @author Cesar
 */
public class Bomb extends Item{
    
    private ImageIcon bombAction;
    private int moveY;
    
    
    public Bomb(int power, int x, int y, String item, int team, String bombAction, int moveY,int duration) {
        super(power, x-15, y, item, duration, team);
        this.bombAction = new ImageIcon(getClass().getResource(bombAction));
        this.moveY= moveY;
    }
    
    public void paint(Graphics2D g2d){
        g2d.drawImage(getImage().getImage(), getX(), getY(), 30, 30, null);
        if(this.getY() < moveY-10){
            down();
        }else{
            super.setActive(true);
        }
    }
    
    public void down(){
        this.setY(this.getY()+1);
    }
    
    public boolean isDamaging(){
        if(getCounter()==100 || getCounter()==200 || getCounter()==300 || getCounter()==400){
            return true;
        }
        return false;
    }
    
    /**
     * @return the bombAction
     */
    public ImageIcon getBombAction() {
        return bombAction;
    }

    /**
     * @param bombAction the bombAction to set
     */
    public void setBombAction(ImageIcon bombAction) {
        this.bombAction = bombAction;
    }

    /**
     * @return the moveY
     */
    public int getMoveY() {
        return moveY;
    }

    /**
     * @param moveY the moveY to set
     */
    public void setMoveY(int moveY) {
        this.moveY = moveY;
    }
    
}
