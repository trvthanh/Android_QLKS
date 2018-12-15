package com.trvthanh.qlks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class ChiTietKhach extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chi_tiet_khach);

        final Intent intent=getIntent();
        EditText et1=(EditText)findViewById(R.id.edittext1);
        EditText et2=(EditText)findViewById(R.id.edittext2);
        EditText et3=(EditText)findViewById(R.id.edittext3);
        EditText et4=(EditText)findViewById(R.id.edittext4);
        EditText et5=(EditText)findViewById(R.id.edittext5);


        et1.setText(intent.getStringExtra(QLKhachActivity.CMNDKH));
        et2.setText(intent.getStringExtra(QLKhachActivity.TENKH));
        et3.setText(intent.getStringExtra(QLKhachActivity.DCKH));
        et4.setText(intent.getStringExtra(QLKhachActivity.SDTKH));
        et5.setText(intent.getStringExtra(QLKhachActivity.GIOITINHKH));
    }
}
