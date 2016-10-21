/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.GUI;

import com.war.controller.BuildController;
import com.war.controller.UnitController;
import com.war.model.Build;
import com.war.model.Marine;
import com.war.model.Metropoly;
import com.war.model.Unit;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author ASUS
 */
public class LevelOne extends Canvas implements Runnable{
    Unit selected;
    ImageIcon background;
    private UnitController unitController;
    private BuildController buildController;
    Thread hilo;
    
    public LevelOne(int width, int height, int difficult){
        this.setBounds(0, 0, width , height);
        background = new ImageIcon("images/cementerio.png");
        unitController= new UnitController();
        buildController = new BuildController();
        unitController.fillListEnemies(difficult, width-200, height-400);
        unitController.fillListAllies(100, 300);
        buildController.fillBuildEnemies(this.getWidth()-140,250, 2);
        hilo= new Thread(this);
        hilo.start();
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d=(Graphics2D) g;
        g2d.drawImage(background.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
//        g2d.drawImage(new ImageIcon("images/center1.png").getImage(), this.getWidth()-140, 270,  this);
        for(Build build:getBuildController().getListBuilds() ){
            if(build instanceof Metropoly){
                Metropoly metro= (Metropoly) build;
                metro.paint(g2d);
            }
        }
        for(Unit allie: getUnitController().getListAllies()){
            if(allie instanceof Marine){
                Marine marine= (Marine) allie;
                marine.paint(g2d);
            }
        }
        for(Unit enemy: getUnitController().getListEnemies()){
            if(enemy instanceof Marine){
                 Marine marine= (Marine) enemy;
                 marine.paint(g2d);
            }
        }
    }
    
    @Override
    public void update(Graphics g) {
        Graphics offgc;
        Image offscreen = null;
        Dimension d = size();
        // create the offscreen buffer and associated Graphics
        offscreen = createImage(d.width, d.height);
        offgc = offscreen.getGraphics();
        // clear the exposed area
        offgc.setColor(getBackground());
        offgc.fillRect(0, 0, d.width, d.height);
        offgc.setColor(getForeground());
        // do normal redraw
        paint(offgc);
        // transfer offscreen to window
        g.drawImage(offscreen, 0, 0, this);
    }

    @Override
    public void run() {
        while(true){
            try {
                hilo.sleep(50);
            } catch (InterruptedException ex) {
            }
            for(Unit unit:unitController.getListAllies()){
                if(unit.isMove()){
                    unit.setMove(getUnitController().moveUnit( unit));
                   
                }
                if(unit.getBullet().getTarget()!= null && unit.getBullet().getTarget() instanceof Build) {
                    Build b= (Build) unit.getBullet().getTarget();
//                    if(unit.getBullet().isShooted() && (b.getX()==unit.getX()  )   ){
                    if(unit.getBullet().isShooted()){
                        unit.getBullet().setShooted(getUnitController().unitShooter(unit.getBullet()));
                    }
                }
                
            }
            repaint();
        }
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
    
}
