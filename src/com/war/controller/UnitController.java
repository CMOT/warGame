/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.controller;

import com.war.model.Build;
import com.war.model.Bullet;
import com.war.model.CatalogUnit;
import com.war.model.Target;
import com.war.model.Unit;
import com.war.utils.CommonUtils;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author ASUS
 */
public class UnitController {
    
    private volatile ArrayList<Unit> listEnemies;
    private volatile ArrayList<Unit> listAllies;
    private volatile Unit bossUnit;
    volatile Unit clown, sold;
    CatalogUnit units;
    
    public UnitController(){
        listEnemies= new ArrayList<Unit>();
        listAllies= new ArrayList<Unit>();
        units= new CatalogUnit();
        bossUnit= null;
    }
    
    public void fillListEnemies(int size, int radioX, int radioY){
        int count =1;
        for(int i=0; i < 12*size; i++){
            if(count==4){
                count=1;
            }
            clown  =units.getClown(radioX+(int)(Math.random()*100 + 1), radioY +(int)(Math.random()*120 + 20)*count, 2);
            getListEnemies().add(clown);
            count++;
        }
    }
    
    public void fillListAllies(int x, int y, int difficult){
        for(int i=1; i<= difficult; i++){
            sold=units.getMasterChief(x+(int)(Math.random()*50), (y+20)*i, 1);
            getListAllies().add(sold);
        }
    }

    public boolean moveUnit( Unit selected){
        if(selected!= null){
            if(!(selected.getX() >= selected.getLimit().x-2 && selected.getX()<=selected.getLimit().x+2 ) && selected.getState()==1 ){
                if(selected.getLimit().x-selected.getX()>150 || selected.getTarget()==null){
                    selected.setX(selected.getX()+ selected.getMoveX());
                }else{
                    selected.setX(selected.getX()- selected.getMoveX());
                }
            }
            if(!(selected.getY() >= selected.getLimit().y+2 && selected.getY()<=selected.getLimit().y+8 ) && selected.getState()==1){
                    if(selected.getY()>0 && selected.getY()<CommonUtils.height-20){
                        selected.setY(selected.getY()+ selected.getMoveY());
                    }else {
                        if(selected.getY()>CommonUtils.height-20){
                            selected.setY(selected.getY()-1);
                        }else{
                            selected.setY(selected.getY()+1);
                        }
                    }
            }
            if(selected.getTarget() != null ){
                if(selected.getTarget() instanceof Unit){
                    Unit unitT=(Unit) selected.getTarget();
                     selected.setLimit(new Point(unitT.getX(), unitT.getY()+4));
                     selected.setMoveX(unitT.getX() - selected.getX() > 0 ? 2 : -2);
                     selected.setMoveY(unitT.getY() - selected.getY() > 0 ? 2 : -2);
                    if( CommonUtils.isCloseToThePoint(selected.getY(), unitT.getY(), unitT.getImage().getIconHeight())){
                       selected.setState(2);
                       selected.setImage(getImageState(selected.getNameImage(), 2));
                   }else{
                        selected.setState(1);
                       selected.setImage(getImageState(selected.getNameImage(), 1));
                    }
                }else
                if(selected.getTarget() instanceof Build){
                    Build buildT=(Build) selected.getTarget();
                     selected.setLimit(new Point(buildT.getX(), buildT.getY()+4));
                     selected.setMoveX(buildT.getX() - selected.getX() > 0 ? 2 : -2);
                     selected.setMoveY(buildT.getY() - selected.getY() > 0 ? 2 : -2);
                    if( CommonUtils.isCloseToThePoint(selected.getY(), buildT.getY(), buildT.getImage().getIconHeight())){
                       selected.setState(2);
                       selected.setImage(getImageState(selected.getNameImage(), 2));
                   }else{
                        selected.setState(1);
                       selected.setImage(getImageState(selected.getNameImage(), 1));
                    }
                }
            }else{
                selected.setState(1);
                selected.setImage(getImageState(selected.getNameImage(), 1));
            }
            return !((selected.getX() >= selected.getLimit().x-2 && selected.getX()<=selected.getLimit().x+2 ) && (selected.getY() >= selected.getLimit().y+2 && selected.getY()<=selected.getLimit().y+8 ));
        }else{
            return false;
        }
    }
    
