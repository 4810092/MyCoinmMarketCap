package com.gka.mycoinmmarketcap;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gka.mycoinmmarketcap.network.ItemModel;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyVH> {


    private List<ItemModel> list;


    public MyAdapter(List<ItemModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH holder, int position) {
        holder.setData(list.get(position));
    }

    @Override
    public int getItemCount() {
        if (list == null) return 0;
        return list.size();
    }

    class MyVH extends RecyclerView.ViewHolder {


        TextView tvID;
        TextView tvName;
        TextView tvSymbol;
        TextView tvWebsite;

        MyVH(View itemView) {
            super(itemView);

            tvID = itemView.findViewById(R.id.item_id);
            tvName = itemView.findViewById(R.id.item_name);
            tvSymbol = itemView.findViewById(R.id.item_symbol);
            tvWebsite = itemView.findViewById(R.id.item_website);
        }

        public void setData(ItemModel itemModel) {
            tvID.setText(String.valueOf(itemModel.getId()));
            tvName.setText(itemModel.getName());
            tvSymbol.setText(itemModel.getSymbol());
            tvWebsite.setText(itemModel.getWebsite_slug());

        }
    }
}
