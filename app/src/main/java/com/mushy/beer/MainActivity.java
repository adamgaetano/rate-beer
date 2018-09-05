package com.mushy.beer;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button addBeerButton;
    private Button viewBeerButton;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private BeerDatabaseHelper dbHelper;
    private SQLiteDatabase db;

    private ArrayList<Beer> topBeers;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new BeerDatabaseHelper(this);
        db = dbHelper.getReadableDatabase();

        addBeerButton = (Button) findViewById(R.id.addBeerButton);
        viewBeerButton = (Button) findViewById(R.id.viewBeerButton);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        topBeers = getTopBeers();

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter(topBeers);
        recyclerView.setAdapter(adapter);


        setTitle("Beer");
    }

    @Override
    public void onResume () {
        super.onResume();

        topBeers = getTopBeers();
        adapter = new RecyclerAdapter(topBeers);
        recyclerView.setAdapter(adapter);
    }

    public void onClickAddBeer (View view) {


        Intent i = new Intent(this, AddBeerActivity.class);
        startActivity(i);
    }

    public void onClickEditBeer (View view) {


        Intent i = new Intent(this, ViewBeerActivity.class);
        startActivity(i);

    }

    public ArrayList<Beer> getTopBeers () {

        ArrayList<Beer> beers = new ArrayList<>();

        db = dbHelper.getReadableDatabase();
        String query = "select * from " + BeerDataContract.BeerEntry.TABLE_NAME + " order by " + BeerDataContract.BeerEntry.COLUMN_BEER_RATING + " desc";

        Cursor cursor = db.rawQuery(query, null);
        int topCount = 1;
        //List itemIds = new ArrayList<>();
        while (cursor.moveToNext()) {
            //long itemId = cursor.getLong(cursor.getColumnIndexOrThrow(BeerDataContract.BeerEntry._ID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(BeerDataContract.BeerEntry.COLUMN_BEER_NAME));
            String rating = cursor.getString(cursor.getColumnIndexOrThrow(BeerDataContract.BeerEntry.COLUMN_BEER_RATING));
            //itemIds.add(itemId);
            if (topCount <= 10) {
                Beer beer = new Beer(name);
                if (!rating.trim().isEmpty()) {
                    beer.setRating(Float.parseFloat(rating));
                }
                beers.add(beer);
            }
            topCount++;
            Log.d(this.getClass().getSimpleName(), "Found: " + name + " (" + rating + ")");
        }
        cursor.close();

        return beers;
    }

    @Override
    protected void onDestroy () {
        dbHelper.close();
        super.onDestroy();
    }

}
