package com.mahao.leshan.detial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import com.mahao.leshan.R;

public class TravleDetial extends AppCompatActivity {
    private ImageView imageView;
    private TextView title_deltail;
    private TextView address_detial;
    String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travle_detial);
        imageView = findViewById(R.id.imageView_detail);
        title_deltail = findViewById(R.id.title_detail);
        address_detial = findViewById(R.id.addres_detail);
        postponeEnterTransition();
        Intent intent = getIntent();
        int imageRes = intent.getIntExtra("imageRes", 0);
        String title = intent.getStringExtra("title");
        address = intent.getStringExtra("address");

        Glide.with(TravleDetial.this).load(imageRes).into(new GlideDrawableImageViewTarget(imageView) {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> animation) {
                super.onResourceReady(resource, animation);
                startPostponedEnterTransition();
            }
        });
        title_deltail.setText(title);
        address_detial.setText(address);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        supportFinishAfterTransition();
    }

    public void luanchMap(View view) {

        Intent i1 = new Intent(Intent.ACTION_VIEW);
// 地址解析
        i1.setData(Uri.parse("baidumap://map/geocoder?src=andr.baidu.openAPIdemo&address=" + address));

        if (address != null&&i1.resolveActivity(getPackageManager())!=null) {

            startActivity(i1);
        }else{
            Toast.makeText(this,"请安装Baidu地图",Toast.LENGTH_SHORT).show();
        }
    }
}