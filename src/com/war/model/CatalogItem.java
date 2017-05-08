/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.model;

/**
 *
 * @author Cesar
 */
public class CatalogItem {
    
    public Item getSmallBombItem(int x, int moveY, int duration ,int team){
        return new Bomb(10, x, -40, "bomb", team, "fire", moveY, duration);
    }
    
    public Item getBigBombItem(int x, int moveY, int duration ,int team){
        return new Bomb(12, x, -40, "bigBomb", team, "fireBomb", moveY, duration);
    }
    
    public Item getHealthItem(int x, int y, int duration, int team){
        return new Health(20, x, y, "papel", duration, team);
    }
}
