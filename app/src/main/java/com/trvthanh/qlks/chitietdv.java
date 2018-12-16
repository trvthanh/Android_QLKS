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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class chitietdv extends AppCompatActivity {
    private EditText txtmadv;
    private EditText txttendv;
    private EditText txtmota;
    private Spinner cbxdvt;
    private EditText txtGia1;
    private Button btnxoa,btnsua;
    private Button btnluu;


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
        btnluu = findViewById(R.id.btnluu);

        final Intent intent = getIntent();
        final DichVu dv = (DichVu) intent.getSerializableExtra("DichVu");

        txtmadv.setText(dv.getMaDV()+"");
        txtmadv.setEnabled(false);
        txttendv.setText(dv.getTenDV());
        txttendv.setEnabled(false);
        txtmota.setText(dv.getMoTaDV());
        txtmota.setEnabled(false);
        txtGia1.setText(dv.getGia()+"");
        txtGia1.setEnabled(false);

        listDichVu=new ArrayList<String >();
        listDichVu=Arrays.asList(getResources().getStringArray(R.array.DVT));
        int position1 = listDichVu.indexOf(dv.getDVT());
        cbxdvt.setSelection(position1);
        cbxdvt.setEnabled(false);

        db = new Database(getApplicationContext());
        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                suKienXoaDichVu();

            }
        });

        btnsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtmadv.setEnabled(true);
                txttendv.setEnabled(true);
                txtmota.setEnabled(true);
                cbxdvt.setEnabled(true);
                txtGia1.setEnabled(true);
                btnluu.setEnabled(true);
                btnsua.setEnabled(false);
                btnxoa.setEnabled(false);
            }
        });
        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteDichVu(dv.getMaDV());
                int madv = Integer.parseInt(txtmadv.getText().toString());
                int gia = Integer.parseInt(txtGia1.getText().toString());
                DichVu dichVu = new DichVu(madv, txttendv.getText()+"",txtmota.getText()+"",cbxdvt.getSelectedItem()+"",gia);
                Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
                db.createDV(dichVu);
                finish();

                Intent intent1 = new Intent(chitietdv.this,QLDVActivity.class);
                startActivity(intent1);
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
                Intent intent1 = new Intent(chitietdv.this, QLDVActivity.class);
                startActivity(intent1);
                finish();
                Toast.makeText(chitietdv.this,txtmadv.getText().toString() , Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }
    @Override
    public void onBackPressed()
    {Intent intent = new Intent(chitietdv.this, QLDVActivity.class);
        startActivity(intent);
        finish();}
}
