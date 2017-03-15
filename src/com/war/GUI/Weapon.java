/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.GUI;

/**
 *
 * @author Cesar
 */
 
public class Weapon {
 
    private static final int BURST_FIRE_ROUNDS = 3;
 
    private static final int AUTO_FIRE_ROUNDS = 5;
 
    private int ammo;
 
    public Weapon(int ammo) {
        this.ammo = ammo;
    }
 
    @MultipleShoot
    public void singleFire() {
        ammo--;
        System.out.println("Single fire! Ammo left: " + ammo);
    }
 
    @MultipleShoot(timesToInvoke = BURST_FIRE_ROUNDS)
    public void burstFire() {
        ammo--;
        System.out.println("Burst fire! Ammo left: " + ammo);
    }
 
    @MultipleShoot(timesToInvoke = AUTO_FIRE_ROUNDS)
    public void autoFire() {
        ammo--;
        System.out.println("Auto fire! Ammo left: " + ammo);
    }
}
