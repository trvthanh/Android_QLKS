package com.trvthanh.qlks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.widget.Button;


import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


public class MainActivity extends Activity {
    //Khai bao biến buttons
    private Button btnCallActiPhong;
    private Button btnCallActiDV;
    private Button btnCallActiKhach;
    private Button btnCallActiNV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //gán biến buttons theo í các bttons có trong acti
        btnCallActiPhong = (Button) findViewById(R.id.btnPhong);
        btnCallActiDV = (Button) findViewById(R.id.btnDichVu);
        btnCallActiKhach = (Button) findViewById(R.id.btnKhach);
        btnCallActiNV = (Button) findViewById(R.id.btnNhanVien);


        //Xử lí onClick cho các buttons
        btnCallActiPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QLPhongActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnCallActiDV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QLDVActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnCallActiKhach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QLKhachActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnCallActiNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QLNVActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }


}

