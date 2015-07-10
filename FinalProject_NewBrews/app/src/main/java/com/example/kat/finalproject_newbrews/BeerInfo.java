package com.example.kat.finalproject_newbrews;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.net.URL;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Functions for Beer Info page (that is pulled up from Latest Releases)
 */
public class BeerInfo extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_info);

        Bundle bn = getIntent().getExtras();
        final int idtemp = bn.getInt("idbeer");
        final String idvalue = Integer.toString(idtemp);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {

                    URL url = new URL("http://cs1.whitworth.edu/nbrews/NBrewerys.php?BeerID=" + idvalue);

                    SAXParserFactory factory = SAXParserFactory.newInstance();
                    SAXParser parser = factory.newSAXParser();
                    final BeerEntryHandler handler = new BeerEntryHandler();
                    parser.parse(url.openStream(), handler);


                    final Handler h = new Handler(Looper.getMainLooper()) {
                        @Override
                        public void handleMessage(Message m) {
                            String name = handler.get_entries().get(0).get_Craft_Beer_Name();
                            TextView bname = (TextView) BeerInfo.this.findViewById(R.id.craftname);
                            bname.setText(name);


                            String brewname = handler.get_entries().get(0).get_Craft_Beer_Brewer();
                            TextView brewertx = (TextView) BeerInfo.this.findViewById(R.id.brewer);
                            brewertx.setText(brewname);


                            String release = handler.get_entries().get(0).get_Craft_Beer_BrewRelease();
                            TextView rel = (TextView) BeerInfo.this.findViewById(R.id.date);
                            rel.setText(release);

                            String acbv = handler.get_entries().get(0).get_Craft_Beer_ABV();
                            TextView byvolume = (TextView) BeerInfo.this.findViewById(R.id.ABV);
                            byvolume.setText(acbv + " ABV");

                            String bdescrip = handler.get_entries().get(0).get_Craft_Beer_Description();
                            TextView beerdescription = (TextView) BeerInfo.this.findViewById(R.id.beerdescription);
                            beerdescription.setText(bdescrip);


                        }
                    };
                    h.obtainMessage().sendToTarget();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };
        new Thread(r).start();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_beer_info, menu);
        return true;
    }

    /**
     * OnClick function for home button on page (pulls up home screen)
     *
     * @param v
     */
    public void beerinfohomeOnClick(View v) {
        Button b = (Button) v;
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    /**
     * OnClick function for back button on page (pulls up previous screen)
     *
     * @param v
     */
    public void beerinfobackOnClick(View v) {
        Button b = (Button) v;
        startActivity(new Intent(getApplicationContext(), LatestReleases.class));
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
