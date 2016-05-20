package com.ilmare.androidvstore.Domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhangchenggeng
 * Time 5/8/2016 5:01 PM.
 * Descripton:
 * History:
 * 版权所有
 */
public class ProductList implements Serializable{

    /**
     * address : 美国
     * bid : 22
     * brand : 三九医药
     * describeg :
     * goodsId : 49E8C29AF4714CFC9B6D5E1D252808C9
     * goodsName : 999感冒灵
     * listAdd : []
     * listBrand : []
     * listType1 : []
     * listType2 : []
     * picPath : goodsPics/999ganmaoling.jpg
     * price : 0
     * specification :
     * type1 : 药品
     * type2 : 感冒药
     */

    private List<ProductEntity> listGoods;

    public void setListGoods(List<ProductEntity> listGoods) {
        this.listGoods = listGoods;
    }

    public List<ProductEntity> getListGoods() {
        return listGoods;
    }


    @Override
    public String toString() {
        return "ProductList{" +
                "listGoods=" + listGoods +
                '}';
    }

    public static class ProductEntity implements Serializable {
        private String address;
        private int bid;
        private String brand;
        private String describeg;
        private String goodsId;
        private String goodsName;
        private String picPath;
        private int price;
        private String specification;
        private String type1;
        private String type2;
        private List<?> listAdd;
        private List<?> listBrand;
        private List<?> listType1;
        private List<?> listType2;


        @Override
        public String toString() {
            return "ProductEntity{" +
                    "address='" + address + '\'' +
                    ", bid=" + bid +
                    ", brand='" + brand + '\'' +
                    ", describeg='" + describeg + '\'' +
                    ", goodsId='" + goodsId + '\'' +
                    ", goodsName='" + goodsName + '\'' +
                    ", picPath='" + picPath + '\'' +
                    ", price=" + price +
                    ", specification='" + specification + '\'' +
                    ", type1='" + type1 + '\'' +
                    ", type2='" + type2 + '\'' +
                    ", listAdd=" + listAdd +
                    ", listBrand=" + listBrand +
                    ", listType1=" + listType1 +
                    ", listType2=" + listType2 +
                    '}';
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setBid(int bid) {
            this.bid = bid;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public void setDescribeg(String describeg) {
            this.describeg = describeg;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public void setPicPath(String picPath) {
            this.picPath = picPath;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public void setSpecification(String specification) {
            this.specification = specification;
        }

        public void setType1(String type1) {
            this.type1 = type1;
        }

        public void setType2(String type2) {
            this.type2 = type2;
        }

        public void setListAdd(List<?> listAdd) {
            this.listAdd = listAdd;
        }

        public void setListBrand(List<?> listBrand) {
            this.listBrand = listBrand;
        }

        public void setListType1(List<?> listType1) {
            this.listType1 = listType1;
        }

        public void setListType2(List<?> listType2) {
            this.listType2 = listType2;
        }

        public String getAddress() {
            return address;
        }

        public int getBid() {
            return bid;
        }

        public String getBrand() {
            return brand;
        }

        public String getDescribeg() {
            return describeg;
        }

        public String getGoodsId() {
            return goodsId;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public String getPicPath() {
            return picPath;
        }

        public int getPrice() {
            return price;
        }

        public String getSpecification() {
            return specification;
        }

        public String getType1() {
            return type1;
        }

        public String getType2() {
            return type2;
        }

        public List<?> getListAdd() {
            return listAdd;
        }

        public List<?> getListBrand() {
            return listBrand;
        }

        public List<?> getListType1() {
            return listType1;
        }

        public List<?> getListType2() {
            return listType2;
        }
    }
}
