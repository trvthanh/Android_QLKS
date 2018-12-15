package com.trvthanh.qlks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class ThemPhong extends Activity {
    private EditText txtMaPhong;
    private Spinner cbxLoaiPhong;
    private Spinner cbxTrangThai;
    private EditText txtMoTa;
    private  EditText txtGia;
    private Button btnThem;
    Database db;

    private ArrayList<Phong> allPhong=new ArrayList<Phong>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.them_phong_activity);

        txtMaPhong=(EditText) findViewById(R.id.txtMaPhong);
        cbxLoaiPhong=(Spinner)findViewById(R.id.cbxLoaiPhong);
        cbxTrangThai=(Spinner)findViewById(R.id.cbxTrangThai);
        txtMoTa=(EditText)findViewById(R.id.txtMoTa);
        txtGia=(EditText)findViewById(R.id.txtGia);
        btnThem=(Button)findViewById(R.id.btnThemPhong);

        db=new Database(getApplicationContext());

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                int mp=Integer.parseInt(txtMaPhong.getText().toString());
                String lp=(String)cbxLoaiPhong.getSelectedItem();
                String tt=(String)cbxTrangThai.getSelectedItem();
                String mt=txtMoTa.getText().toString();
                int g=Integer.parseInt(txtGia.getText().toString());

                allPhong = new ArrayList<Phong>();
                allPhong.addAll(db.getAllPhong());

                for (int i=0;i<allPhong.size();i++)
                {
                    if(mp==allPhong.get(i).getMaPhong())
                    {
                        Toast.makeText(getApplicationContext(),"Đã tồn tại!",Toast.LENGTH_LONG).show();
                        finish();
                    }
                }

               Phong phong=new Phong(mp,lp,mt,g,tt);
               db.createPhong(phong);
                Toast.makeText(getApplicationContext(),"Added",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(ThemPhong.this,QLPhongActivity.class);
                startActivity(intent);
            }
        });

    }
}
