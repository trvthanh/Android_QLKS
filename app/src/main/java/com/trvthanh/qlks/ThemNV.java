package com.trvthanh.qlks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ThemNV extends AppCompatActivity {
    Database db;
    TextView tvthemMaNV,tvthemTenNV;
    EditText etthemManv,etthemTennv,etthemcmnd,etthemNS,etthemDC,etthemSDT,etthemGT;
    Button btnthemNV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nv);
        db=new Database(getApplicationContext());
        tvthemMaNV = (TextView)findViewById(R.id.tvthemManv);
        tvthemTenNV = (TextView)findViewById(R.id.tvthemTen);
        etthemManv = findViewById(R.id.edthemMaNV);
        etthemTennv = findViewById(R.id.edthemTenNV);
        etthemcmnd = findViewById(R.id.edthemCMND);
        etthemNS = findViewById(R.id.edthemNS);
        etthemDC = findViewById(R.id.edthemDC);
        etthemSDT = findViewById(R.id.edthemSDT);
        etthemGT = findViewById(R.id.edthemGT);
        btnthemNV = findViewById(R.id.btnThemNVMOI);

        btnthemNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int manv=Integer.parseInt(etthemManv.getText().toString());
                String tennv=etthemManv.getText().toString();
                String cmnd=etthemcmnd.getText().toString();
                String ns=etthemNS.getText().toString();
                String dc=etthemDC.getText().toString();
                String sdt=etthemSDT.getText().toString();
                String gt=etthemGT.getText().toString();
                NhanVien nv = new NhanVien(manv,tennv,cmnd,ns,dc,sdt,gt);
                db.createNV(nv);
                Toast.makeText(getApplicationContext(),"Added",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(ThemNV.this,QLNVActivity.class);
                startActivity(intent);
            }
        });
    }
}
