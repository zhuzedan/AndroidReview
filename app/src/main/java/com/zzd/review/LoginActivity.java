package com.zzd.review;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText et_num,et_pwd;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_num = findViewById(R.id.et_num);
        et_pwd = findViewById(R.id.et_pwd);
        btn = findViewById(R.id.btn);
        String num = et_num.getText().toString();
        String pwd = et_pwd.getText().toString();
        SharedPreferences sp = getSharedPreferences("loginForm",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("num",num);
        editor.putString("pwd",pwd);
        editor.commit();
        Toast.makeText(this,"保存成功",Toast.LENGTH_LONG).show();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}