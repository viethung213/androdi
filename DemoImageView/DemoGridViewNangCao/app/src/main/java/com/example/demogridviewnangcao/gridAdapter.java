package com.example.demogridviewnangcao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class gridAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<phantu> phantuArrayList;

    public gridAdapter(Context context, int layout, ArrayList<phantu> phantuArrayList) {
        this.context = context;
        this.layout = layout;
        this.phantuArrayList = phantuArrayList;
    }

    @Override
    public int getCount() {
        return phantuArrayList.size();
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
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);
        TextView txtten=convertView.findViewById(R.id.textView);
        TextView txtsluong= convertView.findViewById(R.id.textView2);
        TextView txtdiachi= convertView.findViewById(R.id.textView3);
        ImageView hinh=convertView.findViewById(R.id.imageView);
        phantu phantu= phantuArrayList.get(position);
        txtten.setText(phantu.getTen());
        txtsluong.setText(phantu.getSoluong());
        txtdiachi.setText(phantu.getSoluong());
        hinh.setImageResource(phantu.getHinh());
        return convertView;
    }
}
