package com.example.helenherring.builditbigger.backend;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    /** The object model for the data we are sending through endpoints */
     private String myData;

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }
}
