/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.controller;

/**
 *
 * @author TMK
 */
public class LevelController {
    
    private float timeCount;
    private String time;
    
    public LevelController(){
        this.timeCount=180f;
        time="3:00:00";
    }

    public void goTime(){
        int min, seg;
        this.timeCount-=.1;
        min=(int)timeCount/60;
        seg=(int)timeCount%60;
        time=min+":"+ (seg<10?"0"+(int)seg :(int)seg);
    }

    public float getTimeCount() {
        return timeCount;
    }

    public void setTimeCount(float timeCount) {
        this.timeCount = timeCount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    
    
    
}
