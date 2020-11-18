package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void DailyCheckUp(View view){
        Intent i = new Intent(this,dailyCheckUp_1.class);
        startActivity(i);
    }
    public void Advices(View view){
        Intent i = new Intent(this,Advices.class);
        startActivity(i);
    }
    public void sports(View view){
        Intent i = new Intent(this,Sports.class);
        startActivity(i);
    }
    public void food(View view){
        Intent i = new Intent(this,Healthyfood.class);
        startActivity(i);
    }
    public void Scale(View view){
        Intent i = new Intent(this,CoronaScale.class);
        startActivity(i);
    }
}
