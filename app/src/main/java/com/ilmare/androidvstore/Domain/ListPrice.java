package com.ilmare.androidvstore.Domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ===============================
 * 作者: ilmare:
 * 创建时间：6/11/2016 11:18 PM
 * 版本号： 1.0
 * 版权所有(C) 6/11/2016
 * 描述：
 * ===============================
 */
public class ListPrice implements Serializable{
    /**
     * id : 04D2EB04DF274451834F12952A3B6281
     * isbn : 720DD3366F374F16B5AE46F571CD7C4C
     * price : 7
     * priceType : null
     * pricetypeid : 1
     */
    private List<ListPriceEntity> listPrice;

    public void setListPrice(List<ListPriceEntity> listPrice) {
        this.listPrice = listPrice;
    }

    public List<ListPriceEntity> getListPrice() {
        return listPrice;
    }

    public static class ListPriceEntity implements Serializable{
        private String id;
        private String isbn;
        private int price;
        private Object priceType;
        private String pricetypeid;

        public void setId(String id) {
            this.id = id;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public void setPriceType(Object priceType) {
            this.priceType = priceType;
        }

        public void setPricetypeid(String pricetypeid) {
            this.pricetypeid = pricetypeid;
        }

        public String getId() {
            return id;
        }

        public String getIsbn() {
            return isbn;
        }

        public int getPrice() {
            return price;
        }

        public Object getPriceType() {
            return priceType;
        }

        public String getPricetypeid() {
            return pricetypeid;
        }
    }


    public int getPriceByPriceTypeIdAndISBN(String priceType,String isbn){
        for (ListPriceEntity listPriceEntity : listPrice) {
            if(listPriceEntity.getIsbn().equals(isbn)&&listPriceEntity.getPricetypeid().equals(priceType)){
                return listPriceEntity.getPrice();
            }
        }
        return -1;
    }

    public List<Integer> getPricesByISBN(String isbn){
        List<Integer> prices=new ArrayList<>();
        for (ListPriceEntity listPriceEntity : listPrice) {
            if(listPriceEntity.getIsbn().equals(isbn)){
                prices.add(listPriceEntity.getPrice());
            }
        }
        return prices;
    }
}
