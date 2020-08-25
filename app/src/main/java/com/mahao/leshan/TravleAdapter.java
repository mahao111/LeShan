package com.mahao.leshan;


import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mahao.leshan.detial.TravleDetial;

import java.util.ArrayList;

public class TravleAdapter extends RecyclerView.Adapter<TravleAdapter.MyViewHodler> {
    private ArrayList<TravleItem> items;
    private Context context;

    public TravleAdapter(Context context, ArrayList<TravleItem> items) {
        this.context = context;
        this.items = items;

    }

    @NonNull
    @Override
    public TravleAdapter.MyViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType)  {

        View view = LayoutInflater.from(context).inflate(R.layout.item_travle, parent, false);
        return new TravleAdapter.MyViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TravleAdapter.MyViewHodler holder, int position) {
        TravleItem travleItem = items.get(position);

        holder.bindTo(travleItem);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHodler extends RecyclerView.ViewHolder  implements View.OnClickListener {
        private TextView title;
        private TextView addres;
        private TextView subTitle;
        private ImageView imageView;

        public MyViewHodler(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_detail);
            addres = itemView.findViewById(R.id.addres_detail);
            subTitle = itemView.findViewById(R.id.subTitle);
            imageView=itemView.findViewById(R.id.imageView_detail);
            itemView.setOnClickListener(this);
        }

        void bindTo(TravleItem travleItem) {
            String address = travleItem.getAddress();
            if (address.contains("峨眉山")){
                addres.setText("峨眉山");
            }
title.setText(travleItem.getTitle());
            subTitle.setText(travleItem.getSubTitle());
           // imageView.setImageResource(travleItem.getImagesResource());
            Glide.with(context).load(travleItem.getImagesResource()).into(imageView);


        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, TravleDetial.class);
            TravleItem travleItem = items.get(getAdapterPosition());
            intent.putExtra("imageRes",travleItem.getImagesResource());
            intent.putExtra("title",travleItem.getTitle());
            intent.putExtra("address",travleItem.getAddress());
            context.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation((Activity) context,
                    new Pair<View, String>(imageView,"travle_image_transition"),
                    new Pair<View, String>(title,"title_travle_transition"),
                    new Pair<View, String>(subTitle,"travle_subtitle_transistion"),
                    new Pair<View, String>(addres,"travle_addres_transition")
            ).toBundle());
        }
    }
}
