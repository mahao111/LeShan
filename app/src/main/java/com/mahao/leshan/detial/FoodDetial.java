package com.mahao.leshan.detial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import com.mahao.leshan.R;

import java.util.ArrayList;

public class FoodDetial extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FoodDetialAdapter foodDetialAdapter;

    private ArrayList<FoodDetialItem> foodDetialItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detial);
        recyclerView = findViewById(R.id.food_detial_recyvlerview);
        foodDetialItems = new ArrayList<>();
        init();
        foodDetialAdapter = new FoodDetialAdapter(this, foodDetialItems);
        recyclerView.setAdapter(foodDetialAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        foodDetialAdapter.notifyDataSetChanged();
    }

    private void init() {
        Intent intent = getIntent();
        String foodname = intent.getStringExtra("foodname");



        switch (foodname) {
            case "豆腐脑":
             loadRes(R.array.contetn_Food_Detial_dfn_Item,R.array.image_Food_Detial_dfn_Iteam);

                break;
            case "甜皮鸭":
                loadRes(R.array.contetn_Food_Detial_tpy_Item,R.array.image_Food_Detial_tpy_Iteam);
                break;

            case "黄焖鸡":
                loadRes(R.array.contetn_Food_Detial_hmj_Item,R.array.image_Food_Detial_hmj_Iteam);
                break;
            case "麻辣烫":
                loadRes(R.array.contetn_Food_Detial_mlt_Item,R.array.image_Food_Detial_mlt_Iteam);
                break;



        }


    }
    private void  loadRes(int StringArrayId,int ImageArrayId){
        int title = 0;
        int money = 1;
        int address = 2;
        int time = 3;
        int phone = 4;
        String[] contentString = getResources().getStringArray(StringArrayId);
        TypedArray typedArray = getResources().obtainTypedArray(ImageArrayId);
        for (int i = 0; i < contentString.length; i++) {
            String[] content = contentString[i].split("\\^");
            foodDetialItems.add(new FoodDetialItem(content[title], content[money], content[address], content[time], content[phone], typedArray.getResourceId(i, 0)));
        }
        typedArray.recycle();
    }
}