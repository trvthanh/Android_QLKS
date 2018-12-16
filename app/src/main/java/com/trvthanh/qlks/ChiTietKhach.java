package com.trvthanh.qlks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class ChiTietKhach extends AppCompatActivity {
    Database db;
    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;
    EditText et5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chi_tiet_khach);

        //chi tiet khach
        final Intent intent=getIntent();
        et1=(EditText)findViewById(R.id.edittext1);
        et2=(EditText)findViewById(R.id.edittext2);
        et3=(EditText)findViewById(R.id.edittext3);
        et4=(EditText)findViewById(R.id.edittext4);
        et5=(EditText)findViewById(R.id.edittext5);

        et1.setText(intent.getStringExtra(QLKhachActivity.CMNDKH));
        et2.setText(intent.getStringExtra(QLKhachActivity.TENKH));
        et3.setText(intent.getStringExtra(QLKhachActivity.DCKH));
        et4.setText(intent.getStringExtra(QLKhachActivity.SDTKH));
        et5.setText(intent.getStringExtra(QLKhachActivity.GIOITINHKH));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }
    //sư kien khi click update va xoa
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);
        db=new Database(getApplicationContext());
        final Intent intent=getIntent();
        switch (item.getItemId()){
            case R.id.update:
                db.XoaKhach(intent.getStringExtra(QLKhachActivity.CMNDKH));
                String cmnd=et1.getText().toString();
                String hoten=et2.getText().toString();
                String diachi=et3.getText().toString();
                String sdt=et4.getText().toString();
                String gioitinh=et5.getText().toString();
                Khach khach=new Khach(cmnd,hoten,diachi,sdt,gioitinh);
                db.createKhach(khach);
                Intent intent1=new Intent(ChiTietKhach.this,QLKhachActivity.class);
                startActivity(intent1);
                Toast.makeText(getApplicationContext(), "Cập Nhật Thành Công", Toast.LENGTH_SHORT).show();
                break;
            case R.id.xoa:
                db.XoaKhach(intent.getStringExtra(QLKhachActivity.CMNDKH));
                Toast.makeText(getApplicationContext(), "Xóa Thành Công", Toast.LENGTH_SHORT).show();
                Intent intent2=new Intent(ChiTietKhach.this,QLKhachActivity.class);
                startActivity(intent2);
                break;
        }
        return true;
    }
}
