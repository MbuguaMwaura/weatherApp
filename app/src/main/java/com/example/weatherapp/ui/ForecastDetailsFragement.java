package com.example.weatherapp.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weatherapp.R;
import com.example.weatherapp.models.Forecast;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForecastDetailsFragement extends Fragment {
    @BindView(R.id.forecastmainWeather)
    TextView mMainWeather;
    @BindView(R.id.forecastdescription) TextView mDescription;
    @BindView(R.id.forecasttemp) TextView mTemp;
    @BindView(R.id.forecastweatherImage)
    ImageView mImage;
    @BindView(R.id.forecastpressure) TextView mPressure;
    @BindView(R.id.forecasthumidity) TextView mHumidity;
    @BindView(R.id.forecastlocationName) TextView mName;
    @BindView(R.id.forecastDate) TextView mDate;

    private Forecast mForecast;

    public static ForecastDetailsFragement newInstance(Forecast forecast) {
        ForecastDetailsFragement forecastDetailsFragement = new ForecastDetailsFragement();
        Bundle args = new Bundle();
        args.putParcelable("forecast", Parcels.wrap(forecast));
        forecastDetailsFragement.setArguments(args);
        return forecastDetailsFragement;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mForecast = Parcels.unwrap(getArguments().getParcelable("forecast"));
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forecast_details,container,false);
        ButterKnife.bind(this,view);
        mMainWeather.setText(mForecast.getmMainWeather());
        mDescription.setText(mForecast.getmDescription());
        Picasso.get().load(mForecast.getmIcon()).into(mImage);
        mTemp.setText("Temperature:            "+mForecast.getmTemp()+" C");
        mPressure.setText("Pressure:                  "+mForecast.getmPressure()+" Pa");
        mHumidity.setText("Humidity:                  "+mForecast.getmHumidity()+" g/m3");
        mDate.setText(mForecast.getmDate());
        mName.setText(mForecast.getmName()+" 5 Day Forecast");

        return view;
    }

}
