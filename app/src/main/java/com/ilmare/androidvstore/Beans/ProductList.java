package com.ilmare.androidvstore.Beans;

import java.util.List;

/**
 * Created by zhangchenggeng
 * Time 5/8/2016 2:52 PM.
 * Descripton:
 * History:
 * 版权所有
 */
public class ProductList {

    /**
     * productlist : [{"comment_count":15,"id":108,"marketprice":325,"name":"充气娃娃","pic":"http://192.168.1.4/ECServer_D/images/0.png","price":315,"saleNumber":76,"score":1,"timeGrounding":1942},{"comment_count":6,"id":103,"marketprice":272,"name":"啃得急","pic":"http://192.168.1.4/ECServer_D/images/1.png","price":262,"saleNumber":76,"score":2.700000047683716,"timeGrounding":1867},{"comment_count":8,"id":102,"marketprice":72,"name":"充气娃娃","pic":"http://192.168.1.4/ECServer_D/images/2.png","price":62,"saleNumber":41,"score":4.700000286102295,"timeGrounding":1524},{"comment_count":9,"id":108,"marketprice":457,"name":"隔壁投","pic":"http://192.168.1.4/ECServer_D/images/3.png","price":447,"saleNumber":161,"score":2.5,"timeGrounding":1143},{"comment_count":23,"id":101,"marketprice":195,"name":"防辐射","pic":"http://192.168.1.4/ECServer_D/images/4.png","price":185,"saleNumber":34,"score":3.799999952316284,"timeGrounding":1038},{"comment_count":30,"id":103,"marketprice":116,"name":"防晒霜","pic":"http://192.168.1.4/ECServer_D/images/5.png","price":106,"saleNumber":188,"score":4.900000095367432,"timeGrounding":1125},{"comment_count":20,"id":109,"marketprice":416,"name":"爽歪歪","pic":"http://192.168.1.4/ECServer_D/images/6.png","price":406,"saleNumber":112,"score":0.10000000149011612,"timeGrounding":1902},{"comment_count":28,"id":104,"marketprice":480,"name":"隔壁投","pic":"http://192.168.1.4/ECServer_D/images/7.png","price":470,"saleNumber":112,"score":2.799999952316284,"timeGrounding":1792},{"comment_count":25,"id":107,"marketprice":218,"name":"爽歪歪","pic":"http://192.168.1.4/ECServer_D/images/8.png","price":208,"saleNumber":188,"score":1.899999976158142,"timeGrounding":1211},{"comment_count":39,"id":102,"marketprice":395,"name":"防晒霜","pic":"http://192.168.1.4/ECServer_D/images/9.png","price":385,"saleNumber":81,"score":2,"timeGrounding":1329}]
     * response : hotproduct
     * list_count : 10
     */

    private String response;

    private int list_count;
    /**
     * comment_count : 15
     * id : 108
     * marketprice : 325
     * name : 充气娃娃
     * pic : http://192.168.1.4/ECServer_D/images/0.png
     * price : 315
     * saleNumber : 76
     * score : 1
     * timeGrounding : 1942
     */

    private List<Product> productlist;

    public void setResponse(String response) {
        this.response = response;
    }

    public void setList_count(int list_count) {
        this.list_count = list_count;
    }

    public void setProductlist(List<Product> productlist) {
        this.productlist = productlist;
    }

    public String getResponse() {
        return response;
    }

    public int getList_count() {
        return list_count;
    }

    public List<Product> getProductlist() {
        return productlist;
    }

    public static class Product {
        private int comment_count;
        private int id;
        private int marketprice;
        private String name;
        private String pic;
        private int price;
        private int saleNumber;
        private int score;
        private int timeGrounding;

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setMarketprice(int marketprice) {
            this.marketprice = marketprice;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public void setSaleNumber(int saleNumber) {
            this.saleNumber = saleNumber;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public void setTimeGrounding(int timeGrounding) {
            this.timeGrounding = timeGrounding;
        }

        public int getComment_count() {
            return comment_count;
        }

        public int getId() {
            return id;
        }

        public int getMarketprice() {
            return marketprice;
        }

        public String getName() {
            return name;
        }

        public String getPic() {
            return pic;
        }

        public int getPrice() {
            return price;
        }

        public int getSaleNumber() {
            return saleNumber;
        }

        public int getScore() {
            return score;
        }

        public int getTimeGrounding() {
            return timeGrounding;
        }
    }

    @Override
    public String toString() {
        return "ProductList{" +
                "response='" + response + '\'' +
                ", list_count=" + list_count +
                ", productlist=" + productlist +
                '}';
    }
}
