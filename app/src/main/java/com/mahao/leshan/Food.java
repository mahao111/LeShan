package com.mahao.leshan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Food extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
    }

    public void launchIntroduce(View view) {
        //Intent intent = new Intent(this, introduce.class);
        //startActivity(intent);
    }
}