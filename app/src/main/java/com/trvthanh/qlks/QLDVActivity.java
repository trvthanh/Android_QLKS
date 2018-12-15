package com.trvthanh.qlks;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

import java.util.ArrayList;

public class QLDVActivity extends Activity {

    private Button btnthemdv;
    private ListView listdv;
    private ArrayList<DichVu> allDichVu;
    private ArrayAdapter<DichVu> arrayAdapter;

    public static final String MADV = "MaDichVu";
    public static final String TENDV = "TenDichVu";
    public static final String MOTA = "MoTa";
    public static final String DVT = "DichVuThue";
    public static final String GIA = "Gia";

    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.qldv_layout);

        db = new Database(getApplicationContext());
        btnthemdv = (Button) findViewById(R.id.btnthemdv);
        btnthemdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QLDVActivity.this, ThemDichVuActivity.class);
                startActivity(intent);
            }
        });

        //lay tat ca dich vu

        allDichVu = new ArrayList<>();
        allDichVu.addAll(db.getAllDichvu());

        listdv = findViewById(R.id.listdv);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, allDichVu);
        listdv.setAdapter(arrayAdapter);

        listdv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final DichVu dv = arrayAdapter.getItem(position);
                Intent intent = new Intent(QLDVActivity.this,chitietdv.class);
                intent.putExtra("DichVu",dv);
                startActivity(intent);
            }
        });
    }

}