    public Bullet unitShooter(Unit shooted){
        Bullet bullet= null;
        if(shooted.getState()==2 && shooted.getTarget()!=null){
            if(shooted.getLimit().x-shooted.getX()<180 && shooted.getX()>0 ){
                   shooted.setX(shooted.getX()- 1);
                   shooted.setImage(getImageState(shooted.getNameImage(), 1));
            }
            if(shooted.getBulletType().equalsIgnoreCase("bala") || shooted.getBulletType().equalsIgnoreCase("espada")){
                if(shooted.getCountShoot()==shooted.getShootCold()){
                        bullet= new Bullet((int)shooted.getForce(), shooted.getX()+5, shooted.getY()+5, shooted.getBulletType(), shooted.getTeam(), shooted.getTarget().getX(), shooted.getTarget().getY());
                        shooted.setCountShoot(0);
                }
            }else{
                if(shooted.getCountShoot()>=shooted.getShootCold() && shooted.getCountShoot()<=shooted.getShootCold()+16 ){
                    shooted.setCountShoot(shooted.getCountShoot()+1);
                    if(shooted.getCountShoot()==shooted.getShootCold()+5 || shooted.getCountShoot()==shooted.getShootCold()+11 || shooted.getCountShoot()==shooted.getShootCold()+17){
                        bullet= new Bullet((int)shooted.getForce(), shooted.getX()+5, shooted.getY()+10, shooted.getBulletType(), shooted.getTeam(), shooted.getTarget().getX(), shooted.getTarget().getY());
                        if(shooted.getCountShoot()==shooted.getShootCold()+17 ){
                            shooted.setCountShoot(0);
                        }
                    }
                }
            }
        }
        return bullet;
    }
    
    public void randomMove(Unit unit, int difficult){
        
        unit.setMoveCount(unit.getMoveCount()+1);
        if(unit.getMoveCount()==  getLimit(difficult)){
            unit.setState(1);
            unit.setImage(getImageState(unit.getNameImage(), 1));
            double random=Math.random();
            double randomY=Math.random();
            if(randomY>.5  && unit.getY()<CommonUtils.height-80 ){
                unit.setMoveY(1); 
            }else{
                if(unit.getY()>40){
                    unit.setMoveY(-1);
                }else{
                    unit.setMoveY(1);
                }
            }
            if(unit.getX()<CommonUtils.width-100 && random>.5){
                unit.setMoveX(1);
                unit.setLimit(new Point(unit.getX()+ (int)(Math.random()*100), (int)(unit.getY()+Math.random()*35) ));
            }else{
                if(unit.getX()>40){
                    unit.setMoveX(-1);
                    unit.setLimit(new Point(unit.getX()- (int)(Math.random()*100), (int)(unit.getY()-Math.random()*35) ));
                }else{
                    unit.setMoveX(1);
                    unit.setLimit(new Point(unit.getX()+ (int)(Math.random()*100), (int)(unit.getY()+Math.random()*35) ));
                }
            }
            unit.setMoveCount(0);
        }
        if(unit.getState()==1 && unit.getX()!=unit.getLimit().x ){
                unit.setX(unit.getX()+ unit.getMoveX());
                unit.getRatio().setLocation(unit.getX()-unit.getImage().getIconWidth()*3, unit.getY()-unit.getImage().getIconHeight()*3);
        }
        if(unit.getState()==1 && unit.getY()!=unit.getLimit().y ){
                unit.setY(unit.getY()+ unit.getMoveY());
                unit.getRatio().setLocation(unit.getX()-unit.getImage().getIconWidth()*3, unit.getY()-unit.getImage().getIconHeight()*3);
        }
        if((unit.getX()== unit.getLimit().x && unit.getY()== unit.getLimit().y)){
            unit.setState(0);
            unit.setImage(getImageState(unit.getNameImage(), 0));
        }
    }
    public int getLimit(int d){
        switch(d){
            case 1:
                return 105;
            case 2:
                return 90;
            case 3:
                return 80;
            default :
                return 0;
        }
    }
    
    public ImageIcon getImageState(String image,int state){
        String url="/units/"+image+""+state;
        switch(state){
            case 0:
                url+=".png";
                break;
            case 1:
                url+=".gif";
                break;
            case 2:
                url+=".png";
                break;
        }
        return new ImageIcon(getClass().getResource(url));
    }
    
