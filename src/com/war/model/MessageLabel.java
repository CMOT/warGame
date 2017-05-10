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
    private int color;
    private boolean finish;
    
    public MessageLabel(int x, String message, int color){
        this.x=x;
        this.y=-20;
        this.message=message;
        this.counter=0;
        this.color= color;
        finish=false;
    }

    public void paint(Graphics2D g2d){
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 24);
        g2d.setFont(font);
        g2d.setColor(getSelectedColor(color));
        g2d.drawString(message, x, y);
        if(counter<60){
            y+=6;
        }else if(counter > 120){
            y+=7;
        }
        if(y > CommonUtils.height){
            setFinish(true);
        }
        counter++;
    }
    
    public Color getSelectedColor(int numColor){
        Color color= new Color(0, 0, 0);
        switch(numColor){
            case 1:
                color =new Color(1f,0f,0f,.5f );
                break;
            case 2:
                color =new Color(0f,1f,0f,.5f );
                break;
            case 3:
                color =new Color(0f,0f,1f,.5f );
                break;
            case 4:
                color =new Color(.3f,.4f,.2f,.6f );
                break;
        }
        return color;
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

    /**
     * @return the color
     */
    public int getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(int color) {
        this.color = color;
    }
    
    
}
