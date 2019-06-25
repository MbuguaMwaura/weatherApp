package com.example.weatherapp.ui;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.weatherapp.R;
import com.example.weatherapp.adapters.ForecastPagerAdapter;
import com.example.weatherapp.models.Forecast;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForecastDetailActivity extends AppCompatActivity {

    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    private FragmentPagerAdapter adapterViewPager;
    ArrayList<Forecast> mForecast = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast_detail);
        ButterKnife.bind(this);

        mForecast = Parcels.unwrap(getIntent().getParcelableExtra("forecast"));
        int startingPosition = getIntent().getIntExtra("position",0);

        adapterViewPager = new ForecastPagerAdapter(getSupportFragmentManager(), mForecast);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
