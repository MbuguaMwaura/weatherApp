package com.example.weatherapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.weatherapp.R;
import com.example.weatherapp.adapters.ForecastAdapter;
import com.example.weatherapp.adapters.WeatherInfoAdapter;
import com.example.weatherapp.models.Forecast;
import com.example.weatherapp.models.Information;
import com.example.weatherapp.services.ForecastService;
import com.example.weatherapp.services.WeatherService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ForeCastActivity extends AppCompatActivity {
    public ArrayList<Forecast> mForecast;
    private ForecastAdapter mAdapter;
    @BindView(R.id.recyclerView2) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);
        ButterKnife.bind(this);


        final Intent intent = getIntent();
        String location = intent.getStringExtra("location");

        getForecast(location);


    }

    private void getForecast(String location){
        final ForecastService forecastService = new ForecastService();

        forecastService.findWeather(location, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.v("error","failed");
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {


                mForecast = forecastService.processResults(response);

                ForeCastActivity.this.runOnUiThread(new Runnable() {



                    @Override
                    public void run() {


                        mAdapter = new ForecastAdapter(mForecast,getApplicationContext());
                        mRecyclerView.setAdapter(mAdapter);


                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ForeCastActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }
}