package com.trvthanh.qlks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QLPhongActivity extends Activity {
    private Button btnThemPhong;
    private ListView listPhong;
    private ArrayList<Phong> allPhong;
    private ArrayAdapter<Phong> arrayAdapter;
    Database db;

    public static final String MAPHONG = "MaPhong";
    public static final String LOAIPHONG = "LoaiPhhong";
    public static final String MOTA = "MoTa";
    public static final String GIA = "GiaPhong";
    public static final String TRANGTHAI = "TrangThai";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.qlphong_layout);

        db = new Database(getApplicationContext());
//
        btnThemPhong = (Button) findViewById(R.id.btnThemPhong);

        btnThemPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QLPhongActivity.this, ThemPhong.class);
                startActivity(intent);
            }
        });

        // Lay tat ca phong
        // Log.d("Lay Phong", "lay tat ca phong");

        allPhong = new ArrayList<>();
        allPhong.addAll(db.getAllPhong());

        listPhong = findViewById(R.id.listPhong);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, allPhong);
        listPhong.setAdapter(arrayAdapter);

        listPhong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Toast.makeText(getApplicationContext(),allPhong.get(position).getGia()+"",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(QLPhongActivity.this, ChiTietPhongActivity.class);
                intent.putExtra(MAPHONG, allPhong.get(position).getMaPhong());     //int
                intent.putExtra(LOAIPHONG, allPhong.get(position).getLoaiPhong()); //string
                intent.putExtra(MOTA, allPhong.get(position).getMoTa());           //string
                intent.putExtra(GIA, allPhong.get(position).getGia());             //int---ko lay dc mo ta 102 ne
                intent.putExtra(TRANGTHAI, allPhong.get(position).getTrangThai()); //string
                startActivity(intent);
            }
        });

    }
}
