/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.GUI;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author Cesar
 */
public class Shooter {
     public void operate(Weapon weapon) {
        final String className = weapon.getClass().getName();
        try {
            final Method[] methods = Class.forName(className).getMethods();
            for (final Method method : methods) {
                invokeMethod(method, weapon);
            }
        } catch (final Exception e) {
            System.err.println("Hubo un error:" + e.getMessage());
        }
    }
 
    private void invokeMethod(Method method, Weapon weapon)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
 
        final MultipleShoot multipleShoot = method.getAnnotation(MultipleShoot.class);
 
        if (multipleShoot != null) {
            final int timesToInvoke = multipleShoot.timesToInvoke();
 
            for (int i = 0; i < timesToInvoke; i++) {
                method.invoke(weapon, (Object[])null);
            }
        }
 
    }
}
