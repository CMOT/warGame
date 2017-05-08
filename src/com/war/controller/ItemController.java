/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.controller;

import com.war.model.CatalogItem;
import com.war.model.Item;
import com.war.utils.CommonUtils;
import java.util.ArrayList;

/**
 *
 * @author Cesar
 */
public class ItemController {
    
    private volatile ArrayList<Item> itemList;
    private CatalogItem catalogItem;
    
    public ItemController(){
        itemList= new ArrayList<>();
        catalogItem= new CatalogItem();
    }
    
    public void addItem(int x, int y, int team){
        String type= CommonUtils.itemselect;
        switch(type){
            case "smallBomb"://Bomba
                itemList.add(catalogItem.getSmallBombItem(x, y, 180 ,team));
                break;
            case "bigBomb"://Por definir nuevos items
                itemList.add(catalogItem.getBigBombItem(x, y, 240 ,team));
                break;
        }
        
    }
    
    /**
     * @return the itemList
     */
    public ArrayList<Item> getItemList() {
        return itemList;
    }

    /**
     * @param itemList the itemList to set
     */
    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    /**
     * @return the catalogItem
     */
    public CatalogItem getCatalogItem() {
        return catalogItem;
    }

    /**
     * @param catalogItem the catalogItem to set
     */
    public void setCatalogItem(CatalogItem catalogItem) {
        this.catalogItem = catalogItem;
    }
    
}
