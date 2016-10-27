/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.controller;


import com.war.GUI.PanelInfo;
import com.war.utils.CommonUtils;

/**
 *
 * @author TMK
 */
public class LevelController {
    
    private float timeCount;
    private String time;
    private int difficult;
    private boolean bossFree;
    
    public LevelController(int difficult){
        this.timeCount=180f;
        time="3:00:00";
        this.difficult=difficult;
        bossFree=false;
    }

    public void goTime(){
        int min, seg;
        this.timeCount-=.1;
        min=(int)timeCount/60;
        seg=(int)timeCount%60;
        time=min+":"+ (seg<10?"0"+(int)seg :(int)seg);
        PanelInfo.unitCharge.setValue(CommonUtils.timeUnit);
    }

    public boolean killHouse(){
        CommonUtils.points+=200;
        return true;
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

    public int getDifficult() {
        return difficult;
    }

    public void setDifficult(int difficult) {
        this.difficult = difficult;
    }

    public boolean isBossFree() {
        return bossFree;
    }

    public void setBossFree(boolean bossFree) {
        this.bossFree = bossFree;
    }
    
    
    
    
}
