/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.model;

import com.war.utils.CommonUtils;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 *
 * @author Cesar
 */
public class MessageLabel {
    
    private int x;
    private int y;
    private String message;
    private int counter;
    private Color color;
    private boolean finish;
    
    public MessageLabel(int x, String message, Color color){
        this.x=x;
        this.y=-20;
        this.message=message;
        this.counter=0;
        this.color= color;
        finish=false;
    }

    public void paint(Graphics2D g2d){
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 20);
        g2d.setFont(font);
        g2d.setColor(getColor());
        g2d.drawString(message, x, y);
        if(counter<100){
            y+=3;
        }else if(counter > 180){
            y+=4;
        }
        if(y > CommonUtils.height){
            setFinish(true);
        }
        counter++;
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
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
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
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return the finish
     */
    public boolean isFinish() {
        return finish;
    }

    /**
     * @param finish the finish to set
     */
    public void setFinish(boolean finish) {
        this.finish = finish;
    }
    
    
}
