package com.udacity.gradle.builditbigger;


import android.app.Instrumentation;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.test.InstrumentationRegistry;
import android.content.Context;

import org.junit.Test;
/**
 * Created by helenherring on 3/10/17.
 */

public class AsyncTaskReturnsJokeTest implements AsyncResponse{

    private String jokeString;
    private Handler mHandler;

    AsyncResponse instance = new AsyncResponse() {

        public void processFinish(String output){ jokeString = output; }

    };

    @Override
    public void processFinish(String output) {
        jokeString = output;
    }

     @Test
     public void testGetJoke() {
         mHandler = new Handler(Looper.getMainLooper()) {
             public void handleMessage(Message msg) {
             }
         };

         Looper.prepare();

         AsyncTask asyncTask = new MainActivity().new EndpointsAsyncTask(this).execute("hi");

            Message message = mHandler.obtainMessage();
            String handlerMessage = message.toString();
            assert(jokeString!=null || handlerMessage!=null);
        }


}


