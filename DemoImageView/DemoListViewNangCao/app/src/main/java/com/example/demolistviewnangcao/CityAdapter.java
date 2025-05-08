package com.example.demolistviewnangcao;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CityAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<city> citylist;

    public CityAdapter(Context context, int layout, ArrayList<city> citylist ) {
        this.layout = layout;
        this.citylist = citylist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return citylist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView =inflater.inflate(layout,null);
        TextView txtTen=convertView.findViewById(R.id.txtTen);
        TextView txtlin= convertView.findViewById(R.id.txtlink);
        ImageView imgHinh = convertView.findViewById(R.id.imgHinh);
        city city= citylist.get(position);
        txtTen.setText(city.getNameCity());
        txtlin.setText(city.getLinkWiki());
        imgHinh.setImageResource(city.getHinh());
        return convertView;
    }
}
