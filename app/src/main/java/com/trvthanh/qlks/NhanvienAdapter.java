package com.trvthanh.qlks;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NhanvienAdapter extends ArrayAdapter<NhanVien> {

    public NhanvienAdapter(Context context, int resource) {
        super(context, resource);
    }

    Activity context = null;
    ArrayList<NhanVien> NVArray = null;
    int layoutId;

    public NhanvienAdapter(Activity context, int layoutId, ArrayList<NhanVien> arr) {
        super(context, layoutId, arr);
        this.context = context;
        this.layoutId = layoutId;
        this.NVArray = arr;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(layoutId, null);
        //chỉ là test thôi, bạn có thể bỏ If đi
        if (NVArray.size() > 0 && position >= 0) {
            //dòng lệnh lấy TextView ra để hiển thị Mã và tên lên
            final TextView tvmanv = (TextView)
                    view.findViewById(R.id.tvmanv);
            final TextView tvtennv = (TextView)
                    view.findViewById(R.id.tvname);

            //lấy ra phong thứ position
            final NhanVien nv = NVArray.get(position);
            //đưa thông tin lên TextView
            //emp.toString() sẽ trả về Id và Name
            tvmanv.setText(nv.getMaNV() + "");
            tvtennv.setText(nv.getTenNV());
            final ImageView imageView = view.findViewById(R.id.tvAvatar);
            if(nv.getGioiTinh().equals("nam")||nv.getGioiTinh().equals("Nam"))
            {
                imageView.setImageResource(R.drawable.nvnam);
            }else {
                imageView.setImageResource(R.drawable.nvnu);
            }
        }
            return view;

        }
    }
