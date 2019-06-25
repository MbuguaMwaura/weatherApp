package com.example.weatherapp.services;

import android.util.Log;

import com.example.weatherapp.Constants;
import com.example.weatherapp.models.Forecast;
import com.example.weatherapp.models.Information;
import com.example.weatherapp.models.Temperature;
import com.example.weatherapp.models.WeatherInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ForecastService {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public static void findWeather(String location, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder builder = HttpUrl.parse(Constants.API_FORECAST_URL).newBuilder();
        builder.addQueryParameter(Constants.YOUR_QUERY_PARAMETER, location);
        builder.addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.API_KEY);
        String url = builder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Log.v("url", request.toString());

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Forecast> processResults(Response response) {
        ArrayList<Forecast> forecasts = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray listJSON = jsonObject.getJSONArray("list");
//            JSONObject mainJSON = jsonObject.getJSONObject("main");
            if (response.isSuccessful()) {

            for (int i = 0; i < listJSON.length();i++) {
                JSONObject listItemJSON = listJSON.getJSONObject(i);
                String date = listItemJSON.getString("dt_txt");
                JSONObject mainJSON = listItemJSON.getJSONObject("main");
                String temp = Double.toString(Math.round(Double.parseDouble(mainJSON.getString("temp")) - 273.15));
                String temp_max = Double.toString(Math.round(Double.parseDouble(mainJSON.getString("temp_max")) - 273.15));
                String temp_min = Double.toString(Math.round(Double.parseDouble(mainJSON.getString("temp_min")) - 273.15));
                String pressure = mainJSON.getString("pressure");
                String humidity = mainJSON.getString("humidity");

                JSONArray weatherJSONArray = listItemJSON.getJSONArray("weather");
                JSONObject weatherJSON = weatherJSONArray.getJSONObject(0);
                String mainName = weatherJSON.getString("main");
                String description = weatherJSON.getString("description");
                String icon = "https://openweathermap.org/img/w/" + weatherJSON.getString("icon") + ".png";

                JSONObject cityJSON = jsonObject.getJSONObject("city");
                String name = cityJSON.getString("name");

                Forecast forecast = new Forecast(name,date,temp,temp_max, temp_min, pressure,humidity,mainName,description,icon);
                forecasts.add(forecast);
                i+=8;
            }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return forecasts;


    }

}