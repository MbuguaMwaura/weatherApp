package com.example.weatherapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.weatherapp.R;

public class Search extends AppCompatActivity {

    private EditText mLocation;
    private Button mSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mLocation = (EditText) findViewById(R.id.locationEdit);
        mSearch = (Button) findViewById(R.id.searchLocation);

        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location =mLocation.getText().toString();
                Intent intent = new Intent(Search.this, WeatherActivity.class);
                intent.putExtra("location", location);
                Toast.makeText(Search.this, location, Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });

    }
}
