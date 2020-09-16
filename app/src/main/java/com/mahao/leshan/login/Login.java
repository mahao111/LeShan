package com.mahao.leshan.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mahao.leshan.MainActivity2;
import com.mahao.leshan.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Login extends AppCompatActivity {
    static String name=null;
    static String phone=null;
    TextView textView_name;
    TextView textView_password;
    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        textView_name = findViewById(R.id.login_name);
        textView_password = findViewById(R.id.login_password);
    }

    public void login(View view) {
        String s = textView_name.getText().toString();
        getUserInfo(s);
        String password = textView_password.getText().toString();
        if(phone==null){
            Toast.makeText(this,"没有此用户",Toast.LENGTH_SHORT).show();
        }
        else if (password.equals(phone)) {

            startActivity(new Intent(this, MainActivity2.class));
        }
        else{
            Toast.makeText(this,"账户或密码不对",Toast.LENGTH_SHORT).show();
        }

    }

    public String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {

            return response.body().string();
        }
    }

    public void getUserInfo(String id) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String s = Login.this.run("http://192.144.231.121:8080/demo/finduser?id=" + id);
                    JSONObject jsonObject = new JSONObject(s);
                    Login.name = (String) jsonObject.get("name");
                    Login.phone = (String) jsonObject.get("phone");

                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }
}