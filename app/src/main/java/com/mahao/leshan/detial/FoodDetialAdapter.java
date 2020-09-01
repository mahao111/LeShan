package com.mahao.leshan.detial;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mahao.leshan.FoodAdapter;
import com.mahao.leshan.R;

import java.util.ArrayList;

public class FoodDetialAdapter extends RecyclerView.Adapter<FoodDetialAdapter.ViewHolder> {

    Context context;
    ArrayList<FoodDetialItem> foodDetialItems;

    public FoodDetialAdapter(Context context, ArrayList<FoodDetialItem> foodDetialItems) {
        this.context = context;
        this.foodDetialItems = foodDetialItems;
    }

    @NonNull
    @Override
    public FoodDetialAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_food_detial, parent, false);
        return new FoodDetialAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodDetialAdapter.ViewHolder holder, int position) {
                 holder.biandto();
    }

    @Override
    public int getItemCount() {
        return foodDetialItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titile;
        ImageView imageView;
        TextView money;
        TextView address_Textveiw;
        TextView phone_TextView;
        String address;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titile = itemView.findViewById(R.id.food_detial_titile_item);
            imageView = itemView.findViewById(R.id.food_detial_image_item);
            money = itemView.findViewById(R.id.food_detial_money_item);
            address_Textveiw = itemView.findViewById(R.id.food_detial_address_item);
            phone_TextView=itemView.findViewById(R.id.food_detial_contact_item);

        }

        public  void biandto(){
            int position = getAdapterPosition();
            FoodDetialItem item = foodDetialItems.get(position);

            String address = item.getAddress();
            String phone=item.getPhone();
            titile.setText(item.getTilte());
            Glide.with(context).load(item.getImageRes()).into(imageView);
            money.setText(item.getMoney());
            address_Textveiw.setText(address);



            phone_TextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+phone));
                    context.startActivity(intent);
                }
            });
            address_Textveiw.setOnClickListener((view)->{


                Intent i1 = new Intent(Intent.ACTION_VIEW);
// 地址解析
                i1.setData(Uri.parse("baidumap://map/geocoder?src=andr.baidu.openAPIdemo&address=" + address));

                if (address != null&&i1.resolveActivity(context.getPackageManager())!=null) {

                    context.startActivity(i1);
                }else{
                    Toast.makeText(context,"请安装Baidu地图",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
