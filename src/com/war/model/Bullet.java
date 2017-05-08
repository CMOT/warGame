/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.model;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author TMK
 */
public class Bullet {
    
    private int power;
    private int x;
    private int y;
    private int moveX;
    private int moveY;
    private ImageIcon image;
    private Rectangle collisionRec;
    private int team;
    private boolean shooted;
    private double time;
    private double angule;
    private boolean up;
    
    public Bullet(){
    }

    public Bullet(int power, int x, int y, String bullet, int team, int targetX, int targetY) {
        this.power = power;
        this.x = x;
        this.y = y;
        this.image = new ImageIcon(getClass().getResource("/images/"+bullet+".gif"));
        this.collisionRec = new Rectangle(x, y, getImage().getIconWidth(), getImage().getIconHeight());
        this.team= team;
        this.shooted=false;
        this.moveX=(int)((Math.random()*5)+2);
        this.moveY=(int)((Math.random()*5)+2);
        this.time=0.0;
        this.angule= Math.random();
        
    }
    public void paint(Graphics2D g){
//        if(isShooted()){
//            g.draw(collisionRec);
            g.drawImage(getImage().getImage(), this.getX(), this.getY(), null);
            shoot();
//            if(getTeam()==2){
//                g.setColor(Color.red);
    //            g.draw(super.getRatio());
//                g.draw(getCollisionRec());
//            }
//            this.x = this.x+ CommonUtils.calcX(Math.abs(this.getMoveY()-(this.getY() ))+30,this.getMoveX()-this.getX(), this.time );
//            this.y = this.y+ CommonUtils.calcY(Math.abs(this.getMoveY()-(this.getY() ))+30,this.getMoveX()-this.getX(), this.time );
//            this.collisionRec.x =this.x+ CommonUtils.calcX(Math.abs(this.getMoveY()-(this.getY() ))+30,this.getMoveX()-this.getX(), this.time );
//            this.collisionRec.y =this.y+ CommonUtils.calcY(Math.abs(this.getMoveY()-(this.getY() ))+30,this.getMoveX()-this.getX(), this.time );
//            this.time+=.1;
    }

    public void shoot(){
        if(this.team==1){
            this.x+=4;
            this.collisionRec.x+=4;
        }else{
            this.x-=6;
            this.collisionRec.x-=6;
            if(angule>=.5){
                this.y+=this.angule*5;
                this.collisionRec.y+=this.angule*5;
            }else{
                this.y-=this.angule*5;
                this.collisionRec.y-=this.angule*5;
            }
        }
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

    public int getMoveX() {
        return moveX;
    }

    public void setMoveX(int moveX) {
        this.moveX = moveX;
    }

    public int getMoveY() {
        return moveY;
    }

    public void setMoveY(int moveY) {
        this.moveY = moveY;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
   
}
