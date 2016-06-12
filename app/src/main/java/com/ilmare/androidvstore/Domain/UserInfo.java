package com.ilmare.androidvstore.Domain;

import java.util.List;

/**
 * Created by zhangchenggeng
 * Time 5/8/2016 4:07 PM.
 * Descripton:
 * History:
 * 版权所有
 */
public class UserInfo {

    /**
     * cusAddress : 山东省青岛市
     * cusId : 4C83FEBD5BC240AC88461ADF395266DE
     * cusName : HHH
     * cusPasswd : 1111
     * priceTypeId : 2
     * priceTypeName : 一级代理
     * remark : 是个都比
     * tel : 11221
     */

    private List<ListCusEntity> listCus;

    public void setListCus(List<ListCusEntity> listCus) {
        this.listCus = listCus;
    }

    public List<ListCusEntity> getListCus() {
        return listCus;
    }

    public static class ListCusEntity {
        private String cusAddress;
        private String cusId;
        private String cusName;
        private String cusPasswd;
        private String priceTypeId;
        private String priceTypeName;
        private String remark;
        private String tel;

        public void setCusAddress(String cusAddress) {
            this.cusAddress = cusAddress;
        }

        public void setCusId(String cusId) {
            this.cusId = cusId;
        }

        public void setCusName(String cusName) {
            this.cusName = cusName;
        }

        public void setCusPasswd(String cusPasswd) {
            this.cusPasswd = cusPasswd;
        }

        public void setPriceTypeId(String priceTypeId) {
            this.priceTypeId = priceTypeId;
        }

        public void setPriceTypeName(String priceTypeName) {
            this.priceTypeName = priceTypeName;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getCusAddress() {
            return cusAddress;
        }

        public String getCusId() {
            return cusId;
        }

        public String getCusName() {
            return cusName;
        }

        public String getCusPasswd() {
            return cusPasswd;
        }

        public String getPriceTypeId() {
            return priceTypeId;
        }

        public String getPriceTypeName() {
            return priceTypeName;
        }

        public String getRemark() {
            return remark;
        }

        public String getTel() {
            return tel;
        }
    }
}
