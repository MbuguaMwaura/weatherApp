package com.example.weatherapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.weatherapp.R;
import com.example.weatherapp.adapters.WeatherInfoAdapter;
import com.example.weatherapp.models.Information;
import com.example.weatherapp.models.Temperature;
import com.example.weatherapp.models.WeatherInfo;
import com.example.weatherapp.services.WeatherService;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherActivity extends AppCompatActivity {
    public ArrayList<Information> mInfo;
    public ArrayList<WeatherInfo> mWeatherInfo;
    public ArrayList<Temperature> mTemps;
    private WeatherInfoAdapter mAdapter;
    private Button mForecast;


        @BindView(R.id.recyclerView) RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);

        mForecast = (Button) findViewById(R.id.forecastebtn);


        final Intent intent = getIntent();
        final String location = intent.getStringExtra("location");

        getWeather(location);


        mForecast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(WeatherActivity.this, ForeCastActivity.class);
                intent1.putExtra("location", location);
                startActivity(intent1);
            }
        });





    }

    private void getWeather(String location){
        final WeatherService weatherService = new WeatherService();

        weatherService.findWeather(location, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.v("error","failed");
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                mInfo = weatherService.processResults(response);


                WeatherActivity.this.runOnUiThread(new Runnable() {



                    @Override
                    public void run() {


                        mAdapter = new WeatherInfoAdapter(mInfo,getApplicationContext());
                        mRecyclerView.setAdapter(mAdapter);


                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(WeatherActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }
}
