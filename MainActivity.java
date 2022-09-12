package com.example.baitaptuan2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText loginId, loginPass;
    Button btnDangNhap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDangNhap = (Button)findViewById(R.id.btnDangKy);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(i);
            }
        });

        loginId = findViewById(R.id.loginId);
        loginPass = findViewById(R.id.loginPass);
        btnDangNhap = findViewById(R.id.btnDangNhap);
    }

    public int isLogin(String u, String p) {
        if (u.equals("admin") && p.equals("12345")) {
            return 1;
        }
        else {
            return 0;
        }
    }

    String strU, strP;
    public void checkLogin(View view) {
        strU = loginId.getText().toString();
        strP = loginPass.getText().toString();
        if (strU.isEmpty() || strP.isEmpty()) {
            Toast.makeText(getApplicationContext(), "U, P khong duoc de trong!"
            , Toast.LENGTH_LONG).show();
        }
        else {
            if (isLogin(strU,strP)>0) {
                Toast.makeText(getApplicationContext(), "login thanh cong"
                        , Toast.LENGTH_LONG).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(MainActivity.this, profile.class));
                    }
                }, 2000);
            }
            else {
                Toast.makeText(getApplicationContext(), "sai U, P"
                        , Toast.LENGTH_LONG).show();
            }
        }
    }

}