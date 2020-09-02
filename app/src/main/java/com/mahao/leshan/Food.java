package com.mahao.leshan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Food extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<FoodItem> foodItems;
    private FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        recyclerView = findViewById(R.id.recyclerveiw_food);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
         foodItems=new ArrayList<>();

         init();
        foodAdapter=  new FoodAdapter(this,foodItems);
        recyclerView.setAdapter(foodAdapter);
        foodAdapter.notifyDataSetChanged();

    }


    private void init() {
        String[] title_food = getResources().getStringArray(R.array.Title_food);
        String[] subtitl_food = getResources().getStringArray(R.array.subtitle_food);
        TypedArray imageRes = getResources().obtainTypedArray(R.array.imageResouce_food);
        for (int i=0;i<title_food.length;i++){
            foodItems.add(new FoodItem(title_food[i],subtitl_food[i],imageRes.getResourceId(i,0)));
        }
        for (int i=0;i<title_food.length;i++){
            foodItems.add(new FoodItem(title_food[i],subtitl_food[i],imageRes.getResourceId(i,0)));
        }
        for (int i=0;i<title_food.length;i++){
            foodItems.add(new FoodItem(title_food[i],subtitl_food[i],imageRes.getResourceId(i,0)));
        }
        imageRes.recycle();

    }


}