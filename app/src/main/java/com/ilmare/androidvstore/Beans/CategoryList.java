package com.ilmare.androidvstore.Beans;

import java.util.List;

/**
 * ===============================
 * 作者: ilmare:
 * 创建时间：5/13/2016 10:28 AM
 * 版本号： 1.0
 * 版权所有(C) 5/13/2016
 * 描述：
 * ===============================
 */

public class CategoryList {

    /**
     * response : category
     * category : [{"id":101,"isleafnode":false,"name":"孕妈专区","parent_id":0,"pic":"http://192.168.56.1:8080/Shopping_ec/images/1.png","tag":"孕产营养品/奶粉"},{"id":102,"isleafnode":false,"name":"营养食品","parent_id":0,"pic":"http://192.168.56.1:8080/Shopping_ec/images/1.png","tag":"奶粉"},{"id":103,"isleafnode":true,"name":"成长用品","parent_id":0,"pic":"http://192.168.56.1:8080/Shopping_ec/images/1.png","tag":"尿裤/纸巾  婴幼儿洗浴护肤"},{"id":104,"isleafnode":true,"name":"玩具童车","parent_id":0,"pic":"http://192.168.56.1:8080/Shopping_ec/images/1.png","tag":"启智玩具  婴儿车"},{"id":105,"isleafnode":true,"name":"宝宝靓装","parent_id":0,"pic":"http://192.168.56.1:8080/Shopping_ec/images/1.png","tag":"男童服饰  女童服饰"},{"id":106,"isleafnode":true,"name":"图书","parent_id":0,"pic":"http://192.168.56.1:8080/Shopping_ec/images/1.png","tag":"孕产妈妈  育儿/亲子"},{"id":10101,"isleafnode":false,"name":"孕产营养品/奶粉","parent_id":101,"pic":"","tag":"孕产妈妈  育儿/亲子"},{"id":10102,"isleafnode":false,"name":"防辐射","parent_id":101,"pic":"","tag":"孕产妈妈  育儿/亲子"},{"id":10101,"isleafnode":false,"name":"奶粉","parent_id":102,"pic":"","tag":""},{"id":10102,"isleafnode":false,"name":"辅食","parent_id":102,"pic":"","tag":""},{"id":1010101,"isleafnode":true,"name":"妈妈营养品","parent_id":10101,"pic":"","tag":""},{"id":1010102,"isleafnode":true,"name":"妈妈奶粉","parent_id":10101,"pic":"","tag":""},{"id":1010201,"isleafnode":true,"name":"防辐射服","parent_id":10102,"pic":"","tag":""},{"id":1010202,"isleafnode":true,"name":"防辐射眼镜","parent_id":10102,"pic":"","tag":""}]
     * version : 2
     */

    private String response;
    private String version;

    /**
     * id : 101
     * isleafnode : false
     * name : 孕妈专区
     * parent_id : 0
     * pic : http://192.168.56.1:8080/Shopping_ec/images/1.png
     * tag : 孕产营养品/奶粉
     */

    private List<CategoryEntity> category;

    public void setResponse(String response) {
        this.response = response;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setCategory(List<CategoryEntity> category) {
        this.category = category;
    }

    public String getResponse() {
        return response;
    }

    public String getVersion() {
        return version;
    }

    public List<CategoryEntity> getCategory() {
        return category;
    }

    public static class CategoryEntity {
        private int id;
        private boolean isleafnode;
        private String name;
        private int parent_id;
        private String pic;
        private String tag;

        public void setId(int id) {
            this.id = id;
        }

        public void setIsleafnode(boolean isleafnode) {
            this.isleafnode = isleafnode;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setParent_id(int parent_id) {
            this.parent_id = parent_id;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public int getId() {
            return id;
        }

        public boolean isIsleafnode() {
            return isleafnode;
        }

        public String getName() {
            return name;
        }

        public int getParent_id() {
            return parent_id;
        }

        public String getPic() {
            return pic;
        }

        public String getTag() {
            return tag;
        }
    }
}
