package com.trvthanh.qlks;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ThemDichVuActivity extends AppCompatActivity {

    private EditText txtmadv;
    private EditText txttendv;
    private EditText txtmota;
    private Spinner cbxdvt;
    private EditText txtGia1;
    private Button btnthem;

    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_dich_vu);
        txtmadv= findViewById(R.id.txtmadv);
        txttendv= findViewById(R.id.txttendv);
        txtmota= findViewById(R.id.txtmota);
        cbxdvt= findViewById(R.id.cbxdvt);
        txtGia1=findViewById(R.id.txtgia);
        btnthem=findViewById(R.id.btnthem);

        db = new Database(getApplicationContext());

        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int madv=Integer.parseInt(txtmadv.getText().toString());
                String tendv=txttendv.getText().toString();
                String mota=txtmota.getText().toString();
                String dvt=(String) cbxdvt.getSelectedItem();
                int gia=Integer.parseInt(txtGia1.getText().toString());
                //them vao database
                DichVu dichVu =new DichVu(madv,tendv,mota,dvt,gia);
                db.createDV(dichVu);
                Toast.makeText(getApplicationContext(),"Added",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),QLDVActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed()
    {Intent intent = new Intent(ThemDichVuActivity.this, QLDVActivity.class);
        startActivity(intent);
        finish();}
}
