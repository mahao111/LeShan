package com.mahao.leshan.register;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.mahao.leshan.R;
import com.mahao.leshan.login.Login;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Register extends AppCompatActivity {
    public static final int LAUNCH_SECOND_ACTIVITY = 3;
    OkHttpClient client = new OkHttpClient();
    private EditText register_name;
    private EditText register_phone;
    private EditText register_date;
    private  RadioGroup radioGroup_sex;
    private String name;
    private String phone;
    private String date;
    private String sex="male";
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register_name = findViewById(R.id.register_name);
        register_phone = findViewById(R.id.register_phone);
        register_date = findViewById(R.id.register_date);
        radioGroup_sex=findViewById(R.id.register_sex);
        radioGroup_sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.male:
                        sex="male";
                        return;
                    case R.id.female:
                        sex="female";
                        return;
                }
            }
        });

    }

    public void datePick(View view) {
        Intent intent = new Intent(this, DatePicker.class);
        this.startActivityForResult(intent, LAUNCH_SECOND_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == LAUNCH_SECOND_ACTIVITY) {
            if (resultCode == Activity.RESULT_OK) {
                String date = data.getStringExtra("date");
                register_date.setText(date);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }

    public void psotUser(View view) throws InterruptedException {
        getinfo();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    post();
                    backTologin();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }});
thread.start();





    }
    void backTologin(){
        Intent intent = new Intent();

        intent.putExtra("hehe","hehe");
        intent.putExtra("myid", id);
        setResult(RESULT_OK, intent);
        finish();
    }

    private void getinfo() {
        name=register_name.getText().toString();
        phone=register_phone.getText().toString();
        date=register_date.getText().toString();
    }

    public void post() throws IOException {
        //已html form 格式发起post（提交）请求
        RequestBody formBody = new FormBody.Builder()
                .add("name", name)
                .add("phone",phone)
                .add("birth",date)
                .add("sex",sex)
                .build();
        Request request = new Request.Builder()
                .url("http://192.144.231.121:8080/demo/add")
                .post(formBody)
                .build();
        try (Response response = client.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            id=response.body().string();

            Log.d("response",id);


        }
    }


}