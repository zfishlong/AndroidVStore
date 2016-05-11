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
     * cusAddress : 山东省菏泽市
     * cusId : AA4B9F6F8838483EACC518EB5A227FC8
     * cusName : LZY
     * cusPasswd : 1111
     * remark :
     * tel : 11111
     */

    private List<ListCusEntity> listCus;

    public void setListCus(List<ListCusEntity> listCus) {
        this.listCus = listCus;
    }

    public List<ListCusEntity> getListCus() {
        return listCus;
    }


    @Override
    public String toString() {
        return "UserInfo{" +
                "listCus=" + listCus +
                '}';
    }

    public static class ListCusEntity {
        private String cusAddress;
        private String cusId;
        private String cusName;
        private String cusPasswd;
        private String remark;
        private String tel;


        @Override
        public String toString() {
            return "ListCusEntity{" +
                    "cusAddress='" + cusAddress + '\'' +
                    ", cusId='" + cusId + '\'' +
                    ", cusName='" + cusName + '\'' +
                    ", cusPasswd='" + cusPasswd + '\'' +
                    ", remark='" + remark + '\'' +
                    ", tel='" + tel + '\'' +
                    '}';
        }

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

        public String getRemark() {
            return remark;
        }

        public String getTel() {
            return tel;
        }
    }
}
