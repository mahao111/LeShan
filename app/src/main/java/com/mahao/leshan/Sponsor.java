package com.mahao.leshan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Sponsor extends AppCompatActivity {
private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsor);
        imageView=findViewById(R.id.qrImageView);
    }

    public void chooseZfb(View view) {
        imageView.setImageResource(R.drawable.zfbqr);
    }

    public void chooseWxZf(View view) {
        imageView.setImageResource(R.drawable.wxqr);
    }
}