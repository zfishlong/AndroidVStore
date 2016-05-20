package com.ilmare.androidvstore.Domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * ===============================
 * 作者: ilmare:
 * 创建时间：5/19/2016 8:10 PM
 * 版本号： 1.0
 * 版权所有(C) 5/19/2016
 * 描述：
 * ===============================
 */
public class ShopingCar implements Serializable {

    private ArrayList<ShopingCarItem> shopingCarList=new ArrayList<>();


    public ArrayList<ShopingCarItem> getShopingCarList() {
        return shopingCarList;
    }

    public void setShopingCarList(ArrayList<ShopingCarItem> shopingCarList) {
        this.shopingCarList = shopingCarList;
    }


    public void setShoppingItem(ShopingCarItem item){
        shopingCarList.add(item);
    }


}
