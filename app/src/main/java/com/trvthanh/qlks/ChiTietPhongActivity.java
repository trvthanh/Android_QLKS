package com.trvthanh.qlks;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChiTietPhongActivity extends Activity {
    private EditText txtMaPhong,txtMoTa, txtGia;
    private Spinner spnLoaiPhong,spnTrangThai;
    private Button bt,btnLuu,btnXoa;
    private List<String> listLoaiPhong,listTrangThai;
    Database db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.chi_tiet_phong_activity);
        db = new Database(getApplicationContext());


        bt = (Button) findViewById(R.id.btnSuaPhong);
        btnLuu=findViewById(R.id.btnLuu);
        btnXoa=findViewById(R.id.btnXoa);

        final Intent intent = getIntent();
        txtMaPhong =findViewById(R.id.txtMaPhong);
        txtMoTa = findViewById(R.id.txtMota);
        txtGia = findViewById(R.id.txtGia);

        spnLoaiPhong = findViewById(R.id.spnLoaiPhong);
        spnLoaiPhong.setEnabled(false);
        listLoaiPhong = new ArrayList<String>();
        listLoaiPhong = Arrays.asList(getResources().getStringArray(R.array.LoaiPhong));
        int position = listLoaiPhong.indexOf(intent.getStringExtra(QLPhongActivity.LOAIPHONG));
        spnLoaiPhong.setSelection(position);

        spnTrangThai=findViewById(R.id.spnTrangThai);
        listTrangThai=new ArrayList<String >();
        listTrangThai=Arrays.asList(getResources().getStringArray(R.array.TrangThai));
        int position1 = listTrangThai.indexOf(intent.getStringExtra(QLPhongActivity.TRANGTHAI));
        spnLoaiPhong.setSelection(position1);
        spnTrangThai.setEnabled(false);


        txtMaPhong.setText(intent.getIntExtra(QLPhongActivity.MAPHONG, 0) + "");
        txtMaPhong.setEnabled(false);
        txtMoTa.setText(intent.getStringExtra(QLPhongActivity.MOTA));
        txtMoTa.setEnabled(false);
        txtGia.setText(intent.getIntExtra(QLPhongActivity.GIA, 0) + "");
        txtGia.setEnabled(false);

        btnLuu.setEnabled(false);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spnLoaiPhong.setEnabled(true);
                spnTrangThai.setEnabled(true);
                txtGia.setEnabled(true);
                txtMaPhong.setEnabled(true);
                txtMoTa.setEnabled(true);
                bt.setEnabled(false);
                btnXoa.setEnabled(false);
                btnLuu.setEnabled(true);
               //
                //
                // Toast.makeText(getApplicationContext(), intent.getIntExtra(QLPhongActivity.MAPHONG, 0) + "", Toast.LENGTH_LONG).show();
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               dialogXoaPhong();
            }
        });
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deletePhong(intent.getIntExtra(QLPhongActivity.MAPHONG, 0));
                int mp=Integer.parseInt(txtMaPhong.getText().toString());
                int gia=Integer.parseInt(txtGia.getText().toString());
                Phong phong=new Phong(mp,spnLoaiPhong.getSelectedItem()+"",txtMoTa.getText()+"",gia,spnTrangThai.getSelectedItem()+"");
                Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_LONG).show();
                db.createPhong(phong);

                finish();

                Intent intent1=new Intent(ChiTietPhongActivity.this,QLPhongActivity.class);
                startActivity(intent1);
            }
        });
    }
    @Override
    public void onBackPressed()
    {Intent intent = new Intent(ChiTietPhongActivity.this, QLPhongActivity.class);
        startActivity(intent);
        finish();
    }
    private void dialogXoaPhong() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Xóa Phòng");
        builder.setMessage("Bạn muốn xóa phòng "+txtMaPhong.getText()+" ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int mp=Integer.parseInt(txtMaPhong.getText().toString());
                db.deletePhong(mp);
                Intent intent=new Intent(ChiTietPhongActivity.this,QLPhongActivity.class);
                startActivity(intent);
                Toast.makeText(ChiTietPhongActivity.this, "Đã Xóa !", Toast.LENGTH_SHORT).show();
                finish();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }
}
