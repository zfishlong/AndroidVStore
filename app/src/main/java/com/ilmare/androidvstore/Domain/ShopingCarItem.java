package com.ilmare.androidvstore.Domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * ===============================
 * 作者: ilmare:
 * 创建时间：5/19/2016 8:11 PM
 * 版本号： 1.0
 * 版权所有(C) 5/19/2016
 * 描述：
 * ===============================
 */

public class ShopingCarItem implements Serializable {

    private ProductList.ListStorageEntity shopingCarItemProductEntity;

    private int orderNumber;


    public ProductList.ListStorageEntity getShopingCarItemProductEntity() {
        return shopingCarItemProductEntity;
    }

    public void setShopingCarItemProductEntity(ProductList.ListStorageEntity shopingCarItemProductEntity) {
        this.shopingCarItemProductEntity = shopingCarItemProductEntity;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
}
