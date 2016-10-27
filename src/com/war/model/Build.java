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
 * @author ASUS
 */
public class Build extends Target{
    
    private String name;
    private int lifePoints;
    private int healtPoints;
    private int x;
    private int y;
    private int team;
    private Rectangle collisionRec;
    private ImageIcon image;
     private int capacity;
    
    public Build(){
    }

    public Build(String name, int lifePoints, int capacity, int x, int y, String build,int team) {
        super(x, y, new ImageIcon("images/builds/"+build+""+0+".png"));
        this.name = name;
        this.lifePoints = lifePoints;
        this.healtPoints= lifePoints;
        this.x = x;
        this.y = y;
        this.team= team;
        this.image= new ImageIcon("images/builds/"+build+""+0+".png");
        this.collisionRec=new Rectangle(this.x, this.y, getImage().getIconWidth(), getImage().getIconHeight());
        this.capacity= capacity;
    }
    
    public void paint(Graphics2D g){
        
        
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the lifePoints
     */
    public int getLifePoints() {
        return lifePoints;
    }

    /**
     * @param lifePoints the lifePoints to set
     */
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    /**
     * @return the healtPoints
     */
    public int getHealtPoints() {
        return healtPoints;
    }

    /**
     * @param healtPoints the healtPoints to set
     */
    public void setHealtPoints(int healtPoints) {
        this.healtPoints = healtPoints;
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
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    
    
}
