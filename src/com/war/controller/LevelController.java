/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.controller;


import com.war.GUI.Level;
import com.war.GUI.LevelThree;
import com.war.GUI.LevelTwo;
import com.war.GUI.Menu;
import static com.war.GUI.Menu.actualLevel;
import com.war.GUI.PanelInfo;
import com.war.model.MessageLabel;
import com.war.utils.CommonUtils;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

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
    
    public MessageLabel isNewMessage(){
            String message=CommonUtils.message;
            CommonUtils.message="";
            return new MessageLabel(200, message, 1);
    }

    public void levelUp(Level level){
        Level newLevel= null;
        Menu.panelCanvas.remove(level);
        PanelInfo info= null;
        for(MouseListener listener: level.getMouseListeners()){
            MouseController controller=(MouseController) listener;
            info=controller.getInfo();
            level.removeMouseListener(listener);
        }
        switch(Menu.levelNumber){
            case 1:
                newLevel = new LevelTwo(level.getWidth(), level.getHeight(), CommonUtils.difficult);
                break;
            case 2:
                newLevel = new LevelThree(level.getWidth(), level.getHeight(), CommonUtils.difficult);
                break;
            case 3:
                
                break;
        }
        if(newLevel!=null){
            Menu.levelNumber++;
            Menu.actualLevel= newLevel;
            actualLevel.addMouseListener(new MouseController(newLevel, info ));
            Menu.panelCanvas.add(actualLevel);
            CommonUtils.resetValues();
        }
    }
    
    public void changeCursor(Level level, String cursor){
        try{
            switch(cursor){
                case "sword":
                    level.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(getClass().getResource("/images/espada.png")).getImage(),new Point(10,10),"custom cursor"));
                    break;
                case "item":
                    level.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(getClass().getResource("/images/bomb.png")).getImage(),new Point(10,10),"custom cursor"));
                    break;
                default :
                    level.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    
            }
        }catch(IndexOutOfBoundsException | HeadlessException e){
            System.out.println("Exception in changeCursor: {0}"+ e.getMessage());
        }
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
