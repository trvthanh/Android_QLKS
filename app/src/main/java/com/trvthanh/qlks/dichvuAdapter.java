package com.trvthanh.qlks;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class dichvuAdapter extends ArrayAdapter<DichVu> {

    /*public DichvuAdapter(Context context, int resource) {
        super(context, resource);
    }*/
    Activity context;
    int resource;
    List<DichVu> objects;

    public dichvuAdapter(Activity context, int resource,List<DichVu> objects)
    {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(this.resource, null);

        //dòng lệnh lấy TextView ra để hiển thị Mã và tên lên
        final TextView txtmadv =
                view.findViewById(R.id.txtmadv1);
        final TextView txttendv1 = (TextView)
                view.findViewById(R.id.txttendv1);
        final TextView txtgia = (TextView)
                view.findViewById(R.id.txtgia2);
        //lấy ra phong thứ position
        final DichVu dv = this.objects.get(position);
        //đưa thông tin lên TextView
        //emp.toString() sẽ trả về Id và Name
        txtmadv.setText("Phòng: "+dv.getMaDV());
        txttendv1.setText("Tên dịch vụ: "+ dv.getTenDV());
        txtgia.setText(dv.getGia() + " vnđ" +
                "" +
                " " +
                "" +
                "" +
                "");

        final ImageView imgitem1 = view.findViewById(R.id.tvavartar);
        if (dv.getDVT().equals("Mát-xa")) {
            imgitem1.setImageResource(R.drawable.massage);
        }
        else
        {
            if(dv.getDVT().equals("Buffet sáng"))
            {
                imgitem1.setImageResource(R.drawable.bfs);
            }
            else
            {
                if(dv.getDVT().equals("Buffet tối"))
            {
                imgitem1.setImageResource(R.drawable.bft);
            }
            else
            {
                imgitem1.setImageResource(R.drawable.carrental);
            }
            }
        }
        return view;

    }

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dichvu_adapter);
    }*/
}
