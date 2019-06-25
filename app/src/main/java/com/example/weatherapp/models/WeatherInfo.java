package com.example.weatherapp.models;

import java.util.ArrayList;

public class WeatherInfo {
    private String mName;
    private String mMainWeather;
    private String mDescription;
    private String mIcon;
    private int mTemp;
    private int mTemp_min;
    private int mTemp_max;
    private ArrayList<String> mWeather = new ArrayList<>();
    private ArrayList<Integer> mTemperatures = new ArrayList<>();


    public WeatherInfo( String mMainWeather, String mDescription, String mIcon) {
        this.mMainWeather = mMainWeather;
        this.mDescription = mDescription;
        this.mIcon = mIcon;
//        this.mTemp = mTemp;
//        this.mTemp_min = mTemp_min;
//        this.mTemp_max = mTemp_max;

    }

    public String getmMainWeather() {
        return mMainWeather;
    }

    public String getmDescription() {
        return mDescription;
    }

    public String getmIcon() {
        return mIcon;
    }


//
//    public int getmTemp() {
//        return mTemp;
//    }
//
//    public int getmTemp_min() {
//        return mTemp_min;
//    }
//
//    public int getmTemp_max() {
//        return mTemp_max;
//    }
//
//    public ArrayList<String> getmWeather() {
//        return mWeather;
//    }
//
//    public ArrayList<Integer> getmTemperatures() {
//        return mTemperatures;
//    }
}
