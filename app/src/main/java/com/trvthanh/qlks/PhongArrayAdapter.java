package com.trvthanh.qlks;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PhongArrayAdapter extends ArrayAdapter<Phong> {

    private int xanh = Color.GREEN;
    Activity context;
    int resource;
    List<Phong> objects;

    public PhongArrayAdapter(Activity context, int resource, List<Phong> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(this.resource, null);

        //dòng lệnh lấy TextView ra để hiển thị Mã và tên lên
        final TextView txtmaphong =
                view.findViewById(R.id.txtMaPhong);
        final TextView txtLoaiPhong = (TextView)
                view.findViewById(R.id.txtLoaiPhong);
        final TextView txtTrangThai = (TextView)
                view.findViewById(R.id.txtTrangThai);
        final TextView txtgia = (TextView)
                view.findViewById(R.id.txtGia);
        //lấy ra phong thứ position
        final Phong p = this.objects.get(position);
        //đưa thông tin lên TextView
        //emp.toString() sẽ trả về Id và Name
        txtmaphong.setText("Phòng: "+p.toString());
        txtLoaiPhong.setText(p.getLoaiPhong());
        txtTrangThai.setText(p.getTrangThai());
        txtgia.setText(p.getGia() + " vnđ" +
                "" +
                " " +
                "" +
                "" +
                "");

        if (p.getTrangThai().equals("Còn trống")) {
            txtTrangThai.setTextColor(Color.GREEN);
        }else {
            if(p.getTrangThai().equals("Đã thuê"))
            { txtTrangThai.setTextColor(Color.RED);}
        }

        final ImageView imgitem = view.findViewById(R.id.imgitem);
        if (p.getLoaiPhong().equals("1GĐơn")) {
            imgitem.setImageResource(R.drawable.motgdon);
        }else
        {
            if(p.getLoaiPhong().equals("2GĐơn"))
            {
                imgitem.setImageResource(R.drawable.haigdon);
            }
            else
            {if(p.getLoaiPhong().equals("1GĐôi"))
            {
                imgitem.setImageResource(R.drawable.motgdoi);
            }
            else
                {
                    imgitem.setImageResource(R.drawable.haigdoi);
                }
            }
        }
        return view;
    }
}

