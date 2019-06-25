package com.example.weatherapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weatherapp.R;
import com.example.weatherapp.models.Forecast;
import com.example.weatherapp.models.Information;
import com.example.weatherapp.models.Temperature;
import com.example.weatherapp.models.WeatherInfo;
import com.example.weatherapp.ui.ForecastDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {

    private ArrayList<Forecast> mForecast = new ArrayList<>();
    private Context mContext;

    public ForecastAdapter(ArrayList<Forecast> forecast, Context context){
        mContext = context;
        mForecast = forecast;

    }

    @Override
    public void onBindViewHolder(ForecastAdapter.ForecastViewHolder holder, int position) {
        holder.bindForecast(mForecast.get(position));

    }

    @Override
    public ForecastAdapter.ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_forecast_item,parent,false);
        ForecastAdapter.ForecastViewHolder viewHolder = new ForecastAdapter.ForecastViewHolder(view);
        return viewHolder;
    }
    @Override
    public int getItemCount() {
        return mForecast.size();
    }

    public class ForecastViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.forecastmainWeather)
        TextView mMainWeather;
        @BindView(R.id.forecastdescription) TextView mDescription;
//        @BindView(R.id.forecasttemp) TextView mTemp;
        @BindView(R.id.forecastweatherImage)
        ImageView mImage;
//        @BindView(R.id.forecastpressure) TextView mPressure;
//        @BindView(R.id.forecasthumidity) TextView mHumidity;
        @BindView(R.id.forecastlocationName) TextView mName;
        @BindView(R.id.forecastDate) TextView mDate;

        private Context context;

        public ForecastViewHolder( View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, ForecastDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("forecast", Parcels.wrap(mForecast));
            mContext.startActivity(intent);
        }

        public void bindForecast(Forecast forecast){

            mMainWeather.setText(forecast.getmMainWeather());
            mDescription.setText(forecast.getmDescription());
            Picasso.get().load(forecast.getmIcon()).into(mImage);
//            mTemp.setText("Temperature:            "+forecast.getmTemp()+" C");
//            mPressure.setText("Pressure:                  "+forecast.getmPressure()+" Pa");
//            mHumidity.setText("Humidity:                  "+forecast.getmHumidity()+" g/m3");
            mDate.setText(forecast.getmDate());
            mName.setText(forecast.getmName()+" 5 Day Forecast");



        }
    }
}
