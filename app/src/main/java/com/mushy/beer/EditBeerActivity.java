// Copyright 2018 Adam Gaetano. All Rights Reserved.

package com.mushy.beer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class EditBeerActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_beer);

        setTitle("Edit Beer");
    }


    /** code for selecting one beer
     *
     * public void printOutAllBeers () {

     db = dbHelper.getReadableDatabase();

     // Define a projection that specifies which columns from the database
     // you will actually use after this query.
     String[] projection = {
     BaseColumns._ID,
     BeerDataContract.BeerEntry.COLUMN_BEER_NAME,
     BeerDataContract.BeerEntry.COLUMN_BEER_STYLE
     };

     // Filter results WHERE "title" = 'My Title'
     String selection = BeerDataContract.BeerEntry.COLUMN_BEER_NAME + " = ?";
     String[] selectionArgs = { "My Title" };

     // How you want the results sorted in the resulting Cursor
     String sortOrder =
     BeerDataContract.BeerEntry.COLUMN_BEER_NAME + " DESC";

     Cursor cursor = db.query(
     BeerDataContract.BeerEntry.TABLE_NAME,   // The table to query
     projection,             // The array of columns to return (pass null to get all)
     selection,              // The columns for the WHERE clause
     selectionArgs,          // The values for the WHERE clause
     null,                   // don't group the rows
     null,                   // don't filter by row groups
     sortOrder               // The sort order
     );

     List itemIds = new ArrayList<>();
     while(cursor.moveToNext()) {
     long itemId = cursor.getLong(
     cursor.getColumnIndexOrThrow(FeedEntry._ID));
     itemIds.add(itemId);
     }
     cursor.close();

     }
     *
     *
     *
     */

}
