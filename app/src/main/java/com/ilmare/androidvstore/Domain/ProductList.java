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
     * goods : {"address":"中国山东","bid":11,"brand":"三九医药","describeg":"","goodsName":"999胃泰","isbn":"9E62A4F7B7BE4F06A548D8B908CF3C76","listAdd":[],"listBrand":[],"listPrice":[],"listType1":[],"listType2":[],"picPath":"goodsPics/3九胃泰.jpg","specification":"盒","type1":"药品","type2":"冲剂"}
     * id : 2DBB1ACAB7654D8F881B3B9545EB3FD9
     * isbn : 9E62A4F7B7BE4F06A548D8B908CF3C76
     * stockRecorderId : 576ABBC2C03843EF9F8DD44F02BF272D
     * storageNum : 207
     */

    private List<ListStorageEntity> listStorage;

    public void setListStorage(List<ListStorageEntity> listStorage) {
        this.listStorage = listStorage;
    }

    public List<ListStorageEntity> getListStorage() {
        return listStorage;
    }

    public static class ListStorageEntity {
        /**
         * address : 中国山东
         * bid : 11
         * brand : 三九医药
         * describeg :
         * goodsName : 999胃泰
         * isbn : 9E62A4F7B7BE4F06A548D8B908CF3C76
         * listAdd : []
         * listBrand : []
         * listPrice : []
         * listType1 : []
         * listType2 : []
         * picPath : goodsPics/3九胃泰.jpg
         * specification : 盒
         * type1 : 药品
         * type2 : 冲剂
         */

        private GoodsEntity goods;
        private String id;
        private String isbn;
        private String stockRecorderId;
        private int storageNum;

        public void setGoods(GoodsEntity goods) {
            this.goods = goods;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public void setStockRecorderId(String stockRecorderId) {
            this.stockRecorderId = stockRecorderId;
        }

        public void setStorageNum(int storageNum) {
            this.storageNum = storageNum;
        }

        public GoodsEntity getGoods() {
            return goods;
        }

        public String getId() {
            return id;
        }

        public String getIsbn() {
            return isbn;
        }

        public String getStockRecorderId() {
            return stockRecorderId;
        }

        public int getStorageNum() {
            return storageNum;
        }

        public static class GoodsEntity {
            private String address;
            private int bid;
            private String brand;
            private String describeg;
            private String goodsName;
            private String isbn;
            private String picPath;
            private String specification;
            private String type1;
            private String type2;
            private List<?> listAdd;
            private List<?> listBrand;
            private List<?> listPrice;
            private List<?> listType1;
            private List<?> listType2;

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

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
            }

            public void setIsbn(String isbn) {
                this.isbn = isbn;
            }

            public void setPicPath(String picPath) {
                this.picPath = picPath;
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

            public void setListPrice(List<?> listPrice) {
                this.listPrice = listPrice;
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

            public String getGoodsName() {
                return goodsName;
            }

            public String getIsbn() {
                return isbn;
            }

            public String getPicPath() {
                return picPath;
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

            public List<?> getListPrice() {
                return listPrice;
            }

            public List<?> getListType1() {
                return listType1;
            }

            public List<?> getListType2() {
                return listType2;
            }
        }
    }
}
