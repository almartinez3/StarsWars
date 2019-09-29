package com.example.ernesto.fotograpp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


import org.apache.http.conn.*;


import javax.net.ssl.HttpsURLConnection;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class MainActivity extends AppCompatActivity {


    public Button people;
    public Button planets;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        people = (Button) findViewById(R.id.btnPeople);
        planets = (Button) findViewById(R.id.btnPlanets);



        people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent people = new Intent(MainActivity.this, People.class);
                startActivity(people);
            }
        });




        planets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent planets = new Intent(MainActivity.this, Planets.class);
             startActivity(planets);
            }
        });


    }
}