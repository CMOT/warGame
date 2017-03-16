/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.utils;

import com.war.model.Target;

/**
 *
 * @author TMK
 */
public class CommonUtils {
    
    public static final int TEAM_1=1;
    public static final int TEAM_2=2;
    public static int width=0;
    public static int height=0;
    public static double time=0;
    public static int points=300;
    public static Target selected= null;
    public static int timeUnit=0;
    public static boolean createUnit=false;
    public static int typeUnit=0;
    public static int difficult=0;
    
    private CommonUtils(){
        
    }
    
    public static void resetValues(){
        points=300;
        time=0;
        timeUnit=0;
        selected=null;
        createUnit=false;
        typeUnit=0;
        difficult=0;
    }
    
     public static boolean isCloseToThePoint(int y1, int y2, int size){
        if(y1==y2){
            return true;
        }else if(y1  < y2+size-(size/4) && y1 > y2){
            return true;
        }else{
            return false;
        }
    }
     
     public static int getPercent(int currentValue, int maxValue, int sizeBar){
         
         return (currentValue*sizeBar/maxValue );
     }
     public static int calcX(int catOp, int catAd, double time){
         return (int)(15*( catAd/getHipotenusa(catOp, catAd) )*time );
//         return (int)(15*( 45 )*time );
     }
     public static double getHipotenusa(int op, int ad){
         
         return Math.sqrt(Math.pow(ad, 2)+Math.pow(op, 2));
     }
     public static int calcY(int catOp, int catAd, double time ){
         
         return (int)( (15*catOp/getHipotenusa(catOp, catAd)*time)-( 9.8*Math.pow(time, 2))/2 );
//         return (int)( (15*45*time)-( 9.8*Math.pow(time, 2))/2 );
     }
     
     public static boolean numberOfBullets(int current, int max, int difficult){
        switch(difficult){
            case 1:
                
                return (current==max-16 || current==max-10 || current==max-4);
            case 2:
                
                 return (current==max-22 || current==max-16 || current==max-10 || current==max-4);
            case 3:
                
                 return (current==max-26 || current==max-22 || current==max-16 || current==max-10 || current==max-4);
        }
        return false;
    }
}
