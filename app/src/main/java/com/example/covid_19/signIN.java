package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.covid_19.database.UserDB;

public class signIN extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_i_n);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        Button signin = (Button) findViewById(R.id.backhome);
        final Intent i = new Intent(this,Home.class);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText) findViewById(R.id.Name);
                final String Name = name.getText().toString();
                EditText pass = (EditText) findViewById(R.id.Password);
                final String Pass = pass.getText().toString();
                Log.i("MainActivity",Name);
                Log.i("MainActivity",Pass);
                try{
                   Boolean result= new UserDB().check(Name,Pass);
                   if (result==true){
                    Toast.makeText(signIN.this,"Done" , Toast.LENGTH_LONG).show();
                    startActivity(i);
                   }else {
                       Toast.makeText(signIN.this,"Name or Password is not Correct!" , Toast.LENGTH_LONG).show();
                   }
                }catch (Exception e){
                    System.out.println(e.getMessage());
                    Log.i("oooooooooo","rrrrrrrrrrr");
                }


            }
        });
    }
}
