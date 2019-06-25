package com.example.weatherapp.models;

public class Temperature {

    private String mTemp;
    private String mTemp_min;
    private String mTemp_max;
    private String mPressure;
    private String mHumidity;

    public Temperature (String temp, String max, String min, String pressure, String humidity){
        this.mTemp = temp;
        this.mTemp_max = max;
        this.mTemp_min = min;
        this.mHumidity = humidity;
        this.mPressure = pressure;

    }

    public String  getmTemp() {
        return mTemp;
    }

    public String getmTemp_min() {
        return mTemp_min;
    }

    public String getmTemp_max() {
        return mTemp_max;
    }

    public String getmPressure() {
        return mPressure;
    }

    public String getmHumidity() {
        return mHumidity;
    }
}
