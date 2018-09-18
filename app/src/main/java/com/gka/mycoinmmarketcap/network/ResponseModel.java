package com.gka.mycoinmmarketcap.network;

import java.util.List;

public class ResponseModel {

    private List<ItemModel> data;


    public List<ItemModel> getData() {
        return data;
    }

    public void setData(List<ItemModel> data) {
        this.data = data;
    }
}
