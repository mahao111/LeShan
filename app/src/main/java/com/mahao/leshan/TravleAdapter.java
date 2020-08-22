package com.mahao.leshan;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

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
    public TravleAdapter.MyViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

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

    public class MyViewHodler extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView addres;
        private TextView subTitle;
        private ImageView imageView;

        public MyViewHodler(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            addres = itemView.findViewById(R.id.addres);
            subTitle = itemView.findViewById(R.id.subTitle);
            imageView=itemView.findViewById(R.id.imageView_item);
        }

        void bindTo(TravleItem travleItem) {
            title.setText(travleItem.getTitle());
            addres.setText(travleItem.getAddress());
            subTitle.setText(travleItem.getSubTitle());
           // imageView.setImageResource(travleItem.getImagesResource());
            Glide.with(context).load(travleItem.getImagesResource()).into(imageView);

        }

    }
}
