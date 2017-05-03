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
    
    public Item getBombItem(int x, int moveY, int duration ,int team){
        return new Bomb(10, x, -40, "bombItem", team, "bombActive", moveY, duration);
    }
}
