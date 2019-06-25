package com.example.weatherapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import com.example.weatherapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer thunder = MediaPlayer.create(this, R.raw.thunder);

        Button playthunder = (Button) this.findViewById(R.id.getWeatherBtn);

        playthunder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thunder.start();
                Intent intent  = new Intent(MainActivity.this, Search.class);
                startActivity(intent);
            }
        });
    }
}
