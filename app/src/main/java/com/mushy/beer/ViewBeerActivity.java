package com.mushy.beer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ViewBeerActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_beer);

        setTitle("My Beer");
    }
}
