/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.model;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

/**
 *
 * @author ASUS
 */
public class Unit extends Target{
    
    private String name;
    private int lifePoints;
    private int healtPoints;
    private int x;
    private int y;
    private float force;
    private int team;
    private ImageIcon image;
    private Rectangle collisionRec;
    private Rectangle ratio;
    private boolean move;
    private Point limit;
    private int moveX;
    private int moveY;
    private Bullet bullet;

    public Unit() {
    }

    public Unit(String name, int lifePoints, int x, int y, int force, String unit, int team) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.healtPoints = lifePoints;
        this.x = x;
        this.y = y;
        this.force = force;
        this.team=team;
        this.image= new ImageIcon("images/"+unit+".png");
        this.collisionRec=new Rectangle(x, y, getImage().getIconWidth(), getImage().getIconHeight());
        this.ratio= new Rectangle(getImage().getIconWidth()*3, getImage().getIconHeight()*3);
        this.move=false;
        bullet= new Bullet(force, -10, -10, "bala", team);
        limit = new Point(0,0);
    }
    
    public void paint(Graphics2D g){}

    
    
    /*********************************************
    ************GETTERS AND SETTERS***************
    *********************************************/
    
    
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
        this.collisionRec.x=x;
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
        this.collisionRec.y=y;
    }

    /**
     * @return the force
     */
    public float getForce() {
        return force;
    }

    /**
     * @param force the force to set
     */
    public void setForce(float force) {
        this.force = force;
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
     * @return the ratio
     */
    public Rectangle getRatio() {
        return ratio;
    }

    /**
     * @param ratio the ratio to set
     */
    public void setRatio(Rectangle ratio) {
        this.ratio = ratio;
    }

    /**
     * @return the move
     */
    public boolean isMove() {
        return move;
    }

    /**
     * @param move the move to set
     */
    public void setMove(boolean move) {
        this.move = move;
    }

    /**
     * @return the limit
     */
    public Point getLimit() {
        return limit;
    }

    /**
     * @param limit the limit to set
     */
    public void setLimit(Point limit) {
        this.limit = limit;
    }

    /**
     * @return the moveX
     */
    public int getMoveX() {
        return moveX;
    }

    /**
     * @param moveX the moveX to set
     */
    public void setMoveX(int moveX) {
        this.moveX = moveX;
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
     * @return the bullet
     */
    public Bullet getBullet() {
        return bullet;
    }

    /**
     * @param bullet the bullet to set
     */
    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }
    
    
    
}
