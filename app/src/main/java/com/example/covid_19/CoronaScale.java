package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CoronaScale extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corona_scale);
    }
    public void backHome(View v){
        Intent i = new Intent(this,Home.class);
        startActivity(i);
    }
}
