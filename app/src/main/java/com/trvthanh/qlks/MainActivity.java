package com.trvthanh.qlks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.widget.Button;



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

    Database db;
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

        db=new Database(getApplicationContext());

        /*//Tao Phong
        Phong phong1=new Phong(101,"1GĐơn","Đây là mô tả Phòng 101",200000);
        Phong phong2=new Phong(102,"1GĐôi","Đây là mô tả Phòng 102",300000);

        //Them Phong vao bang
        long p1=db.createPhong(phong1);
        long p2=db.createPhong(phong2);
        if(p1>0 || p2> 0)
        {
            Toast.makeText(this,"Đã thêm vào csdl",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"Failllllllllllllll",Toast.LENGTH_LONG).show();
        }*/
        //Xử lí onClick cho các buttons
        btnCallActiPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,QLPhongActivity.class);
                startActivity(intent);
            }
        });
        btnCallActiDV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, QLDVActivity.class);
                startActivity(intent);
            }
        });
        btnCallActiKhach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,QLKhachActivity.class);
                startActivity(intent);
            }
        });
        btnCallActiNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,QLNVActivity.class);
                startActivity(intent);
            }
        });
    }
}
