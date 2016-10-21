/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.model;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author TMK
 */
public class Bullet {
    
    private int power;
    private int x;
    private int y;
    private ImageIcon image;
    private Rectangle collisionRec;
    private int team;
    private boolean shooted;
    private Target target;
    
    public Bullet(){
        
    }

    public Bullet(int power, int x, int y, String bullet, int team) {
        this.power = power;
        this.x = x;
        this.y = y;
        this.image = new ImageIcon("images/"+bullet+".png");
        this.collisionRec = new Rectangle(x, y, getImage().getIconWidth(), getImage().getIconHeight());
        this.team= team;
        this.shooted=false;
        this.target= new Target();
    }
    public void paint(Graphics2D g){
        if(isShooted()){
            g.drawImage(getImage().getImage(), this.getX(), this.getY(), null);
        }
//        else{
//            x=-10;
//            y=-10;
//        }
        
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
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the image
     */
    public ImageIcon getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(ImageIcon image) {
        this.image = image;
    }

    /**
     * @return the collisionRec
     */
    public Rectangle getCollisionRec() {
        return collisionRec;
    }

    /**
     * @param collisionRec the collisionRec to set
     */
    public void setCollisionRec(Rectangle collisionRec) {
        this.collisionRec = collisionRec;
    }

    /**
     * @return the team
     */
    public int getTeam() {
        return team;
    }

    /**
     * @param team the team to set
     */
    public void setTeam(int team) {
        this.team = team;
    }

    /**
     * @return the shooted
     */
    public boolean isShooted() {
        return shooted;
    }

    /**
     * @param shooted the shooted to set
     */
    public void setShooted(boolean shooted) {
        this.shooted = shooted;
    }

    /**
     * @return the target
     */
    public Target getTarget() {
        return target;
    }

    /**
     * @param target the target to set
     */
    public void setTarget(Target target) {
        this.target = target;
    }
    
    
   
}
