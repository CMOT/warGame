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
public class Main {
    public static void main(String[] args) {
        final Weapon weapon = new Weapon(30);
        final Shooter shooter = new Shooter();
        shooter.operate(weapon);
    }
}
