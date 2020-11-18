package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class dailyCheckUp_2 extends AppCompatActivity {
    private RadioButton ansGroup1;
    private RadioButton ansGroup2;
    private RadioButton ansGroup3;
    private RadioButton ansGroup4;
    private RadioButton ansGroup5;
    private RadioButton ansGroup6;
    private RadioButton ansGroup7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_check_up_2);
        final TextView result = (TextView) findViewById(R.id.Textresult);
        Button submit = (Button) findViewById(R.id.submit);
        Button next = (Button) findViewById(R.id.tolevel3);
        final RadioGroup group1 = (RadioGroup) findViewById(R.id.group1);
        final RadioGroup group2 = (RadioGroup) findViewById(R.id.group2);
        final RadioGroup group3 = (RadioGroup) findViewById(R.id.group3);
        final RadioGroup group4 = (RadioGroup) findViewById(R.id.group1);
        final RadioGroup group5 = (RadioGroup) findViewById(R.id.group2);
        final RadioGroup group6 = (RadioGroup) findViewById(R.id.group3);
        final RadioGroup group7 = (RadioGroup) findViewById(R.id.group3);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ansQ1 = group1.getCheckedRadioButtonId();
                ansGroup1 = (RadioButton) findViewById(ansQ1);
                int ansQ2 = group2.getCheckedRadioButtonId();
                ansGroup2 = (RadioButton) findViewById(ansQ2);
                int ansQ3 = group3.getCheckedRadioButtonId();
                ansGroup3 = (RadioButton) findViewById(ansQ3);
                int ansQ4 = group4.getCheckedRadioButtonId();
                ansGroup4 = (RadioButton) findViewById(ansQ1);
                int ansQ5 = group5.getCheckedRadioButtonId();
                ansGroup5 = (RadioButton) findViewById(ansQ2);
                int ansQ6 = group6.getCheckedRadioButtonId();
                ansGroup6 = (RadioButton) findViewById(ansQ2);
                int ansQ7 = group7.getCheckedRadioButtonId();
                ansGroup7 = (RadioButton) findViewById(ansQ3);
                if (ansGroup1.getText().toString().equals("No") &&
                        ansGroup2.getText().toString().equals("No") &&
                        ansGroup3.getText().toString().equals("No") &&
                        ansGroup4.getText().toString().equals("No") &&
                        ansGroup5.getText().toString().equals("No") &&
                        ansGroup6.getText().toString().equals("No") &&
                        ansGroup7.getText().toString().equals("No")) {
                    result.setText("You have a strong cold, just take a few rests in your house");
                } else if (ansGroup1.getText().toString().equals("High") &&
                        ansGroup2.getText().toString().equals("High") &&
                        ansGroup3.getText().toString().equals("High") &&
                        ansGroup4.getText().toString().equals("High") &&
                        ansGroup5.getText().toString().equals("High") &&
                        ansGroup6.getText().toString().equals("High") &&
                        ansGroup7.getText().toString().equals("High")) {
                    result.setText("The situation has become very serious but we need to make sure, Please click on the next Level");
                } else {
                    result.setText("You may be suffering from influenza. Stick to your home and take some rest");
                }

            }
        });
        final Intent i = new Intent(this, dailyCheckUp_3.class);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result.getText().toString().equals("The situation has become very serious but we need to make sure, Please click on the next Level")) {
                    startActivity(i);
                } else {
                    Toast.makeText(dailyCheckUp_2.this, "you don't have to go to next Level", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
