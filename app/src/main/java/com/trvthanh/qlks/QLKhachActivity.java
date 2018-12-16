package com.trvthanh.qlks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class QLKhachActivity extends Activity {
    private ArrayList<Khach> Laykhach;
    Database db;
    private ListView lv;
    private ArrayAdapter<Khach> Adapter;
    private Button Buttonthem;

    public static final String CMNDKH   = "CMNDKhachHang";
    public static final String TENKH = "TenKH";
    public static final String DCKH = "DiaChiKH";
    public static final String SDTKH = "SDTKH";
    public static final String GIOITINHKH = "GioiTinhKH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.qlkhach_layout);

        //lay tat ca khach

        db=new Database(getApplicationContext());
        Laykhach=new ArrayList<Khach>();
        Laykhach.addAll(db.LayKhach());
        lv=(ListView)findViewById(R.id.listview1);
        Adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Laykhach);
        lv.setAdapter(Adapter);
        //Toast.makeText(getApplicationContext(),Laykhach.size()+"",Toast.LENGTH_LONG).show();

        //truyen du lieu vao CMNDKH, TENKH....
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(QLKhachActivity.this,ChiTietKhach.class);
                intent.putExtra(CMNDKH,Laykhach.get(position).getCMND());
                intent.putExtra(TENKH, Laykhach.get(position).getTen());
                intent.putExtra(DCKH, Laykhach.get(position).getDiaChi());
                intent.putExtra(SDTKH, Laykhach.get(position).getSDT());
                intent.putExtra(GIOITINHKH, Laykhach.get(position).getGioiTinh());
                startActivity(intent);
                finish();
            }
        });
        //button them
        Buttonthem=(Button)findViewById(R.id.buttonthem);
        Buttonthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(QLKhachActivity.this,ThemKhach.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed()
    {Intent intent = new Intent(QLKhachActivity.this, MainActivity.class);
        startActivity(intent);
        finish();}
}
