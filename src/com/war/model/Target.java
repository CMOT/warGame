/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.model;

import javax.swing.ImageIcon;

/**
 *
 * @author TMK
 */
public class Target {
    
    private int x;
    private int y;
    private ImageIcon image;
    
    public Target(){
        
    }

    public Target(int x, int y, String image) {
        this.x = x;
        this.y = y;
        this.image= new ImageIcon(getClass().getResource(image));
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

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    
    
    
    
    
}
