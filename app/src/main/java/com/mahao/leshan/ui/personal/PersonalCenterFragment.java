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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mahao.leshan.R;
import com.mahao.leshan.login.Login;

import java.util.ArrayList;

public class PersonalCenterFragment extends Fragment {

    private PersonalCenterViewModel personalCenterViewModel;
    private ArrayList<Favoriat> favoriats=new ArrayList<>();
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

        fillDataToList();
        RecyclerView recyclerView = root.findViewById(R.id.person_center_favorite_recycerview);
        FavorateAdapter favorateAdapter = new FavorateAdapter(getActivity(), favoriats);
        recyclerView.setAdapter(favorateAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        personalCenterViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }

    private void fillDataToList() {
        for (int i=0;i<=40;i++){
        favoriats.add(new Favoriat("峨眉山 "));
        favoriats.add(new Favoriat("报国寺"));
        favoriats.add(new Favoriat("滑雪场"));
        favoriats.add(new Favoriat("雷洞坪"));
        favoriats.add(new Favoriat("天下名山"));}
    }
}