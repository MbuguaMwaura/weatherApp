package com.example.weatherapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.weatherapp.models.Forecast;
import com.example.weatherapp.ui.ForecastDetailsFragement;

import java.util.ArrayList;

public class ForecastPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Forecast> mForecast;

    public ForecastPagerAdapter(FragmentManager fm, ArrayList<Forecast> forecasts){
        super(fm);
        this.mForecast = forecasts;

    }


    @Override
    public Fragment getItem(int position) {
        return ForecastDetailsFragement.newInstance(mForecast.get(position));
    }

    @Override
    public int getCount() {
        return mForecast.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mForecast.get(position).getmDate();
    }
}

