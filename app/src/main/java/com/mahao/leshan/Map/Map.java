package com.mahao.leshan.Map;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.mahao.leshan.R;
import com.mahao.leshan.detial.TravleDetial;

public class Map extends AppCompatActivity {
private TextView location_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Intent intent = getIntent();
        String location_extra = intent.getStringExtra(TravleDetial.INTENT_EXTRA_ADDRESS);
        location_title=findViewById(R.id.map_text_location_title);
        location_title.setText(location_extra);
    }
}