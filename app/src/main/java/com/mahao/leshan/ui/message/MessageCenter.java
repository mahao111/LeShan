package com.mahao.leshan.ui.message;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.mahao.leshan.R;

public class MessageCenter extends Fragment {

    private MessageCenterViewModel messageCenterViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        messageCenterViewModel =
                ViewModelProviders.of(this).get(MessageCenterViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        messageCenterViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }
}