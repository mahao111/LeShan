package com.mahao.leshan.ui.personal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mahao.leshan.R;

import java.util.ArrayList;

public class FavorateAdapter extends RecyclerView.Adapter<FavorateAdapter.MyViewHodler> {

    ArrayList<Favoriat> favoriats;
    Context context;

    public FavorateAdapter(Context context, ArrayList<Favoriat> favoriats) {
        this.favoriats = favoriats;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.person_center_favorite_recycerview_item, parent, false);

        return new FavorateAdapter.MyViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHodler holder, int position) {
        holder.location.setText(favoriats.get(position).getLocation());

    }

    @Override
    public int getItemCount() {
        return favoriats.size();
    }

    public class MyViewHodler extends RecyclerView.ViewHolder {
        TextView location;

        public MyViewHodler(@NonNull View itemView) {
            super(itemView);
            location = itemView.findViewById(R.id.person_center_favorite_recycerview_item_location);
        }
    }
}
