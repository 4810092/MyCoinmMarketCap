package com.gka.mycoinmmarketcap.network;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IAPI {

    @GET("v2/listings/")
    Observable<ResponseModel> getList();
}
