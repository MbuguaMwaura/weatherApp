package com.example.weatherapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weatherapp.R;
import com.example.weatherapp.models.Information;
import com.example.weatherapp.models.Temperature;
import com.example.weatherapp.models.WeatherInfo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class WeatherInfoAdapter extends RecyclerView.Adapter<WeatherInfoAdapter.WeatherViewHolder> {

//    private ArrayList<String> mMain = new ArrayList<>();
    private ArrayList<Information> mIndformation = new ArrayList<>();
    private ArrayList<WeatherInfo> mWeather = new ArrayList<>();
    private ArrayList<Temperature> mTemps = new ArrayList<>();
    private Context mContext;

    public WeatherInfoAdapter(ArrayList<Information> information, Context context){
       mContext = context;
//     mTemps = temperatures;
//     mWeather = weatherInfos;
        mIndformation = information;

    }

    @Override
    public void onBindViewHolder(WeatherInfoAdapter.WeatherViewHolder holder, int position) {
//        holder.bindWeather(mWeather.get(position));
//        holder.bindTemps(mTemps.get(position));
        holder.bindInfo(mIndformation.get(position));

    }

    @Override
    public WeatherInfoAdapter.WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_list_item,parent,false);
        WeatherViewHolder viewHolder = new WeatherViewHolder(view);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return mIndformation.size();
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.mainWeather)
        TextView mMainWeather;
        @BindView(R.id.description) TextView mDescription;
        @BindView(R.id.temp) TextView mTemp;
        @BindView(R.id.tempMax) TextView mTemp_Max;
        @BindView(R.id.tempMin) TextView mTemp_Min;
        @BindView(R.id.weatherImage) ImageView mImage;
        @BindView(R.id.pressure) TextView mPressure;
        @BindView(R.id.humidity) TextView mHumidity;
        @BindView(R.id.locationName) TextView mName;

        private Context context;

        public WeatherViewHolder( View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();

        }

//        public void bindWeather( WeatherInfo weatherInfo){
//            mMainWeather.setText(weatherInfo.getmMainWeather());
//            mDescription.setText(weatherInfo.getmDescription());
////
//        }
//        public void bindTemps(Temperature temperature){
//            mTemp.setText(temperature.getmTemp());
//            mTemp_Max.setText(temperature.getmTemp_max());
//            mTemp_Min.setText(temperature.getmTemp_min());
//        }


        public void bindInfo(Information information){
            mMainWeather.setText(information.getmWeatherInfos().get(0).getmMainWeather());
            mDescription.setText(information.getmWeatherInfos().get(0).getmDescription());
            Picasso.get().load(information.getmWeatherInfos().get(0).getmIcon()).into(mImage);
            mTemp.setText("Current temp:            "+information.getmTemperatures().get(0).getmTemp()+" C");
            mTemp_Max.setText("Min temp:                  "+information.getmTemperatures().get(0).getmTemp_max()+" C");
            mTemp_Min.setText("Max temp:                 "+information.getmTemperatures().get(0).getmTemp_min()+" C");
            mPressure.setText("Pressure:                  "+information.getmTemperatures().get(0).getmPressure()+" Pa");
            mHumidity.setText("Humidity:                  "+information.getmTemperatures().get(0).getmHumidity()+" g/m3");
            mName.setText(information.getmName()+" Weather");


        }
    }
}
