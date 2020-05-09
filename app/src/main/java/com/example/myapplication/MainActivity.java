package com.example.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    String Url = "https://bad-blogger.herokuapp.com/admin/get-question/5eb1847453de6f0b630ba182";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new HttpGetRequest().execute();
    }


    public class HttpGetRequest extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params){
            try {
                //Create a URL object holding our url
                URL myUrl = new URL(Url);
                //Create a connection
                HttpURLConnection connection =(HttpURLConnection)myUrl.openConnection();

                InputStreamReader streamReader = new
                        InputStreamReader(connection.getInputStream());
                //Create a new buffered reader and String Builder
                BufferedReader reader = new BufferedReader(streamReader);
                StringBuilder stringBuilder = new StringBuilder();
                String inputLine;
                //Check if the line we are reading is not null
                while((inputLine = reader.readLine()) != null){
                    stringBuilder.append(inputLine);
                }
                Log.e("Fson",stringBuilder.toString());

            }
            catch(IOException e){
                e.printStackTrace();
            }
            return null;
        }


        protected void onPostExecute(String result){
            super.onPostExecute(result);
        }
    }

}
