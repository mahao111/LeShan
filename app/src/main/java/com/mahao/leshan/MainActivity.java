package com.mahao.leshan;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private static  final  String VIDEO_SAMPLE="tacoma_narrows";
    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mVideoView=findViewById(R.id.videoView);

    }

    @Override
    protected void onStart() {
        super.onStart();
        initializePlayer();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            mVideoView.pause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releasePlayer();
    }

    private Uri getMeida(String mdeiaName){
        return  Uri.parse("android.resource://"+getPackageName()+"/raw/"+mdeiaName);
    }
    private void initializePlayer(){
        Uri videoUri = getMeida(VIDEO_SAMPLE);
        mVideoView.setVideoURI(videoUri);
        mVideoView.start();

    }
    private  void releasePlayer(){
        mVideoView.stopPlayback();
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