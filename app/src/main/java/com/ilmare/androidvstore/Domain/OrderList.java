package com.ilmare.androidvstore.Domain;

import java.util.List;

/**
 * ===============================
 * 作者: ilmare:
 * 创建时间：5/21/2016 1:18 PM
 * 版本号： 1.0
 * 版权所有(C) 5/21/2016
 * 描述：
 * ===============================
 */

public class OrderList {


    /**
     * beginDate : {"date":17,"day":2,"hours":0,"minutes":0,"month":4,"seconds":0,"time":1463414400000,"timezoneOffset":-480,"year":116}
     * cusId : 4C83FEBD5BC240AC88461ADF395266DE
     * customer : null
     * endDate : null
     * expressId :
     * goods : null
     * goodsId : 6F4C82E7162946B7B2E02F79DDE83D36
     * id : 1F14E948A24E4ECE832DB0F7EDE64092
     * num : 10
     * status : 1
     * statusStr : 待仓管审核
     */

    private List<ListCusorderEntity> listCusorder;

    public void setListCusorder(List<ListCusorderEntity> listCusorder) {
        this.listCusorder = listCusorder;
    }

    public List<ListCusorderEntity> getListCusorder() {
        return listCusorder;
    }

    public static class ListCusorderEntity {
        /**
         * date : 17
         * day : 2
         * hours : 0
         * minutes : 0
         * month : 4
         * seconds : 0
         * time : 1463414400000
         * timezoneOffset : -480
         * year : 116
         */

        private BeginDateEntity beginDate;
        private String cusId;
        private Object customer;
        private Object endDate;
        private String expressId;
        private Object goods;
        private String goodsId;
        private String id;
        private int num;
        private int status;
        private String statusStr;

        public void setBeginDate(BeginDateEntity beginDate) {
            this.beginDate = beginDate;
        }

        public void setCusId(String cusId) {
            this.cusId = cusId;
        }

        public void setCustomer(Object customer) {
            this.customer = customer;
        }

        public void setEndDate(Object endDate) {
            this.endDate = endDate;
        }

        public void setExpressId(String expressId) {
            this.expressId = expressId;
        }

        public void setGoods(Object goods) {
            this.goods = goods;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public void setStatusStr(String statusStr) {
            this.statusStr = statusStr;
        }

        public BeginDateEntity getBeginDate() {
            return beginDate;
        }

        public String getCusId() {
            return cusId;
        }

        public Object getCustomer() {
            return customer;
        }

        public Object getEndDate() {
            return endDate;
        }

        public String getExpressId() {
            return expressId;
        }

        public Object getGoods() {
            return goods;
        }

        public String getGoodsId() {
            return goodsId;
        }

        public String getId() {
            return id;
        }

        public int getNum() {
            return num;
        }

        public int getStatus() {
            return status;
        }

        public String getStatusStr() {
            return statusStr;
        }

        public static class BeginDateEntity {
            private int date;
            private int day;
            private int hours;
            private int minutes;
            private int month;
            private int seconds;
            private long time;
            private int timezoneOffset;
            private int year;

            public void setDate(int date) {
                this.date = date;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public void setHours(int hours) {
                this.hours = hours;
            }

            public void setMinutes(int minutes) {
                this.minutes = minutes;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public void setSeconds(int seconds) {
                this.seconds = seconds;
            }

            public void setTime(long time) {
                this.time = time;
            }

            public void setTimezoneOffset(int timezoneOffset) {
                this.timezoneOffset = timezoneOffset;
            }

            public void setYear(int year) {
                this.year = year;
            }

            public int getDate() {
                return date;
            }

            public int getDay() {
                return day;
            }

            public int getHours() {
                return hours;
            }

            public int getMinutes() {
                return minutes;
            }

            public int getMonth() {
                return month;
            }

            public int getSeconds() {
                return seconds;
            }

            public long getTime() {
                return time;
            }

            public int getTimezoneOffset() {
                return timezoneOffset;
            }

            public int getYear() {
                return year;
            }
        }
    }
}
