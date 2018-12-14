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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.qlkhach_layout);


        //lay tat ca khach

        db=new Database(getApplicationContext());
        Laykhach=new ArrayList<>();
        Laykhach.addAll(db.LayKhach());
        lv=(ListView)findViewById(R.id.listview1);
        Adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Laykhach);
        lv.setAdapter(Adapter);
        Toast.makeText(getApplicationContext(),Laykhach.size()+"",Toast.LENGTH_LONG).show();


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),Laykhach.get(position).getCMND()+"",Toast.LENGTH_LONG).show();;
            }
        });
    }
}
