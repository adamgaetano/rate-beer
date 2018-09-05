// Copyright 2018 Adam Gaetano. All Rights Reserved.

package com.mushy.beer;

import android.provider.BaseColumns;

public final class BeerDataContract {

    private BeerDataContract () {
    }

    public static class BeerEntry implements BaseColumns {

        public static final String TABLE_NAME = "beer";
        public static final String COLUMN_BEER_NAME = "name";
        public static final String COLUMN_BEER_STYLE = "style";
        public static final String COLUMN_BEER_BREWERY = "brewery";
        public static final String COLUMN_BEER_ABV = "abv";
        public static final String COLUMN_BEER_IBU = "ibu";
        public static final String COLUMN_BEER_COMMENTS = "comments";
        public static final String COLUMN_BEER_RATING = "rating";

        public static final String SQL_CREATE_BEER = "CREATE TABLE " + BeerEntry.TABLE_NAME +
                " ( " + BeerEntry._ID + " INTEGER PRIMARY KEY, " +
                BeerEntry.COLUMN_BEER_NAME + " VARCHAR(50), " +
                BeerEntry.COLUMN_BEER_STYLE + " VARCHAR(50), " +
                BeerEntry.COLUMN_BEER_BREWERY + " VARCHAR(50), " +
                BeerEntry.COLUMN_BEER_ABV + " NUMERIC, " +
                BeerEntry.COLUMN_BEER_IBU + " NUMERIC," +
                BeerEntry.COLUMN_BEER_COMMENTS + " TEXT, " +
                BeerEntry.COLUMN_BEER_RATING + " NUMERIC )";
    }

}
