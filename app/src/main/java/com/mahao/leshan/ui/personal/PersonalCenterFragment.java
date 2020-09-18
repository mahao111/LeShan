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
import com.mahao.leshan.login.Login;

public class PersonalCenterFragment extends Fragment {

    private PersonalCenterViewModel personalCenterViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        personalCenterViewModel =
                ViewModelProviders.of(this).get(PersonalCenterViewModel.class);
        View root = inflater.inflate(R.layout.fragment_personal_center, container, false);

        TextView  personal_center_name = root.findViewById(R.id.personal_center_name);
        TextView  personal_center_birth =  root.findViewById(R.id.personal_center_birth);
        TextView  personal_center_sex =  root.findViewById(R.id.personal_center_sex);
        TextView  personal_center_phone =  root.findViewById(R.id.personal_center_phone);
        personal_center_name.setText(Login.user.getName());
        personal_center_birth.setText(Login.user.getBirth());
        if(Login.user.getSex().equals("male")){
            personal_center_sex.setText("男");
        }
        else {
            personal_center_sex.setText("女");
        }

        personal_center_phone.setText(Login.user.getPhone());

        personalCenterViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }
}