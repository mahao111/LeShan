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


public class FoodAdapter  extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<FoodItem> foodItems;
    public  FoodAdapter(Context context ,ArrayList<FoodItem> foodItems){
        this.context=context;
        this.foodItems=foodItems;
    }


    @NonNull
    @Override
    public FoodAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_food, parent, false);

        return new FoodAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.MyViewHolder holder, int position) {
                   holder.toBind();
    }

    @Override
    public int getItemCount() {
        return foodItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title_item_food;
        TextView sub_title_food;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title_item_food=  itemView.findViewById(R.id.title_item_food);
            sub_title_food= itemView.findViewById(R.id.sub_title_food);
          imageView=  itemView.findViewById(R.id.imageView_item_food);

        }
        public  void  toBind(){
            FoodItem foodItem = foodItems.get(getAdapterPosition());
            title_item_food.setText(foodItem.getTitle_food());
            sub_title_food.setText(foodItem.getSubtitle_food());
          //  imageView.setImageResource(foodItem.getImageRes());
            Glide.with(context).load(foodItem.getImageRes()).into(imageView);
        }
    }
}
