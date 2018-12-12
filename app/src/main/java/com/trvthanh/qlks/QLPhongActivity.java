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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.qlphong_layout);
        db = new Database(getApplicationContext());
        //Phong phong = new Phong(123, "abc", "hjhjhj", 10000);
        //db.createPhong(phong);
        btnThemPhong = (Button) findViewById(R.id.btnThemPhong);

        btnThemPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QLPhongActivity.this, ThemPhong.class);
                startActivity(intent);
            }
        });

        // Lay tat ca phong
        Log.d("Lay Phong", "lay tat ca phong");

        allPhong = new ArrayList<>();
        allPhong.addAll(db.getAllPhong());

        listPhong = findViewById(R.id.listPhong);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, allPhong);
        listPhong.setAdapter(arrayAdapter);

        listPhong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),allPhong.get(position).getMaPhong()+"",Toast.LENGTH_LONG).show();
            }
        });

    }
}
