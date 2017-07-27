package com.example.android.displayjoke;

/**
 * Created by helenherring on 3/1/17.
 */
 import android.os.Bundle;
 import android.support.v4.app.Fragment;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;


    /**
     * A placeholder fragment containing a simple view.
     */
    public class JokeActivityFragment extends Fragment {

        public JokeActivityFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_joke, container, false);
        }
}
