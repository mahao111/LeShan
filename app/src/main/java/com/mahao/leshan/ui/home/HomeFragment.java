package com.mahao.leshan.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.snackbar.Snackbar;
import com.mahao.leshan.Food;
import com.mahao.leshan.R;
import com.mahao.leshan.Travle;

public class HomeFragment extends Fragment {
    private static  final  String VIDEO_SAMPLE="tacoma_narrows";
    private HomeViewModel homeViewModel;

    private VideoView mVideoView;
    @Nullable

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button button_food =(Button) getActivity().findViewById(R.id.click_button_food);
        Button button_travle=(Button) getActivity().findViewById(R.id.button_travel);
         mVideoView = getActivity().findViewById(R.id.videoView);

        button_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Food.class));
            }
        });
        button_travle.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        //startActivity(new Intent(getActivity(), Travle.class));
              }
                }
        );
    }

    @Override
    public void onStart() {
        super.onStart();
       initializePlayer();
    }

    private  Uri getMedia(String  mdeiaName){
        return  Uri.parse(("android.resource://"+getActivity().getPackageName()+"/raw/"+mdeiaName));
    }
    private void initializePlayer() {
        Uri mediaUri = getMedia(VIDEO_SAMPLE);

        mVideoView.setVideoURI(mediaUri);
        mVideoView.start();

    }
}