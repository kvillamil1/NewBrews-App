package com.example.kat.finalproject_newbrews;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Functions for Home page
 */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * onClick function for Latest Releases button (pulls up Latest Releases page)
     *
     * @param v
     */
    public void latestOnClick(View v) {
        Button typeButton = (Button) v;
        startActivity(new Intent(getApplicationContext(), LatestReleases.class));
    }

    /**
     * onClick function for Types of Beers button (pulls up Types of Beers page)
     *
     * @param v
     */
    public void typeOnClick(View v) {
        Button typeButton = (Button) v;
        startActivity(new Intent(getApplicationContext(), TypesofBeer.class));
    }

    /**
     * onClick function for Bars/Restaurants button (pulls up Bars/Restaurants main page)
     *
     * @param v
     */
    public void barOnClick(View v) {
        Button barButton = (Button) v;
        startActivity(new Intent(getApplicationContext(), BarsRestaurants.class));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
