package com.callor.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private TextView txt_login_msg = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txt_login_msg = findViewById(R.id.txt_login_msg);

        Intent intent = getIntent();

        String userid = intent.getExtras().getString("userid");
        String password = intent.getExtras().getString("password");
        String name = intent.getExtras().getString("name");
        String tel = intent.getExtras().getString("tel");
        String addr = intent.getExtras().getString("addr");

        String msg = String.format("아이디 : %s\n비밀번호 : %s\n이름 : %s\n전화번호 : %s\n주소 : %s",
                userid,password,name,tel,addr);

        txt_login_msg.setText(msg);

    }
}