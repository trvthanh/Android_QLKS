package com.trvthanh.qlks;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class chitietdv extends AppCompatActivity {
    private EditText txtmadv;
    private EditText txttendv;
    private EditText txtmota;
    private Spinner cbxdvt;
    private EditText txtGia1;
    private Button btnxoa;
    private Button btnsua;
    private List<String> listDichVu;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitietdv_activity);
        txtmadv= findViewById(R.id.txtmadv);
        txttendv= findViewById(R.id.txttendv);
        txtmota= findViewById(R.id.txtmota);
        cbxdvt= findViewById(R.id.cbxdvt);
        txtGia1=findViewById(R.id.txtgia);
        btnxoa=findViewById(R.id.btnxoa);
        btnsua = findViewById(R.id.btnsua);

        Intent intent = getIntent();
        DichVu dv = (DichVu) intent.getSerializableExtra("DichVu");

        txtmadv.setText(dv.getMaDV()+"");
        txttendv.setText(dv.getTenDV());
        txtmota.setText(dv.getMoTaDV());
        txtGia1.setText(dv.getGia()+"");

        listDichVu=new ArrayList<String >();
        listDichVu=Arrays.asList(getResources().getStringArray(R.array.DVT));
        int position1 = listDichVu.indexOf(dv.getDVT());
        cbxdvt.setSelection(position1);

        db = new Database(getApplicationContext());
        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                suKienXoaDichVu();
            }
        });

    }

    private void suKienXoaDichVu() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Xóa dịch vụ");
        builder.setMessage("Bạn có chắc muốn xóa dịch vụ này?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int madv=Integer.parseInt(txtmadv.getText().toString());
                db.deleteDichVu(madv);
                finish();
                Toast.makeText(chitietdv.this, "xóa thành công", Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }
}
