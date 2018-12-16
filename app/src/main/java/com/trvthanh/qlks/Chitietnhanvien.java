package com.trvthanh.qlks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Chitietnhanvien extends AppCompatActivity {
    EditText edsuaMaNV, edsuaTenNV,edsuaCMND,edsuaNS,edsuaDC,edSDT,edGT;
    Button btnsua,btnXoa,btnCapnhat;
    Database db;
    private ArrayList<NhanVien> allNV=new ArrayList<NhanVien>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.chitietnhanvien_layout);
        db = new Database(getApplicationContext());
        final Intent intent = getIntent();
        edsuaMaNV = (EditText) findViewById(R.id.edsuaMaNV);

        edsuaTenNV = (EditText)findViewById(R.id.edsuaTenNV);

        edsuaCMND = (EditText)findViewById(R.id.edsuaCMND);

        edsuaNS = (EditText)findViewById(R.id.edsuaNS);

        edsuaDC = (EditText)findViewById(R.id.edsuaDC);

        edSDT = (EditText)findViewById(R.id.edsuaSDT);

        edGT = (EditText)findViewById(R.id.edsuaGT);
        btnCapnhat = findViewById(R.id.btnCapnhatNV);
        btnsua = findViewById(R.id.btnSuaNV);
        btnXoa = findViewById(R.id.btnXoaNV);

       // Toast.makeText(getApplicationContext(),intent.getStringExtra(QLNVActivity.TENNV),Toast.LENGTH_LONG).show();
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

        btnCapnhat.setEnabled(false);

        btnsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edsuaMaNV.setEnabled(true);
                edsuaTenNV.setEnabled(true);
                edsuaCMND.setEnabled(true);
                edsuaNS.setEnabled(true);
                edsuaDC.setEnabled(true);
                edSDT.setEnabled(true);
                edGT.setEnabled(true);
                btnsua.setEnabled(false);
                btnCapnhat.setEnabled(true);
                btnXoa.setEnabled(false);
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               db.deleteNV(Integer.parseInt(edsuaMaNV.getText().toString()));
                Toast.makeText(getApplicationContext(),"Đã xóa !",Toast.LENGTH_LONG).show();
                finish();
                Intent intent1 = new Intent(Chitietnhanvien.this,QLNVActivity.class);
                startActivity(intent1);
                finish();
            }
        });
        btnCapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteNV(intent.getIntExtra(QLNVActivity.MANV,0));
                int manv=Integer.parseInt(edsuaMaNV.getText().toString());
                String tennv=edsuaTenNV.getText().toString();
                String cmnd=edsuaCMND.getText().toString();
                String ns=edsuaNS.getText().toString();
                String dc=edsuaDC.getText().toString();
                String sdt=edSDT.getText().toString();
                String gt=edGT.getText().toString();

                NhanVien nv = new NhanVien(manv,tennv,cmnd,ns,dc,sdt,gt);
                db.createNV(nv);
                Toast.makeText(getApplicationContext(),"Đã sửa !",Toast.LENGTH_LONG).show();
                db.createNV(nv);
                finish();
                Intent intent1=new Intent(Chitietnhanvien.this,QLNVActivity.class);
                startActivity(intent1);
                finish();
            }
        });
    }
    @Override
    public  void onBackPressed()
    {
        Intent intent = new Intent(Chitietnhanvien.this,QLNVActivity.class);
        startActivity(intent);
        finish();
    }
}
