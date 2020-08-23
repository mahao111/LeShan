package com.mahao.leshan.detial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.mahao.leshan.R;

public class TravleDetial extends AppCompatActivity {
private ImageView imageView;
private TextView title_deltail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travle_detial);
        imageView=findViewById(R.id.imageView_detail);
        title_deltail=findViewById(R.id.title_detail);
        postponeEnterTransition();
        Intent intent = getIntent();
        int imageRes = intent.getIntExtra("imageRes", 0);
        String title = intent.getStringExtra("title");
        Glide.with(TravleDetial.this).load(imageRes).into(new GlideDrawableImageViewTarget(imageView){
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> animation) {
                super.onResourceReady(resource, animation);
                startPostponedEnterTransition();
            }
        });
        title_deltail.setText(title);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        supportFinishAfterTransition();
    }
}