package com.trvthanh.qlks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Chitietnhanvien extends AppCompatActivity {
    EditText edsuaMaNV, edsuaTenNV,edsuaCMND,edsuaNS,edsuaDC,edSDT,edGT;
    Button btnsua,btnXoa,btnCapnhat;
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.chitietnhanvien_layout);

        final Intent intent =getIntent();
        edsuaMaNV = (EditText) findViewById(R.id.edsuaMaNV);

        edsuaTenNV = (EditText)findViewById(R.id.edsuaTenNV);

        edsuaCMND = (EditText)findViewById(R.id.edsuaCMND);

        edsuaNS = (EditText)findViewById(R.id.edsuaNS);

        edsuaDC = (EditText)findViewById(R.id.edsuaDC);

        edSDT = (EditText)findViewById(R.id.edsuaSDT);

        edGT = (EditText)findViewById(R.id.edsuaGT);

        Toast.makeText(getApplicationContext(),intent.getStringExtra(QLNVActivity.TENNV),Toast.LENGTH_LONG).show();
        edsuaMaNV.setText(intent.getIntExtra(QLNVActivity.MANV,0)+"");
        edsuaMaNV.setEnabled(false);
        edsuaTenNV.setText(intent.getStringExtra(QLNVActivity.TENNV));
        edsuaTenNV.setEnabled(false);
        edsuaCMND.setText(intent.getStringExtra(QLNVActivity.CMNDNV)+"");
        edsuaCMND.setEnabled(false);
        edsuaNS.setText(intent.getStringExtra(QLNVActivity.NGAYSINH));
        edsuaNS.setEnabled(false);
        edsuaDC.setText(intent.getStringExtra(QLNVActivity.DIACHI));
        edsuaDC.setEnabled(false);
        edSDT.setText(intent.getStringExtra(QLNVActivity.SDTNV));
        edSDT.setEnabled(false);
        edGT.setText(intent.getStringExtra(QLNVActivity.GIOITINH));
        edGT.setEnabled(false);

    }
}
