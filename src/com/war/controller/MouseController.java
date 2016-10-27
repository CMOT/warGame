/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.controller;

import com.war.GUI.LevelOne;
import com.war.GUI.PanelInfo;
import com.war.model.Build;
import com.war.model.Unit;
import com.war.utils.CommonUtils;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author ASUS
 */
public class MouseController implements MouseListener {

    LevelOne level;
    Unit selected;
    Build selectedBuild;
    PanelInfo info;

    public MouseController(LevelOne level, PanelInfo info) {
        this.level = level;
        selected = null;
        selectedBuild = null;
        this.info = info;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getModifiers() == 16) {
            CommonUtils.selected=null;
            for (Unit unit : level.getUnitController().getListAllies()) {
                if (unit.getCollisionRec().contains(e.getPoint())) {
                    selected = unit;
                    CommonUtils.selected=unit;
                    break;
                } else {
                    CommonUtils.selected=null;
                    selected = null;
                }
            }
            if(CommonUtils.selected!= null){
                info.updateInfoUnit((Unit)CommonUtils.selected);
            }
            if ( CommonUtils.selected==null) {
                for (Unit unit : level.getUnitController().getListEnemies()) {
                    if (unit.getCollisionRec().contains(e.getPoint())) {
                        selected = unit;
                        CommonUtils.selected=unit;
                        break;
                    } else {
                        CommonUtils.selected=null;
                        selected = null;
                    }
                }
                info.updateInfoUnit((Unit)CommonUtils.selected);
            }
            if ( CommonUtils.selected==null) {
                for (Build build : level.getBuildController().getListBuilds()) {
                    if (build.getCollisionRec().contains(e.getPoint())) {
                        selectedBuild = build;
                        CommonUtils.selected=build;
                        break;
                    } else {
                        CommonUtils.selected=null;
                        selectedBuild = null;
                    }
                }
                info.updateInfoBuild((Build)CommonUtils.selected);
            }
            if ( CommonUtils.selected==null) {
                for (Build build : level.getBuildController().getListBuildAllies()) {
                    if (build.getCollisionRec().contains(e.getPoint())) {
                        selectedBuild = build;
                        CommonUtils.selected=build;
                        break;
                    } else {
                        CommonUtils.selected=null;
                        selectedBuild = null;
                    }
                }
                info.updateInfoBuild((Build)CommonUtils.selected);
            }
        } else if (e.getModifiers() == 4 && selected != null) {
            selected.setMove(true);
            for (Unit unit : level.getUnitController().getListEnemies()) {
                if (unit.getCollisionRec().contains(e.getPoint())) {
                    selected.setState(1);
                    selected.setTarget(unit);
                    break;
                } else {
                    selected.setTarget(null);
                }
            }
            if (selected.getTarget() == null) {
                for (Build build : level.getBuildController().getListBuilds()) {
                    if (build.getCollisionRec().contains(e.getPoint())) {
                        selected.setState(1);
                        selected.setTarget(build);
                        break;
                    } else {
                        selected.setTarget(null);
                    }
                }
            }
            if (selected.getTarget() == null) {
                Unit boss = level.getUnitController().getBossUnit();
                    if (boss.getCollisionRec().contains(e.getPoint())) {
                        selected.setState(1);
                        selected.setTarget(boss);
                    } else {
                        selected.setTarget(null);
                    }
            }
            if (selected.getTarget() != null) {
                selected.setLimit(new Point(selected.getTarget().getX(), selected.getTarget().getY()));
                selected.setMoveX(selected.getTarget().getX() - selected.getX() > 0 ? 1 : -1);
                selected.setMoveY(selected.getTarget().getY() - selected.getY() > 0 ? 1 : -1);
            }else{
                 selected.setLimit(e.getPoint());
                 selected.setMoveX(e.getX() - selected.getX() > 0 ? 1 : -1);
                 selected.setMoveY(e.getY() - selected.getY() > 0 ? 1 : -1);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
