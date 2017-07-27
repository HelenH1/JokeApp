package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.example.Jokes;
import com.example.android.displayjoke.JokeActivity;
import android.os.AsyncTask;
import android.content.Context;

import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.example.helenherring.builditbigger.backend.myApi.MyApi;
import com.example.helenherring.builditbigger.backend.myApi.MyApiRequest;
import com.example.helenherring.builditbigger.backend.myApi.MyApiRequestInitializer;
import com.example.helenherring.builditbigger.backend.myApi.MyApiScopes;
import com.example.Jokes;
import com.example.helenherring.builditbigger.backend.myApi.model.MyBean;


import java.io.IOException;

import android.content.Intent;

public class MainActivity extends AppCompatActivity implements AsyncResponse{

    String mJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in the manifest.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        EndpointsAsyncTask asyncTask = new EndpointsAsyncTask(this);
        asyncTask.execute();


    }

    public void launchLibraryActivity(String joke) {
        Intent jokeIntent = new Intent(this, JokeActivity.class);
        jokeIntent.putExtra("Joke", joke);
        System.out.println("Joke is: "+joke);
        System.out.println("Launching joke activity.");
        startActivity(jokeIntent);
    }



    @Override
    public void processFinish(String output){
        mJoke = output;
        launchLibraryActivity(output);
    }


    public class EndpointsAsyncTask extends AsyncTask<String, Void, String> {
        private MyApi myApiService = null;

        public AsyncResponse delegate = null;

        public EndpointsAsyncTask(AsyncResponse delegate){
            this.delegate = delegate;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            if(myApiService == null) {  // Only do this once
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                        .setRootUrl("https://builditbigger-160402.appspot.com/_ah/api/");
                // end options for devappserver

                myApiService = builder.build();
            }


            try {
                String goke = myApiService.getJoke().execute().getData();
                System.out.println("Joke is : "+goke);
                return goke;

            } catch (IOException e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            System.out.println("Result is : "+result);
            delegate.processFinish(result);

        }
    }

}
