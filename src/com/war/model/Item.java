/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.model;

import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Cesar
 */
public class Item {
    private int power;
    private int x;
    private int y;
    private ImageIcon image;
    private Rectangle collisionRec;
    private int team;
    private int counter;
    private int duration;
    private boolean active;

    public Item(int power, int x, int y, String item, int duration,int team) {
        this.power = power;
        this.x = x;
        this.y = y;
        this.image = new ImageIcon(getClass().getResource("/images/"+item+".gif"));
        this.collisionRec = new Rectangle(x, y, getImage().getIconWidth(), getImage().getIconHeight());
        this.team = team;
        this.counter=0;
        this.duration=duration;
        this.active=false;
    }

    
    public void upCounter(){
        this.counter++;
    }
    
    public boolean finish(){
        return counter>=getDuration();
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
     * @return the duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }

}
