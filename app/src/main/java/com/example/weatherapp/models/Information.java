package com.example.weatherapp.models;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Information {
    private ArrayList<Temperature> mTemperatures;
    private ArrayList<WeatherInfo> mWeatherInfos;
    private String mName;

    public Information (ArrayList<Temperature> temperatures, ArrayList<WeatherInfo> weatherInfos, String name ){
        this.mTemperatures = temperatures;
        this.mWeatherInfos = weatherInfos;
        this.mName = name;
    }

    public ArrayList<Temperature> getmTemperatures() {
        return mTemperatures;
    }

    public ArrayList<WeatherInfo> getmWeatherInfos() {
        return mWeatherInfos;
    }

    public String getmName() {
        return mName;
    }
}
