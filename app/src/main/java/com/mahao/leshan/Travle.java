package com.mahao.leshan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class Travle extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<TravleItem> items;
    private TravleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travle);
        recyclerView = findViewById(R.id.recycler_view_travle);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        items = new ArrayList<>();

        init();
        adapter = new TravleAdapter(this, items);
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();

    }


    private void init() {
        String[] title = getResources().getStringArray(R.array.Title);
        String[] subtitle = getResources().getStringArray(R.array.subtitle);
        TypedArray images = getResources().obtainTypedArray(R.array.imageResouce);
        items.clear();
        for (int i = 0; i < title.length; i++) {
            items.add(new TravleItem(title[i], "峨眉山", subtitle[i], images.getResourceId(i, 0)));

        }
        for (int i = 0; i < title.length; i++) {
            items.add(new TravleItem(title[i], "峨眉山", subtitle[i], images.getResourceId(i, 0)));

        }
        for (int i = 0; i < title.length; i++) {
            items.add(new TravleItem(title[i], "峨眉山", subtitle[i], images.getResourceId(i, 0)));

        }
        images.recycle();


    }
}