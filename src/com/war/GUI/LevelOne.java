/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.GUI;

import com.war.controller.BuildController;
import com.war.controller.BulletController;
import com.war.controller.LevelController;
import com.war.controller.UnitController;
import com.war.model.Build;
import com.war.model.Bullet;
import com.war.model.Marine;
import com.war.model.Metropoly;
import com.war.model.Target;
import com.war.model.Unit;
import com.war.utils.CommonUtils;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class LevelOne extends Canvas implements Runnable{
    Unit selected;
    ImageIcon background;
    Target eliminated;
    boolean runThread;
    private UnitController unitController;
    private BuildController buildController;
    private BulletController bulletController;
    private LevelController levelController;
    Thread hilo;
    
    public LevelOne(int width, int height, int difficult){
        this.setBounds(0, 0, width , height);
        CommonUtils.difficutl=difficult;
        background = new ImageIcon(getClass().getResource("/images/cementerio.png"));
        unitController= new UnitController();
        buildController = new BuildController();
        bulletController= new BulletController();
        unitController.fillListEnemies(difficult, width-200, height-400);
        unitController.fillListAllies(100, 100, difficult);
        buildController.fillBuildEnemies(this.getWidth()-140,200, 2, difficult);
        buildController.fillBuildAllies(30, 200, 1);
        levelController= new LevelController(difficult);
        eliminated= null;
        runThread=true;
        hilo= new Thread(this);
        hilo.start();
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d=(Graphics2D) g;
        g2d.drawImage(background.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        for(Build buildA:getBuildController().getListBuildAllies() ){
            if(buildA instanceof Metropoly){
                Metropoly metro= (Metropoly) buildA;
                metro.paint(g2d);
            }
        }
        for(Build build:getBuildController().getListBuilds() ){
            if(build instanceof Metropoly){
                Metropoly metro= (Metropoly) build;
                metro.paint(g2d);
            }
        }
        if(unitController.getBossUnit()!=null){
            unitController.getBossUnit().paint(g2d);
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
        for(Bullet bullet: bulletController.getListBullets()){
                 bullet.paint(g2d);
        }
        for(Bullet bullet2: bulletController.getListBulletsEnemies()){
                 bullet2.paint(g2d);
        }
        Font font= new Font("Arial", Font.ITALIC, 18);
        g2d.setColor(Color.green);
        g2d.setFont(font);
        g2d.drawString("Points: "+CommonUtils.points, 10, 30);
//        g2d.drawString("Time: "+levelController.getTime(), CommonUtils.width-150, 30);
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
        while(runThread){
            try {
                hilo.sleep(40);
            } catch (InterruptedException ex) {}
            for(Unit unit:unitController.getListAllies()){
                if(unit.getCountShoot()!=unit.getShootCold() ){
                    if( unit.getCountShoot()<=unit.getShootCold()+16){
                        unit.setCountShoot(unit.getCountShoot()+1);
                    }else{
                        unit.setCountShoot(unit.getShootCold());
                    }
                }
                if(unit.isMove()){
                    unit.setMove(getUnitController().moveUnit( unit));
                }else{
                    unit.setImage(unitController.getImageState(unit.getNameImage(), 0));
                }
                if(unit.getTarget()!= null ) {
                    Bullet bull=getUnitController().unitShooter(unit);
                    if(bull!=null){
                        bulletController.getListBullets().add(bull);
                    }
                }
            }
            for(Unit unit: unitController.getListEnemies()){
                if(unit.getState()!=2){
                    unitController.randomMove(unit, levelController.getDifficult());
                }
                unitController.autoAtack(unit);
                if(unit.getTarget()!=null){
                    unitController.atackUnit(unit);
                }
            }
            if((eliminated=bulletController.shootEnemies(unitController.getListEnemies()))!=null ){
               eliminated= unitController.deleteTargets(eliminated, 1);
            }
            if((eliminated=bulletController.shootBuilds(buildController.getListBuilds()))!=null){
                 eliminated= unitController.deleteTargets(eliminated, 1);
            }
            
            if((eliminated=bulletController.shootAllies(unitController.getListAllies()))!=null ){
               eliminated= unitController.deleteTargets(eliminated, 2);
            }
//            if((eliminated=bulletController.shootBuildsAllies(buildController.getListBuildAllies()))!=null){
//                 eliminated= unitController.deleteTargets(eliminated);
//            }
//            for(Build metro: buildController.getListBuilds()){
//                boolean crear=buildController.equalsGame(metro.getHealtPoints());
//                if(crear){
//                    unitController.createEnemies(metro.getLifePoints()/metro.getHealtPoints()+levelController.getDifficult());
//                }
//            }

                
            levelController.goTime();
            if(buildController.createUnit()){
                unitController.createUnit();
            }
            if(buildController.getListBuilds().isEmpty() && !levelController.isBossFree()){
                levelController.setBossFree(true);
                unitController.freeTheBoss();
            }
            if(unitController.getBossUnit()!= null){
                bulletController.shootBoss(unitController.getBossUnit());
                unitController.moveBoss();
                Bullet bull=unitController.bossShoot(levelController.getDifficult());
                if(bull!=null){
                    bulletController.getListBulletsEnemies().add(bull);
                }
                boolean crear=buildController.equalsGame(unitController.getBossUnit().getHealtPoints());
                if(crear){
                    unitController.createEnemies(unitController.getBossUnit().getLifePoints()/unitController.getBossUnit().getHealtPoints(), unitController.getBossUnit().getCollisionRec().getLocation());
                }
                if(unitController.getBossUnit().getHealtPoints()<0){
                    unitController.setBossUnit(null);
                }
            }
            if(unitController.getBossUnit()==null && levelController.isBossFree()){
                JOptionPane.showMessageDialog(null, "You Win");
                runThread=false;
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

    public BulletController getBulletController() {
        return bulletController;
    }

    public void setBulletController(BulletController bulletController) {
        this.bulletController = bulletController;
    }

//    public LevelController getLevelController() {
//        return levelController;
//    }
//
//    public void setLevelController(LevelController levelController) {
//        this.levelController = levelController;
//    }
//    
    
    
}
