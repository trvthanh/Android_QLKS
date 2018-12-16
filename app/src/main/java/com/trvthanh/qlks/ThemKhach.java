package com.trvthanh.qlks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class ThemKhach extends AppCompatActivity {

    private Button buttonSave;
    private EditText et11;
    private EditText et22;
    private EditText et33;
    private EditText et44;
    private EditText et55;
    Database db;
    private ArrayList<Khach> tatcakhach=new ArrayList<Khach>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.them_khach);

        db=new Database(getApplicationContext());

        buttonSave=(Button)findViewById(R.id.buttonsave);
        et11=(EditText)findViewById(R.id.edittext11);
        et22=(EditText)findViewById(R.id.edittext22);
        et33=(EditText)findViewById(R.id.edittext33);
        et44=(EditText)findViewById(R.id.edittext44);
        et55=(EditText)findViewById(R.id.edittext55);
        //them 1 khach
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cmnd=et11.getText().toString();
                String hoten=et22.getText().toString();
                String diachi=et33.getText().toString();
                String sdt=et44.getText().toString();
                String gioitinh=et55.getText().toString();
                tatcakhach.addAll(db.LayKhach());


                Khach khach=new Khach(cmnd,hoten,diachi,sdt,gioitinh);
                db.createKhach(khach);
                Intent intent=new Intent(ThemKhach.this,QLKhachActivity.class);
                startActivity(intent);
            }
        });
    }
}
