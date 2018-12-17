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
import android.widget.Spinner;

import java.util.ArrayList;

public class QLDVActivity extends Activity {

    private Button btnthemdv;
    private Spinner spnDVT;
    private ListView listdv;
    private ArrayList<DichVu> allDichVu ;
    private dichvuAdapter arrayAdapter;
    Database db;

    public static final String MADV = "MaDichVu";
    public static final String TENDV = "TenDichVu";
    public static final String MOTA = "MoTa";
    public static final String DVT = "DichVuThue";
    public static final String GIA = "Gia";



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
                finish();
            }
        });



        //lay tat ca dich vu

        allDichVu = new ArrayList<>();
        allDichVu.addAll(db.getAllDichvu());

        listdv = findViewById(R.id.listdv);
        arrayAdapter = new dichvuAdapter(this, R.layout.activity_dichvu_adapter, allDichVu);
        listdv.setAdapter(arrayAdapter);

        /*spnDVT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                arrayAdapter.clear();
                arrayAdapter.addAll(db.getAllDV((String)spnDVT.getItemAtPosition(position)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/

        listdv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final DichVu dv = arrayAdapter.getItem(position);
                Intent intent = new Intent(QLDVActivity.this,chitietdv.class);
                intent.putExtra("DichVu",dv);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed()
    {Intent intent = new Intent(QLDVActivity.this, MainActivity.class);
        startActivity(intent);
        finish();}
}
