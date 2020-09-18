package com.mahao.leshan.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mahao.leshan.MainActivity2;
import com.mahao.leshan.R;
import com.mahao.leshan.domain.User;
import com.mahao.leshan.register.DatePicker;
import com.mahao.leshan.register.Register;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Login extends AppCompatActivity {
   public static User user=new User();

    TextView textView_name;
    TextView textView_password;
    OkHttpClient client = new OkHttpClient();
    public static final int REGISTER_ACTIVTIY = 2;



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
        if (user.getPhone() == null) {

        } else if (password.equals(user.getPhone())) {

            startActivity(new Intent(this, MainActivity2.class));
        } else {
            Toast.makeText(this, "账户或密码不对", Toast.LENGTH_SHORT).show();
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

                  String name=  (String) jsonObject.get("name");
                    String phone=  (String) jsonObject.get("phone");
                    String birth=  (String) jsonObject.get("birth");
                    String sex=  (String) jsonObject.get("sex");
                    Login.user.setName(name);
                    Login.user.setPhone(phone);
                    Login.user.setBirth(birth);
                    Login.user.setSex(sex);
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    public void regiser(View view) {

        Intent intent = new Intent(this, Register.class);
       this.startActivityForResult(intent, REGISTER_ACTIVTIY);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REGISTER_ACTIVTIY) {
            if (resultCode == RESULT_OK) {
                       //此处不能为ID 或id 否则无法取值
                String id = data.getStringExtra("myid");

            textView_name.setText(id);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result

            }
        }
    }
}