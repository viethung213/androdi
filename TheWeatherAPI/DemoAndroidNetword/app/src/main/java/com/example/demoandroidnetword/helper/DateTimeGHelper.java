package com.example.demoandroidnetword.helper;

import android.renderscript.Sampler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeGHelper {
    private  static  String Patten = "dd/MM/yyyy";
    public static Date toDate(String st) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.parse(st);
    }

    public static String toString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return sdf.format(date);
    }
    public static String toHour(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");

        return sdf.format(date);
    }
    public static String toString(String st){
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");

        return sdf.format(st);
    }
}
