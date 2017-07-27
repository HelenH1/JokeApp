package com.example.android.displayjoke;

/**
 * Created by helenherring on 3/1/17.
 */

 import android.os.Bundle;
 import android.support.v7.app.AppCompatActivity;
 import android.view.Menu;
 import android.view.MenuItem;
 import android.content.Intent;
 import android.widget.TextView;

    public class JokeActivity extends AppCompatActivity {

        String mJoke;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_joke);
            System.out.println("Joke activity launched.");
            TextView jokeText = (TextView) findViewById(R.id.tv_tell_joke);
            Intent intentThatStartedThisActivity = getIntent();

            if (intentThatStartedThisActivity != null) {
                if (intentThatStartedThisActivity.hasExtra("Joke")) {
                    mJoke = intentThatStartedThisActivity.getStringExtra("Joke");
                    jokeText.setText(mJoke);
                }
            }
            System.out.println("Joke activity received joke: "+mJoke);
        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
  //          getMenuInflater().inflate(R.menu.menu_image, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
  //          if (id == R.id.action_settings) {
  //              return true;
  //          }

            return super.onOptionsItemSelected(item);
        }
}
