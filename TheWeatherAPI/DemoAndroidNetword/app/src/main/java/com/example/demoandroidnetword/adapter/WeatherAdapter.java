package com.example.demoandroidnetword.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demoandroidnetword.R;
import com.example.demoandroidnetword.model.WeatherForecastModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class WeatherAdapter extends BaseAdapter {
    private List<WeatherForecastModel> weatherForecastModels;
    private Context context;

    public WeatherAdapter(List<WeatherForecastModel> weatherForecastModels, Context context) {
        this.weatherForecastModels = weatherForecastModels;
        this.context = context;
    }

    @Override
    public int getCount() {
        return weatherForecastModels.size();
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
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.layout_weather_items, null);
        }
        TextView txtTimeForecast = view.findViewById(R.id.txtTimeForecast);
        TextView txtTemperatureForecast = view.findViewById(R.id.txtTemperatureForecast);
        TextView txtWindForecast = view.findViewById(R.id.txtWindForecast);
        ImageView imgForecast = view.findViewById(R.id.imgForecast);
        WeatherForecastModel weatherForecastModel = weatherForecastModels.get(position);
        txtTimeForecast.setText( "" + weatherForecastModel.getTime());
        txtTemperatureForecast.setText(weatherForecastModel.getTemperature()+"°C");
        txtWindForecast.setText(weatherForecastModel.getWindSpeed()+" km");

        Picasso.get().load("https:"+weatherForecastModel.getIcon()).into(imgForecast);

        return view;
    }
}
