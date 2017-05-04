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
import com.war.model.Bomb;
import com.war.model.Build;
import com.war.model.Bullet;
import com.war.model.Item;
import com.war.model.Marine;
import com.war.model.Metropoly;
import com.war.model.Target;
import com.war.model.Unit;
import com.war.utils.CommonUtils;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class LevelOne extends Level implements Runnable{
    Unit selected;
    ImageIcon background;
    Target eliminated;
    boolean runThread;
    Thread hilo;
    
    public LevelOne(int width, int height, int difficult){
        super(width, height, difficult);
        this.setBounds(0, 0, width , height);
        CommonUtils.difficult=difficult;
        background = new ImageIcon(getClass().getResource("/images/cementerio.png"));
        super.setUnitController(new UnitController());
        super.setBuildController( new BuildController());
        super.setBulletController( new BulletController());
        super.setItemController( new ItemController());
        super.getUnitController().fillListEnemies(difficult, width-200, height-400, "clown");
        super.getUnitController().fillListAllies(100, 100, difficult);
        super.getBuildController().fillBuildEnemies(this.getWidth()-140,200, 2, difficult);
        super.getBuildController().fillBuildAllies(30, 200, 1);
        super.setLevelController( new LevelController(difficult));
        eliminated= null;
        runThread=true;
        hilo= new Thread(this);
        hilo.start();
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d=(Graphics2D) g;
//        g2d.drawImage(background.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
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
        if(super.getUnitController().getBossUnit()!=null){
            super.getUnitController().getBossUnit().paint(g2d);
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
        for(Bullet bullet: super.getBulletController().getListBullets()){
                 bullet.paint(g2d);
        }
        for(Bullet bullet2: super.getBulletController().getListBulletsEnemies()){
                 bullet2.paint(g2d);
        }
        for (Item item : super.getItemController().getItemList()) {
            if(item instanceof Bomb){
                Bomb bomb = (Bomb) item;
                bomb.paint(g2d);
            }
        }
        Font font= new Font("Arial", Font.ITALIC, 18);
        g2d.setColor(Color.green);
        g2d.setFont(font);
        g2d.drawString("Level: "+Menu.levelNumber, 10, 30);
        g2d.drawString("Points: "+CommonUtils.points, 10, 60);
        if(super.getMessageLabel()!=null){
            super.getMessageLabel().paint(g2d);
            if(super.getMessageLabel().isFinish()){
                super.setMessageLabel(null);
            }
        }
//        g2d.drawString("Time: "+super.getLevelController().getTime(), CommonUtils.width-150, 30);
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
            if(CommonUtils.itemselect){
                getLevelController().changeCursor(this,"item");
            }else{
                getLevelController().changeCursor(this,"");
            }
            for(Unit unit:super.getUnitController().getListAllies()){
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
                    unit.setImage(super.getUnitController().getImageState(unit.getNameImage(), 0));
                }
                if(unit.getTarget()!= null ) {
                    Bullet bull=getUnitController().unitShooter(unit);
                    if(bull!=null){
                        super.getBulletController().getListBullets().add(bull);
                    }
                }
            }
            for(Unit unit: super.getUnitController().getListEnemies()){
                if(unit.getState()!=2){
                    super.getUnitController().randomMove(unit, super.getLevelController().getDifficult());
                }
                super.getUnitController().autoAtack(unit);
                if(unit.getTarget()!=null){
                    super.getUnitController().atackUnit(unit);
                }
            }
            if((eliminated=super.getBulletController().shootEnemies(super.getUnitController().getListEnemies()))!=null ){
               eliminated= super.getUnitController().deleteTargets(eliminated, 1);
            }
            if((eliminated=super.getBulletController().shootBuilds(super.getBuildController().getListBuilds()))!=null){
                 eliminated= super.getUnitController().deleteTargets(eliminated, 1);
            }
            
            if((eliminated=super.getBulletController().shootAllies(super.getUnitController().getListAllies()))!=null ){
               eliminated= super.getUnitController().deleteTargets(eliminated, 2);
            }
//            if((eliminated=super.getBulletController().shootBuildsAllies(super.getBuildController().getListBuildAllies()))!=null){
//                 eliminated= super.getUnitController().deleteTargets(eliminated);
//            }
            for(Build metro: super.getBuildController().getListBuilds()){
                boolean crear=super.getBuildController().equalsGame(metro.getHealtPoints());
                if(crear){
                    super.getUnitController().createEnemies(metro.getLifePoints()/metro.getHealtPoints()+super.getLevelController().getDifficult(), new Point(super.getBuildController().getListBuilds().get(0).getX(),super.getBuildController().getListBuilds().get(0).getY()), "clown");
                }
            }
             
            for(Item item: super.getItemController().getItemList()){
                if(item instanceof Bomb){
                    if(item.isActive()){
                        Bomb bomb = (Bomb) item;
                        if(super.getUnitController().boomBomb(bomb)==1){
                            super.getItemController().getItemList().remove(item);
                            break;
                        }
                    }
                }
            }
            
            super.getLevelController().goTime();
            if(!CommonUtils.message.isEmpty()){
                super.setMessageLabel( super.getLevelController().isNewMessage());
            }
            if(super.getBuildController().createUnit()){
                super.getUnitController().createUnit();
            }
            if(super.getBuildController().getListBuilds().isEmpty() && !super.getLevelController().isBossFree()){
                super.getLevelController().setBossFree(true);
                super.getUnitController().freeTheBoss();
            }
            if(super.getUnitController().getBossUnit()!= null){
                super.getBulletController().shootBoss(super.getUnitController().getBossUnit());
                super.getUnitController().moveBoss();
                Bullet bull=super.getUnitController().bossShoot(super.getLevelController().getDifficult());
                if(bull!=null){
                    super.getBulletController().getListBulletsEnemies().add(bull);
                }
                boolean crear=super.getBuildController().equalsGame(super.getUnitController().getBossUnit().getHealtPoints());
                if(crear){
                    super.getUnitController().createEnemies(super.getUnitController().getBossUnit().getLifePoints()/super.getUnitController().getBossUnit().getHealtPoints(), super.getUnitController().getBossUnit().getCollisionRec().getLocation(), "clown");
                }
                if(super.getUnitController().getBossUnit().getHealtPoints()<0){
                    super.getUnitController().setBossUnit(null);
                }
            }
            if(super.getUnitController().getBossUnit()==null && super.getLevelController().isBossFree()){
                JOptionPane.showMessageDialog(null, "You finish level one");
                runThread=false;
                super.getLevelController().levelUp(this);
            }
            
            repaint();
        }
    }
    
}
