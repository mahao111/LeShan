package com.mahao.leshan.detial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        foodDetialItems=new ArrayList<>();
        init();
        foodDetialAdapter=  new FoodDetialAdapter(this, foodDetialItems);
        recyclerView.setAdapter(foodDetialAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        foodDetialAdapter.notifyDataSetChanged();
    }

    private void init() {
         int title=0;
         int money=1;
         int address=2;
         int time =3;
         int phone=4;
        String[] contentString = getResources().getStringArray(R.array.contetn_Food_Detial_Item);

        TypedArray typedArray = getResources().obtainTypedArray(R.array.image_Food_Detial_Iteam);
        for (int i=0;i<contentString.length;i++){
            String[] content = contentString[i].split("\\^");
            foodDetialItems.add(new FoodDetialItem(content[title],content[money],content[address],content[time],content[phone],typedArray.getResourceId(i,0)));
        }

        typedArray.recycle();
    }
}