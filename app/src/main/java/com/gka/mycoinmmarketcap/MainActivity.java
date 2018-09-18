package com.gka.mycoinmmarketcap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gka.mycoinmmarketcap.network.API;
import com.gka.mycoinmmarketcap.network.ItemModel;
import com.gka.mycoinmmarketcap.network.ResponseModel;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    API api;


    RecyclerView rvList;
    View pb;

    LinearLayoutManager llm;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvList = findViewById(R.id.rvList);
        pb = findViewById(R.id.pb);


        api = new API();


        pb.setVisibility(View.VISIBLE);

        api.getList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {


                    }

                    @Override
                    public void onNext(ResponseModel response) {
                        setList(response.getData());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


    private void setList(List<ItemModel> data) {


        llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvList.setLayoutManager(llm);

        adapter = new MyAdapter(data);
        rvList.setAdapter(adapter);


        pb.setVisibility(View.GONE);

    }


}
