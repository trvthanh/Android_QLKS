package com.trvthanh.qlks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class QLKhachActivity extends Activity {
    private Button btnXemDanhSachKhachHang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.qlkhach_layout);

        btnXemDanhSachKhachHang=(Button)findViewById(R.id.btnDanhSachKhachHang);
        btnXemDanhSachKhachHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(QLKhachActivity.this,XemDanhSachKhachHang.class);
                startActivity(intent);
            }
        });
    }
}
