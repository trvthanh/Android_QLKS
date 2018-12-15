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

public class PhongArrayAdapter extends ArrayAdapter<Phong>{

    private int xanh = Color.GREEN;



    public PhongArrayAdapter(Context context, int resource) {
        super(context, resource);
    }

    public PhongArrayAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public PhongArrayAdapter(Context context, int resource, Phong[] objects) {
        super(context, resource, objects);
    }

    public PhongArrayAdapter(Context context, int resource, int textViewResourceId, Phong[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public PhongArrayAdapter(Context context, int resource, List<Phong> objects) {
        super(context, resource, objects);
    }

    public PhongArrayAdapter(Context context, int resource, int textViewResourceId, List<Phong> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    Activity context=null;
    ArrayList<Phong>phongArray=null;
    int layoutId;
    public PhongArrayAdapter(Activity context, int layoutId, ArrayList<Phong>arr) {
        super(context, layoutId, arr);
        this.context = context;
        this.layoutId = layoutId;
        this.phongArray = arr;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= context.getLayoutInflater();
        convertView=inflater.inflate(layoutId, null);
        //chỉ là test thôi, bạn có thể bỏ If đi
        if(phongArray.size()>0 && position>=0)
        {
            //dòng lệnh lấy TextView ra để hiển thị Mã và tên lên
            final TextView txtmaphong=(TextView)
                    convertView.findViewById(R.id.txtMaPhong);
            final TextView txtLoaiPhong=(TextView)
                    convertView.findViewById(R.id.txtLoaiPhong);
            final TextView txtTrangThai=(TextView)
                    convertView.findViewById(R.id.txtTrangThai);
            final TextView txtgia=(TextView)
                    convertView.findViewById(R.id.txtGia);
            //lấy ra phong thứ position
            final Phong p=phongArray.get(position);
            //đưa thông tin lên TextView
            //emp.toString() sẽ trả về Id và Name
            txtmaphong.setText(p.toString());
            txtLoaiPhong.setText(p.getLoaiPhong());
            txtTrangThai.setText(p.getTrangThai());
            if (p.getTrangThai()=="Còn trống")
            { txtTrangThai.setTextColor(Color.green(xanh));}
            txtgia.setText(p.getGia()+"");
            final ImageView imgitem=(ImageView) convertView.findViewById(R.id.imgitem);
            if (p.getLoaiPhong()=="1GĐơn")
            {imgitem.setImageResource(R.drawable.motgdon);}
            //lấy ImageView ra để thiết lập hình ảnh cho đúng
//
//            //nếu là Nữ thì lấy hình con gái
//            if(emp.isGender())
//                imgitem.setImageResource(R.drawable.girlicon);
//            else//nếu là Nam thì lấy hình con trai
//                imgitem.setImageResource(R.drawable.boyicon );
        }
        //Vì View là Object là dạng tham chiếu đối tượng, nên
        //mọi sự thay đổi của các object bên trong convertView
        //thì nó cũng biết sự thay đổi đó
        return convertView;//trả về View này, tức là trả luôn
        //về các thông số mới mà ta vừa thay đổi
    }

}
