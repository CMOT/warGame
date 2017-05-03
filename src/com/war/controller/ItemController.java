/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.war.controller;

import com.war.model.CatalogItem;
import com.war.model.Item;
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
    
    public void addItem(int x, int y, int team, int type){
        switch(type){
            case 1://Bomba
                itemList.add(catalogItem.getBombItem(x, y, 500 ,team));
                break;
            case 2://Por definir nuevos items
//                itemList.add(catalogItem.getBombItem(x, y, team));
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
