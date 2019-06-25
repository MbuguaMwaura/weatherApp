package com.example.weatherapp.models;

import org.parceler.Parcel;

@Parcel
public class Forecast {

         String mTemp;
         String mTemp_min;
         String mTemp_max;
         String mPressure;
         String mHumidity;
         String mMainWeather;
         String mDescription;
         String mIcon;
         String mName;
         String mDate;

public Forecast(){}

    public Forecast (String name, String date, String temp, String max, String min, String pressure, String humidity, String mMainWeather, String mDescription, String mIcon){
            this.mTemp = temp;
            this.mTemp_max = max;
            this.mTemp_min = min;
            this.mHumidity = humidity;
            this.mPressure = pressure;
            this.mMainWeather = mMainWeather;
            this.mDescription = mDescription;
            this.mIcon = mIcon;
            this.mDate = date;
            this.mName = name;

        }

        public String  getmTemp() {
            return mTemp;
        }


        public String getmPressure() {
            return mPressure;
        }

        public String getmHumidity() {
            return mHumidity;
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

    public String getmName() {
        return mName;
    }

    public String getmDate() {
        return mDate;
    }
}


