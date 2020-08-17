package com.mahao.leshan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchFoodActivity(View view) {

        Intent intent = new Intent(this, Food.class);
        startActivity(intent);
    }

    public void launchTravleActivtiy(View view) {
        Intent intent = new Intent(this, Travle.class);
        startActivity(intent);
    }
}