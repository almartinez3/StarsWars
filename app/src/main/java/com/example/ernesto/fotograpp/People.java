package com.example.ernesto.fotograpp;

import android.support.v7.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.conn.*;


import javax.net.ssl.HttpsURLConnection;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class People extends AppCompatActivity {

    public TextView nombre;
    public TextView altura;
    public TextView masa;
    public TextView colorPelo;
    public TextView colorPiel;
    public TextView colorOjos;
    public TextView fechaNacimiento;
    public TextView genero;
    public int n = 1;
    public static final String URL_SWAPI = "https://swapi.co/api/";
    public JsonReader jsonReader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);
        callWebService(n);
        nombre = findViewById(R.id.txtvNombre);
        altura = findViewById(R.id.txtvAltura);
        masa = findViewById(R.id.txtvMasa);
        colorPelo = findViewById(R.id.txtvColorPelo);
        colorPiel = findViewById(R.id.txtvColorPiel);
        colorOjos = findViewById(R.id.txtvColorOjos);
        fechaNacimiento = findViewById(R.id.txtvFNacimiento);
        genero = findViewById(R.id.txtvGenero);



    }



    public void callWebService(final int n){

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                try {
                    URL urlService = new URL (URL_SWAPI + "people/"+n );
                    HttpsURLConnection connection =  (HttpsURLConnection) urlService.openConnection();
                    connection.setRequestMethod("GET");
                    InputStream responseBody = connection.getInputStream();

                    if (connection.getResponseCode() == 200) {
                        // Success


                        InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");

                        JsonReader jsonReader = new JsonReader(responseBodyReader);
                        jsonReader.beginObject(); // Start processing the JSON object
                        jsonReader.nextName(); // Fetch the next key
                        final String nombre1 = jsonReader.nextString();
                        jsonReader.nextName();
                        final String altura1 = jsonReader.nextString();
                        jsonReader.nextName();
                        final String masa1 = jsonReader.nextString();
                        jsonReader.nextName();
                        final String colorPelo11 = jsonReader.nextString();
                        jsonReader.nextName();
                        final String colorPiel1 = jsonReader.nextString();
                        jsonReader.nextName();
                        final String colorOjos1 = jsonReader.nextString();
                        jsonReader.nextName();
                        final String FNacimiento1 = jsonReader.nextString();
                        jsonReader.nextName();
                        final  String genero1 = jsonReader.nextString();




                        nombre.post(new Runnable() {
                            @Override
                            public void run() {
                                nombre.setText(nombre1);

                            }
                        });
                        altura.post(new Runnable() {
                            @Override
                            public void run() {
                                altura.setText(altura1);

                            }
                        }); masa.post(new Runnable() {
                            @Override
                            public void run() {
                                masa.setText(masa1);

                            }
                        }); colorPelo.post(new Runnable() {
                            @Override
                            public void run() {
                                colorPelo.setText(colorPelo11);

                            }
                        }); colorPiel.post(new Runnable() {
                            @Override
                            public void run() {
                                colorPiel.setText(colorPiel1);

                            }
                        });
                        colorOjos.post(new Runnable() {
                            @Override
                            public void run() {
                                colorOjos.setText(colorOjos1);

                            }
                        });fechaNacimiento.post(new Runnable() {
                            @Override
                            public void run() {
                                fechaNacimiento.setText(FNacimiento1);

                            }
                        });
                        genero.post(new Runnable() {
                            @Override
                            public void run() {
                                genero.setText(genero1);

                            }
                        });

                    } else {
                        // Error handling code goes here
                        Log.v("ERROR", "ERROR");
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });




    } // end callWebService()
    public void next(View view){
        n=n+1;
        callWebService(n);
        if (n>81){
            Log.v("ERROR", "No existe siguiente");

        }
    }

    public void previous(View view){
        n=n-1;
        callWebService(n);
        if (n<=0){
            Log.v("ERROR", "No existe anterior");

        }
    }

}

