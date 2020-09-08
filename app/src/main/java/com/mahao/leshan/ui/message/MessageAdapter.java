package com.mahao.leshan.ui.message;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mahao.leshan.R;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHodler> {

    private Context context;
    private ArrayList<Message> items;

    public MessageAdapter(Context context, ArrayList<Message> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_message, parent, false);
        return new MessageAdapter.MyViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHodler holder, int position) {
                        holder.bindto(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHodler extends RecyclerView.ViewHolder {


        private TextView textView_title;
        private TextView textView_text;
        private TextView textView_button;

        public MyViewHodler(@NonNull View itemView) {

            super(itemView);

            textView_title = itemView.findViewById(R.id.item_message_title);
            textView_text = itemView.findViewById(R.id.item_message_text);
            textView_button = itemView.findViewById(R.id.item_message_button);
        }
        void bindto(int posistion){
            Message message = items.get(posistion);
            String title = message.getTitle();
            String text = message.getText();
            textView_title.setText(title);
            textView_text.setText(text);

        }
    }
}
