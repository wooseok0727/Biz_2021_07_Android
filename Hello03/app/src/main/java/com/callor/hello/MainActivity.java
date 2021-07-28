package com.callor.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText input_userid = null;
    private TextInputEditText input_password = null;
    private TextInputEditText input_name = null;
    private TextInputEditText input_tel = null;
    private TextInputEditText input_addr = null;
    private Button btn_login = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_userid = findViewById(R.id.input_userid);
        input_password = findViewById(R.id.input_password);
        input_name = findViewById(R.id.input_name);
        input_tel = findViewById(R.id.input_tel);
        input_addr = findViewById(R.id.input_addr);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(view->{
            String userid = input_userid.getText().toString();
            String password = input_password.getText().toString();
            String name = input_name.getText().toString();
            String tel = input_tel.getText().toString();
            String addr = input_addr.getText().toString();

            String userid_pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

            if(userid.isEmpty()){
                input_userid.setError("아이디를 반드시 입력하세요");
                input_userid.setFocusable(true);
                return;
            } else if (!userid.matches(userid_pattern)){
                input_userid.setError("아이디 형식이 잘못됨");
                input_userid.setFocusable(true);
                return;
            }

            if(password.isEmpty()){
                input_password.setError("비밀번호를 입력하세요");
                input_password.setFocusable(true);
                return;
            } else if(name.isEmpty()){
                input_name.setError("이름을 입력하세요");
                input_name.setFocusable(true);
                return;
            } else if(tel.isEmpty()){
                input_tel.setError("전화번호를 입력하세요");
                input_tel.setFocusable(true);
                return;
            } else if(addr.isEmpty()){
                input_addr.setError("주소를 입력하세요");
                input_addr.setFocusable(true);
                return;
            }

            Intent login_intent = new Intent(MainActivity.this,LoginActivity.class);
            login_intent.putExtra("userid",userid);
            login_intent.putExtra("password",password);
            login_intent.putExtra("name",name);
            login_intent.putExtra("tel",tel);
            login_intent.putExtra("addr",addr);
            startActivity(login_intent);

        });
    }
}