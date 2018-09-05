package com.mushy.beer;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class AddBeerActivity extends AppCompatActivity {

    private BeerDatabaseHelper dbHelper;
    private SQLiteDatabase db;

    private EditText editName;
    private EditText editStyle;
    private EditText editBrewery;
    private EditText editABV;
    private EditText editIBU;
    private EditText editComments;
    private NumberPicker ratingPicker;
    private NumberPicker ratingPickerDecimal;
    private Button submitButton;
    private TextView ratingText;

    private String rating;
    private String ratingDecimal;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_beer);

        editName = (EditText) findViewById(R.id.editName);
        editStyle = (EditText) findViewById(R.id.editStyle);
        editBrewery = (EditText) findViewById(R.id.editBrewery);
        editABV = (EditText) findViewById(R.id.editABV);
        editIBU = (EditText) findViewById(R.id.editIBU);
        editComments = (EditText) findViewById(R.id.editComments);
        submitButton = (Button) findViewById(R.id.submitButton);

        ratingText = (TextView) findViewById(R.id.ratingText);
        ratingPicker = (NumberPicker) findViewById(R.id.ratingPicker);
        ratingPicker.setMinValue(1);
        ratingPicker.setMaxValue(10);
        ratingPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange (NumberPicker numberPicker, int oldVal, int newVal) {

                if (newVal == 10) {
                    ratingPickerDecimal.setEnabled(false);
                    rating = "10";
                    ratingDecimal = "0";
                    ratingPickerDecimal.setValue(0);
                } else {
                    rating = String.valueOf(newVal);
                    ratingPickerDecimal.setEnabled(true);
                }
                updateRating();
            }
        });
        ratingPickerDecimal = (NumberPicker) findViewById(R.id.ratingPickerDecimal);
        ratingPickerDecimal.setMinValue(0);
        ratingPickerDecimal.setMaxValue(9);
        ratingPickerDecimal.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange (NumberPicker numberPicker, int oldVal, int newVal) {
                ratingDecimal = String.valueOf(newVal);
                updateRating();
            }
        });

        // Start rating at 5 out of 10
        ratingPicker.setValue(5);
        ratingPickerDecimal.setValue(0);
        rating = "5";
        ratingDecimal = "0";
        updateRating();

        dbHelper = new BeerDatabaseHelper(this);
        db = dbHelper.getReadableDatabase();

        setTitle("Add Beer");
    }

    public void updateRating () {

        String text = rating + "." + ratingDecimal;
        ratingText.setText(text);

    }

    public void onClickSubmit (View view) {

        // TODO check for empty fields
        // TODO check for NaN for abv and ibu (toast)
        // TODO check if beer is already registered
        // TODO allow only name to be entered with rating to be entered later

        db = dbHelper.getWritableDatabase();

        String name = editName.getText().toString().trim();
        String style = editStyle.getText().toString().trim();
        String brewery = editBrewery.getText().toString().trim();
        String comments = editComments.getText().toString().trim();

        if (!name.isEmpty()) {

            ContentValues values = new ContentValues();
            values.put(BeerDataContract.BeerEntry.COLUMN_BEER_NAME, name);

            // Check if fields were filled out
            // Value will be null in database if not filled out

            if (!style.isEmpty()) {
                values.put(BeerDataContract.BeerEntry.COLUMN_BEER_STYLE, style);
            }

            if (!brewery.isEmpty()) {
                values.put(BeerDataContract.BeerEntry.COLUMN_BEER_BREWERY, brewery);
            }

            if (!editABV.getText().toString().trim().isEmpty()) {
                values.put(BeerDataContract.BeerEntry.COLUMN_BEER_ABV, Float.parseFloat(editABV.getText().toString().trim()));
            }

            if (!editIBU.getText().toString().trim().isEmpty()) {
                values.put(BeerDataContract.BeerEntry.COLUMN_BEER_IBU, Integer.parseInt(editIBU.getText().toString().trim()));
            }

            if (!comments.isEmpty()) {
                values.put(BeerDataContract.BeerEntry.COLUMN_BEER_COMMENTS, comments);
            }

            if (!ratingText.getText().toString().trim().isEmpty()) {
                values.put(BeerDataContract.BeerEntry.COLUMN_BEER_RATING, Float.parseFloat(ratingText.getText().toString().trim()));
            }

            // store the row ids?
            long rowID = db.insert(BeerDataContract.BeerEntry.TABLE_NAME, null, values);
            Log.d(this.getClass().getSimpleName(), "Inserting: " + values);
            finish();

        } else {

            Toast toast = Toast.makeText(this, "Beer name needed for entry", Toast.LENGTH_SHORT);
            toast.show();

        }


    }

    @Override
    protected void onDestroy () {
        dbHelper.close();
        super.onDestroy();
    }

}