    public Target deleteTargets(Target eliminated, int team){
        if(team==1){
            for(Unit unit : getListAllies()){
                if(unit.getTarget()!=null && unit.getTarget().equals(eliminated)){
                    unit.setTarget(null);
                    unit.setLimit(new Point(unit.getX(), unit.getY()-15));
                    unit.setState(1);
                }
            }
        }else{
            for(Unit unit : getListEnemies()){
                if(unit.getTarget()!=null && unit.getTarget().equals(eliminated)){
                    unit.setTarget(null);
                    unit.setLimit(new Point(unit.getX(), unit.getY()-12));
                    unit.setState(1);
                }
            }
        }
//        CommonUtils.selected=null;
        return null;
    }
    
    public void autoAtack(Unit enemy){
//        for(Unit enemy: getListEnemies()){
            for(Unit allie: getListAllies()){
                if(enemy.getRatio().contains(allie.getCollisionRec())){
                    enemy.setLimit(new Point(allie.getX(), allie.getY()-5));
                    enemy.setMoveX( enemy.getX()>allie.getX() ? -1 : 1  );
                    enemy.setMoveY( enemy.getY()>allie.getY() ? -1 : 1  );
                    enemy.setState(2);
                    enemy.setTarget(allie);
                    enemy.setImage(getImageState(enemy.getNameImage(), 1));
                }
//               else{
//                    enemy.setState(1);
//                    enemy.setTarget(null);
//                }
            }
//        }
    }
    public void atackUnit(Unit enemy){
//        for(Unit enemy: getListEnemies()){
//            if(enemy.getTarget()!= null){
                if(enemy.getX()!=enemy.getTarget().getX()){
                    enemy.setX(enemy.getX()+enemy.getMoveX());
                }
                if(  !(enemy.getY() <= enemy.getTarget().getY()+5 &&  enemy.getY()>=enemy.getTarget().getY()-5)  ){
                    enemy.setY(enemy.getY()+enemy.getMoveY());
                }
                boolean died=false;
                for(Unit allie: getListAllies()){
                    if(enemy.getCollisionRec().intersects(allie.getCollisionRec()) ){
                        allie.setHealtPoints(allie.getHealtPoints()-1);
                        if(allie.getHealtPoints()<1){
//                            getListAllies().remove(allie);
//                            enemy.setTarget(null);
//                            enemy.setState(1);
                            died=true;
                        }
                    }
                    if(died){
                        for(Unit enemy2: getListEnemies()){
                            if(enemy2.getTarget()!=null && enemy2.getTarget().equals(allie)){
                                enemy2.setTarget(null);
                                enemy2.setState(1);
                            }
                        }
                        if(allie.equals(CommonUtils.selected)){
                            CommonUtils.selected=null;
                        }
                        getListAllies().remove(allie);
                        died=false;
                        break;
                    }
                }
                enemy.getRatio().setLocation(enemy.getX()-enemy.getImage().getIconWidth()*3, enemy.getY()-enemy.getImage().getIconHeight()*3);
//            }
//        }
    }
    
    
    public void createUnit(){
        switch(CommonUtils.typeUnit){
            case 1:
                sold= units.getMasterChief(30, 200, 1);
                break;
            case 2:
                sold= units.getKratos(30, 200, 1);
                break;
            case 3:
                sold= units.getAmetrallador(30, 200, 1);
                break;
            default:
                sold=units.getMasterChief(30, 200, 1);
        }
        System.out.println("Se creo una unidad: "+ CommonUtils.typeUnit);
        if(sold!=null){
            sold.setLimit(new Point(30 +(int)(Math.random()*60), 50 + (int)(Math.random()*250) ));
            sold.setMove(true);
            sold.setState(1);
            sold.setMoveX(sold.getLimit().getX() - sold.getX() > 0 ? 2 : -2);
            sold.setMoveY(sold.getLimit().getY() - sold.getY() > 0 ? 2 : -2);
            getListAllies().add(sold);
            sold=null;
        }
        
    }
    public void createEnemies(int size, Point out){
        System.out.println("Crea a: "+size+ " en el punto x: " +out.x + " en y: "+ out.y);
        for(int i=1; i<= size*2; i++){
            System.out.println("ciclo de creacion");
            sold= units.getClown(out.x, out.y, 2);
            sold.setLimit(new Point((int)(out.getX()-(Math.random()*30)), (int)(out.getY()+(Math.random()*30)) ));
            sold.setMove(true);
            sold.setState(1);
            sold.setMoveX(sold.getLimit().getX() - sold.getX() > 0 ? 1 : -1);
            sold.setMoveY(sold.getLimit().getY() - sold.getY() > 0 ? 1 : -1);
            getListEnemies().add(sold);
        }
    }
    
