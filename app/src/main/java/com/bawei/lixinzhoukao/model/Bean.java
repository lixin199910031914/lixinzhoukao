package com.bawei.lixinzhoukao.model;

import java.util.List;

public class Bean {

    private List<BeanData> data;

    public List<BeanData> getData() {
        return data;
    }

    public void setData(List<BeanData> data) {
        this.data = data;
    }
    public  class  BeanData{
        private String currency_price;
        private String goods_name;
        private String goods_thumb;

        public String getCurrency_price() {
            return currency_price;
        }

        public void setCurrency_price(String currency_price) {
            this.currency_price = currency_price;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getGoods_thumb() {
            return goods_thumb;
        }

        public void setGoods_thumb(String goods_thumb) {
            this.goods_thumb = goods_thumb;
        }
    }
}
