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
    private Target target;
    private int state;
    private String bulletType;
    private int shootCold;
    private int countShoot;
    private int moveCount;
    private String nameImage;
    
    public Unit() {
    }

    public Unit(String name, int lifePoints, int x, int y, int force, String unit, int team, String bullet, int shootCold) {
        super(x, y, "/units/"+unit+""+0+".png");
//        image=;
//        super(x, y, new ImageIcon(getClass().getResource("/images/soldado0.png")));
        
        this.name = name;
        this.lifePoints = lifePoints;
        this.healtPoints = lifePoints-10;
        this.x = x;
        this.y = y;
        this.force = force;
        this.team=team;
        this.image= new ImageIcon(getClass().getResource("/units/"+unit+""+0+".png"));
        this.collisionRec=new Rectangle(x, y, getImage().getIconWidth(), getImage().getIconHeight());
        if(lifePoints>400){
            this.ratio= new Rectangle(x, y, getImage().getIconWidth(), getImage().getIconHeight());
        }else{
            this.ratio= new Rectangle(x, y, getImage().getIconWidth()*6, getImage().getIconHeight()*6);
        }
        this.move=false;
        this.nameImage= unit;
        this.bulletType=bullet;
        this.limit = new Point(0,0);
        this.target= null;
        this.shootCold= shootCold;
        this.countShoot=shootCold;
        this.state=0;// state 0 is Hold // state 1 is Moving //state 2 is Atacking
        this.moveCount=0;
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

    /**
     * @return the state
     */
    public int getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(int state) {
        this.state = state;
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

    /**
     * @return the shootCold
     */
    public int getShootCold() {
        return shootCold;
    }

    /**
     * @param shootCold the shootCold to set
     */
    public void setShootCold(int shootCold) {
        this.shootCold = shootCold;
    }

    /**
     * @return the countShoot
     */
    public int getCountShoot() {
        return countShoot;
    }

    /**
     * @param countShoot the countShoot to set
     */
    public void setCountShoot(int countShoot) {
        this.countShoot = countShoot;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    /**
     * @return the nameImage
     */
    public String getNameImage() {
        return nameImage;
    }

    /**
     * @param nameImage the nameImage to set
     */
    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }
    
    
}
