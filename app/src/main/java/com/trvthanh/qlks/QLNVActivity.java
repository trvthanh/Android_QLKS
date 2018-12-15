package com.trvthanh.qlks;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class QLNVActivity extends Activity {
    Database db ;
    ArrayList<NhanVien> allNV ;
    ListView listnv;
    Dialog dialog;
    TextView tvManv, tvTennv;
    Button btnthem;
    ArrayAdapter<NhanVien> arrayAdapter;
    public static final String MANV= "MaNV";
    public static final String TENNV = "TenNV";
    public static final String CMNDNV= "=CMNVNV";
    public static final String NGAYSINH = "NgaySinh";
    public static final String DIACHI = "DiaChi";
    public static final String SDTNV = "SdtNV";
    public static final String GIOITINH = "GioiTinhNV";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.qlnv_layout);
            db= new Database(getApplicationContext());

        allNV=new ArrayList<NhanVien>();

        allNV.addAll(db.getalldata());

       listnv = findViewById(R.id.lvnhanvien);
       btnthem = findViewById(R.id.btnThemNV);
        // arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, allPhong);
        arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,allNV);
        listnv.setAdapter(arrayAdapter);
        listnv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(QLNVActivity.this,Chitietnhanvien.class);
                intent.putExtra(MANV, allNV.get(position).getMaNV());
                intent.putExtra(TENNV, allNV.get(position).getTenNV());
                intent.putExtra(CMNDNV, allNV.get(position).getCMND().toString());
                intent.putExtra(NGAYSINH, allNV.get(position).getNgaySinh());
                intent.putExtra(DIACHI, allNV.get(position).getDiaChi());
                intent.putExtra(SDTNV, allNV.get(position).getSDT());
                intent.putExtra(GIOITINH, allNV.get(position).getGioiTinh());
                startActivity(intent);
            }
        });
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QLNVActivity.this,ThemNV.class);
                startActivity(intent);
            }
        });
    }
}
