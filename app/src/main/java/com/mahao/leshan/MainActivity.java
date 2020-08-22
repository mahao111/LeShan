package com.mahao.leshan;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void launchFoodActivity(View view) {

        Intent intent = new Intent(this, Food.class);
        startActivity(intent);
    }

    public void launchTravleActivtiy(View view) {
        Intent intent = new Intent(this, Travle.class);
        startActivity(intent);
    }
}