/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.GUI;

import com.war.controller.BuildController;
import com.war.controller.BulletController;
import com.war.controller.ItemController;
import com.war.controller.LevelController;
import com.war.controller.UnitController;
import com.war.model.MessageLabel;
import com.war.model.Target;
import com.war.model.Unit;
import java.awt.Canvas;
import javax.swing.ImageIcon;

/**
 *
 * @author Cesar
 */
public class Level extends Canvas{
    private Unit selected;
    private ImageIcon background;
    private Target eliminated;
    private boolean runThread;
    private UnitController unitController;
    private BuildController buildController;
    private BulletController bulletController;
    private LevelController levelController;
    private volatile ItemController itemController;
    private MessageLabel messageLabel;
    private Thread hilo;
    private boolean winLevel;
    
    public Level(int width, int height, int difficult){
        this.setBounds(0, 0, width , height);
        winLevel=false;
        
    }

    /**
     * @return the selected
     */
    public Unit getSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(Unit selected) {
        this.selected = selected;
    }


    /**
     * @return the eliminated
     */
    public Target getEliminated() {
        return eliminated;
    }

    /**
     * @param eliminated the eliminated to set
     */
    public void setEliminated(Target eliminated) {
        this.eliminated = eliminated;
    }

    /**
     * @return the runThread
     */
    public boolean isRunThread() {
        return runThread;
    }

    /**
     * @param runThread the runThread to set
     */
    public void setRunThread(boolean runThread) {
        this.runThread = runThread;
    }

    /**
     * @return the unitController
     */
    public UnitController getUnitController() {
        return unitController;
    }

    /**
     * @param unitController the unitController to set
     */
    public void setUnitController(UnitController unitController) {
        this.unitController = unitController;
    }

    /**
     * @return the buildController
     */
    public BuildController getBuildController() {
        return buildController;
    }

    /**
     * @param buildController the buildController to set
     */
    public void setBuildController(BuildController buildController) {
        this.buildController = buildController;
    }

    /**
     * @return the bulletController
     */
    public BulletController getBulletController() {
        return bulletController;
    }

    /**
     * @param bulletController the bulletController to set
     */
    public void setBulletController(BulletController bulletController) {
        this.bulletController = bulletController;
    }

    /**
     * @return the levelController
     */
    public LevelController getLevelController() {
        return levelController;
    }

    /**
     * @param levelController the levelController to set
     */
    public void setLevelController(LevelController levelController) {
        this.levelController = levelController;
    }

    /**
     * @return the hilo
     */
    public Thread getHilo() {
        return hilo;
    }

    /**
     * @param hilo the hilo to set
     */
    public void setHilo(Thread hilo) {
        this.hilo = hilo;
    }

    /**
     * @return the itemController
     */
    public ItemController getItemController() {
        return itemController;
    }

    /**
     * @param itemController the itemController to set
     */
    public void setItemController(ItemController itemController) {
        this.itemController = itemController;
    }

    /**
     * @return the messageLabel
     */
    public MessageLabel getMessageLabel() {
        return messageLabel;
    }

    /**
     * @param messageLabel the messageLabel to set
     */
    public void setMessageLabel(MessageLabel messageLabel) {
        this.messageLabel = messageLabel;
    }

    /**
     * @return the winLevel
     */
    public boolean isWinLevel() {
        return winLevel;
    }

    /**
     * @param winLevel the winLevel to set
     */
    public void setWinLevel(boolean winLevel) {
        this.winLevel = winLevel;
    }
    
}
