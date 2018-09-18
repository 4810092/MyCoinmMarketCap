package com.gka.mycoinmmarketcap.network;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {

    private IAPI iapi;

    public API() {
        iapi = getRetrofit().create(IAPI.class);

    }

    private static final String BASE_URL = "https://api.coinmarketcap.com/";

    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public Observable<ResponseModel> getList() {
        return iapi.getList();
    }
}
