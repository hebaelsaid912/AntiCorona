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

public class dailyCheckUp_3 extends AppCompatActivity {
    private RadioButton ansGroup1;
    private RadioButton ansGroup2;
    private RadioButton ansGroup3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_check_up_3);
        final TextView result = (TextView) findViewById(R.id.Textresult);
        Button submit = (Button)findViewById(R.id.submit);
        Button next = (Button) findViewById(R.id.nextLevel);
        final RadioGroup group1 = (RadioGroup) findViewById(R.id.group1);
        final RadioGroup group2 = (RadioGroup) findViewById(R.id.group2);
        final RadioGroup group3 = (RadioGroup) findViewById(R.id.group3);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ansQ1 = group1.getCheckedRadioButtonId();
                ansGroup1 = (RadioButton) findViewById(ansQ1);
                int ansQ2 = group2.getCheckedRadioButtonId();
                ansGroup2 = (RadioButton) findViewById(ansQ2);
                int ansQ3 = group3.getCheckedRadioButtonId();
                ansGroup3 = (RadioButton) findViewById(ansQ3);
                if(ansGroup1.getText().toString().equals("No") && ansGroup2.getText().toString().equals("No") && ansGroup3.getText().toString().equals("No")){
                    result.setText("You are suffering from seasonal flu, do not panic");
                }else  if(ansGroup1.getText().toString().equals("High") && ansGroup2.getText().toString().equals("High") && ansGroup3.getText().toString().equals("High")){
                    result.setText("OH GOD, Please click on the next Level");
                }else  {
                    result.setText("You have a cold, just take a few rests in your house");
                }

            }
        });
        final Intent i = new Intent(this,dailyCheckUp_4.class);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result.getText().toString().equals("OH GOD, Please click on the next Level")){
                    startActivity(i);
                }else{
                    Toast.makeText(dailyCheckUp_3.this , "you don't have to go to next Level",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
