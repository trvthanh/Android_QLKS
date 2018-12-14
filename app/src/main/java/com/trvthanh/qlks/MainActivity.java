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

        db = new Database(getApplicationContext());

        //Tao Phong
        Phong phong1 = new Phong(101, "1GĐơn", "Đây là mô tả Phòng 101", 200000, "Còn trống");
        Phong phong2 = new Phong(102, "1GĐôi", "Đây là mô tả Phòng 102", 300000, "Còn trống");

        //Them Phong vao bang
        db.createPhong(phong1);
        db.createPhong(phong2);

        //Tao Dich vu
        DichVu dichVu1 = new DichVu(1, "Ăn Sáng", "Đây là mô tả dv ăn sáng", "Bữa", 50000);
        DichVu dichVu2 = new DichVu(2, "Ăn Trưa", "Đây là mô tả dv ăn trưa", "Bữa", 60000);

        db.createDV(dichVu1);
        db.createDV(dichVu2);

        //Tao Khach Hàng
        Khach khach1 = new Khach("123456789", "Phạm Đức Tính", "123 đường abc", "0963123621", "Nam");
        Khach khach2 = new Khach("095265489", "Nguyễn Lê Thanh Tuấn", "456 đường xyz", "05665561", "Nam");
        db.createKhach(khach1);
        db.createKhach(khach2);

        //tao Nhân viên
        Date d1 = new Date(1990,1,12);
        NhanVien nhanVien1 = new NhanVien(123, "Phạm Đức Tính", "566456545",d1, "123 đường abc", "0123456789", true);
        Date d2 = new Date(1990,8,5);
        NhanVien nhanVien2 = new NhanVien(132, "Nguyễn lê Thanh Tuấn", "963456545",d1, "456 đường abc", "09632561789", true);
        db.createNV(nhanVien1);
        db.createNV(nhanVien2);
        //Xử lí onClick cho các buttons
        btnCallActiPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QLPhongActivity.class);
                startActivity(intent);
            }
        });
        btnCallActiDV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QLDVActivity.class);
                startActivity(intent);
            }
        });
        btnCallActiKhach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QLKhachActivity.class);
                startActivity(intent);
            }
        });
        btnCallActiNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QLNVActivity.class);
                startActivity(intent);
            }
        });

    }
    public Date stringToDate(String[] args,String s)throws Exception
    {
        Date d1=new SimpleDateFormat("dd/MM/yyyy").parse(s);
        return d1;
    }

}

