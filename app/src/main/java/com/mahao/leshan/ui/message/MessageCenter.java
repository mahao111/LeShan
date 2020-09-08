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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mahao.leshan.R;

import java.util.ArrayList;

public class MessageCenter extends Fragment {

    private MessageCenterViewModel messageCenterViewModel;

    private ArrayList <Message> items;
    private  MessageAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        messageCenterViewModel =
                ViewModelProviders.of(this).get(MessageCenterViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        RecyclerView recyclerView
                = root.findViewById(R.id.message_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        items=new ArrayList<>();
        init();
        adapter=new MessageAdapter(getActivity(),items);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
        return root;
    }

    private void init() {

        String[] item = getActivity().getResources().getStringArray(R.array.item_message);
        for (int i=0;i<item.length;i++){
            String[] message = item[i].split("｜");
            items.add(new Message(message[0],message[1]));
        }

    }
}