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

public class Planets extends AppCompatActivity {

    public TextView nombre;
    public TextView rotacion;
    public TextView orbital;
    public TextView diametro;
    public TextView clima;
    public TextView gravedad;
    public TextView terreno;
    public TextView superficieAgua;
    public TextView poblacion;

    public int n = 1;
    public static final String URL_SWAPI = "https://swapi.co/api/";
    public JsonReader jsonReader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet);
        callWebService(n);
        nombre = findViewById(R.id.txtvNombreP);
        rotacion = findViewById(R.id.txtvRotacion);
        orbital = findViewById(R.id.txtvOrbita);
        diametro = findViewById(R.id.txtvDiametro);
        clima = findViewById(R.id.txtvClima);
        gravedad = findViewById(R.id.txtvGravedad);
        terreno = findViewById(R.id.txtvTerreno);
        superficieAgua = findViewById(R.id.txtvSuperficie);
        poblacion = findViewById(R.id.txtvPopulation);





    }



    public void callWebService(final int n){

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                try {
                    URL urlService = new URL (URL_SWAPI + "planets/"+n );
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
                        final String rotacion1 = jsonReader.nextString();
                        jsonReader.nextName();
                        final String orbital1 = jsonReader.nextString();
                        jsonReader.nextName();
                        final String diametro1 = jsonReader.nextString();
                        jsonReader.nextName();
                        final String clima1 = jsonReader.nextString();
                        jsonReader.nextName();
                        final String gravedad1 = jsonReader.nextString();
                        jsonReader.nextName();
                        final  String terreno1 = jsonReader.nextString();
                        jsonReader.nextName();
                        final String superficie1 = jsonReader.nextString();
                        jsonReader.nextName();
                        final String poblacion1 = jsonReader.nextString();
                        jsonReader.nextName();




                        nombre.post(new Runnable() {
                            @Override
                            public void run() {
                                nombre.setText(nombre1);

                            }
                        });
                        rotacion.post(new Runnable() {
                            @Override
                            public void run() {
                                rotacion.setText(rotacion1);

                            }
                        }); orbital.post(new Runnable() {
                            @Override
                            public void run() {
                                orbital.setText(orbital1);

                            }
                        }); diametro.post(new Runnable() {
                            @Override
                            public void run() {
                                diametro.setText(diametro1);

                            }
                        }); clima.post(new Runnable() {
                            @Override
                            public void run() {
                                clima.setText(clima1);

                            }
                        }); gravedad.post(new Runnable() {
                            @Override
                            public void run() {
                                gravedad.setText(gravedad1);

                            }
                        });
                        terreno.post(new Runnable() {
                            @Override
                            public void run() {
                                terreno.setText(terreno1);

                            }
                        });
                        superficieAgua.post(new Runnable() {
                            @Override
                            public void run() {
                                superficieAgua.setText(superficie1);

                            }
                        });
                        poblacion.post(new Runnable() {
                            @Override
                            public void run() {
                                poblacion.setText(poblacion1);

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
    public void next1(View view){
        n=n+1;
        callWebService(n);
        if (n>81){
            Log.v("ERROR", "No existe siguiente");

        }
    }

    public void previous1(View view){
        n=n-1;
        callWebService(n);
        if (n<=0){
            Log.v("ERROR", "No existe anterior");

        }
    }

}



