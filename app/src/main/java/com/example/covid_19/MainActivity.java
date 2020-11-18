package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covid_19.database.User;
import com.example.covid_19.database.UserDB;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        Button signup = (Button) findViewById(R.id.signUP);
        TextView signin = (TextView) findViewById(R.id.signIN);
        final EditText name = (EditText) findViewById(R.id.Name);
        final EditText email = (EditText) findViewById(R.id.Email);
        final EditText pass = (EditText) findViewById(R.id.Password);
        final Intent i = new Intent(this,signIN.class);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString();
                String Email = email.getText().toString();
                String Pass = pass.getText().toString();
                Log.i("MainActivity",Name);
                Log.i("MainActivity",Email);
                Log.i("MainActivity",Pass);
                try{
                    User u = new User(0,Name,Email,Pass);
                    new UserDB().insert(u);
                    Toast.makeText(MainActivity.this,"Done" , Toast.LENGTH_LONG).show();
                    startActivity(i);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }

            }
        });





    }
    public void SignIN(View v){
        Intent i = new Intent(this,signIN.class);
        startActivity(i);
    }



}
