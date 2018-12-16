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

        txtMaPhong=(EditText) findViewById(R.id.txtMaPhonga);
        cbxLoaiPhong=(Spinner)findViewById(R.id.cbxLoaiPhong);
        cbxTrangThai=(Spinner)findViewById(R.id.cbxTrangThai);
        txtMoTa=(EditText)findViewById(R.id.txtMoTa);
        txtGia=(EditText)findViewById(R.id.txtGia);
        btnThem=(Button)findViewById(R.id.btnThemPhong);

        db=new Database(getApplicationContext());

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                allPhong = new ArrayList<Phong>();
                allPhong.addAll(db.getAllPhong());
                int flag=0;
                String m=txtMaPhong.getText().toString();
                for (int i=0;i<allPhong.size();i++)
                {
                    if(m.equals(allPhong.get(i).getMaPhong()+""))
                    {
                        Toast.makeText(getApplicationContext(),"Mã phòng đã tồn tại!",Toast.LENGTH_LONG).show();
                        flag=1;
                    }
                }
                if("".equals(txtMaPhong.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"Nhập mã phòng!",Toast.LENGTH_LONG).show();
                    flag=2;
                }
                if("".equals(txtGia.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"Nhập giá!",Toast.LENGTH_LONG).show();
                    flag=2;
                }
                if(flag==0)
                {
                    int mp=Integer.parseInt(txtMaPhong.getText().toString());
                    String lp=(String)cbxLoaiPhong.getSelectedItem();
                    String tt=(String)cbxTrangThai.getSelectedItem();
                    String mt=txtMoTa.getText().toString();
                    int g=Integer.parseInt(txtGia.getText().toString());
                    Phong phong=new Phong(mp,lp,mt,g,tt);
                    db.createPhong(phong);
                    Toast.makeText(getApplicationContext(),"Đã thêm !",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(ThemPhong.this,QLPhongActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
    @Override
    public void onBackPressed()
    {Intent intent = new Intent(ThemPhong.this, QLPhongActivity.class);
        startActivity(intent);
        finish();}
}
