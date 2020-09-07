package com.mahao.leshan.ui.personal;

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

public class PersonalCenterFragment extends Fragment {

    private PersonalCenterViewModel personalCenterViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        personalCenterViewModel =
                ViewModelProviders.of(this).get(PersonalCenterViewModel.class);
        View root = inflater.inflate(R.layout.fragment_personal_center, container, false);

        personalCenterViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }
}