    public void freeTheBoss(){
        bossUnit= units.getClownBoss(CommonUtils.width-150, 200, 2);
//        getListEnemies().add(sold);
    }
    
    public void moveBoss(){
        bossUnit.setMoveCount(bossUnit.getMoveCount()+1);
        bossUnit.setCountShoot(bossUnit.getCountShoot()+1);
        if(bossUnit.getMoveCount()==  90){
            bossUnit.setState(1);
            bossUnit.setImage(getImageState(bossUnit.getNameImage(), 1));
            double random=Math.random();
            double randomY=Math.random();
//            bossUnit.setMoveX(1);
            if(randomY>.5  && bossUnit.getY()<CommonUtils.height-80 ){
                if(bossUnit.getY()>50){
                    
                }else{
                    bossUnit.setMoveY(1); 
                }
            }else{
                if(bossUnit.getY()>40)
                bossUnit.setMoveY(-1);
            }
            if(bossUnit.getX()<CommonUtils.width-80 && random>.5){
                bossUnit.setMoveX(1);
                bossUnit.setLimit(new Point(bossUnit.getX()+ (int)(Math.random()*100), (int)(bossUnit.getY()+randomY*35) ));
            }else{
                if(bossUnit.getX()>CommonUtils.width/2){
                    bossUnit.setMoveX(-1);
                    bossUnit.setLimit(new Point(bossUnit.getX()- (int)(Math.random()*100), (int)(bossUnit.getY()-randomY*35) ));
                }else{
                    bossUnit.setMoveX(1);
                    bossUnit.setLimit(new Point(bossUnit.getX()+ (int)(Math.random()*100), (int)(bossUnit.getY()+randomY*35) ));
                }
            }
            bossUnit.setMoveCount(0);
        }
        if(bossUnit.getState()==1 && bossUnit.getX()!=bossUnit.getLimit().x ){
            bossUnit.setX(bossUnit.getX()+ bossUnit.getMoveX());
            bossUnit.getRatio().setLocation(bossUnit.getX()-bossUnit.getImage().getIconWidth()*3, bossUnit.getY()-bossUnit.getImage().getIconHeight()*3);
        }
        if(bossUnit.getState()==1 && bossUnit.getY()!=bossUnit.getLimit().y ){
            bossUnit.setY(bossUnit.getY()+ bossUnit.getMoveY());
            bossUnit.getRatio().setLocation(bossUnit.getX()-bossUnit.getImage().getIconWidth()*3, bossUnit.getY()-bossUnit.getImage().getIconHeight()*3);
        }
        if(bossUnit.getX()== bossUnit.getLimit().x && bossUnit.getY()== bossUnit.getLimit().y){
            bossUnit.setState(0);
            bossUnit.setImage(getImageState(bossUnit.getNameImage(), 0));
        }
    }
    
    public Bullet bossShoot(int difficult){
        Bullet bullet=null;
         if(bossUnit.getCountShoot()<=bossUnit.getShootCold()  ){
            bossUnit.setCountShoot(bossUnit.getCountShoot()+1);
            if(CommonUtils.numberOfBullets(bossUnit.getCountShoot(), bossUnit.getShootCold(), difficult)){
                bullet= new Bullet((int)bossUnit.getForce(), bossUnit.getX()+10, bossUnit.getY()+20, bossUnit.getBulletType(), bossUnit.getTeam(), 0, 0);
                if(bossUnit.getCountShoot()==bossUnit.getShootCold() ){
                    bossUnit.setCountShoot(0);
                }
            }
        }else{
             bossUnit.setCountShoot(0);
         }
        return bullet;
    }
    
    
//    public boolean numberOfBullets(int current, int max, int difficult){
//        switch(difficult){
//            case 1:
//                
//                return (current==max-16 || current==max-10 || current==max-4);
//            case 2:
//                
//                 return (current==max-22 || current==max-16 || current==max-10 || current==max-4);
//            case 3:
//                
//                 return (current==max-26 || current==max-22 || current==max-16 || current==max-10 || current==max-4);
//        }
//        return false;
//    }
    /**
     * @return the listEnemies
     */
    public ArrayList<Unit> getListEnemies() {
        return listEnemies;
    }

    /**
     * @return the listAllies
     */
    public ArrayList<Unit> getListAllies() {
        return listAllies;
    }

    public Unit getBossUnit() {
        return bossUnit;
    }

    public void setBossUnit(Unit bossUnit) {
        this.bossUnit = bossUnit;
    }
    
    
    
}
