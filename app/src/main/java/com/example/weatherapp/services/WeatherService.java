package com.example.weatherapp.services;

import android.util.Log;

import com.example.weatherapp.Constants;
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

public class WeatherService {

    public static void findWeather(String location, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder builder = HttpUrl.parse(Constants.API_BASE_URL).newBuilder();
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

    public ArrayList<Information> processResults(Response response) {
        ArrayList<Information> information = new ArrayList<>();
        ArrayList<WeatherInfo> weatherInfos = new ArrayList<>();
        ArrayList<Temperature> temperatures = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray weather = jsonObject.getJSONArray("weather");
//            JSONObject location = jsonObject.getJSONObject("name");
            JSONObject mainTemps = jsonObject.getJSONObject("main");
            if (response.isSuccessful()) {



                JSONObject weatherJSON = weather.getJSONObject(0);
                String main = weatherJSON.getString("main");
                String description = weatherJSON.getString("description");
                String name = jsonObject.getString("name");

                    String icon = "https://openweathermap.org/img/w/"+weatherJSON.getString("icon")+".png" ;

//                    JSONObject mainJSON = mainTemps.getJSONObject(0);
                    String temp = Double.toString(Math.round(Double.parseDouble(mainTemps.getString("temp"))-273.15)) ;
                    String temp_min = Double.toString(Math.round(Double.parseDouble(mainTemps.getString("temp_min"))-273.15));
                    String temp_max = Double.toString(Math.round(Double.parseDouble(mainTemps.getString("temp_max"))-273.15));
                    String pressure  = mainTemps.getString("pressure");
                    String humidity = mainTemps.getString("humidity");

                WeatherInfo weatherInfo = new WeatherInfo(main, description, icon);
                weatherInfos.add(weatherInfo);
                Temperature temperature = new Temperature(temp, temp_min, temp_max,pressure,humidity);
                temperatures.add(temperature);

////
//                JSONObject mainJSON = mainTemps.getJSONObject(0);
//                int temp = Integer.parseInt(mainJSON.getString("temp"));
//                int temp_min = Integer.parseInt(mainJSON.getString("temp_min"));
//                int temp_max = Integer.parseInt(mainJSON.getString("temp_max"));
//
//                Temperature temperature = new Temperature(temp, temp_min, temp_max);
//                temperatures.add(temperature);

                    Information information1 = new Information(temperatures, weatherInfos,name);
//
                    information.add(information1);


            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return information;


    }

//    public ArrayList<Temperature> processResultsTemp(Response response) {
//
//        ArrayList<Temperature> temperatures = new ArrayList<>();
//        try {
//            String jsonData = response.body().string();
//            JSONObject jsonObject = new JSONObject(jsonData);
//
//            JSONObject mainTemps = jsonObject.getJSONObject("main");
//            if (response.isSuccessful()) {
//
//
//
//
//                    int temp = Integer.parseInt(mainTemps.getString("temp"));
//                    int temp_min = Integer.parseInt(mainTemps.getString("temp_min"));
//                    int temp_max = Integer.parseInt(mainTemps.getString("temp_max"));
//
//
////
//
//
//                Temperature temperature = new Temperature(temp, temp_min, temp_max);
//                temperatures.add(temperature);
//
////
//
//
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return temperatures;
//
//
//    }
}