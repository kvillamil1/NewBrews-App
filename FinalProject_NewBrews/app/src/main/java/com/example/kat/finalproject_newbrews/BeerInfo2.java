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
 * Functions for Beer Info page (that is pulled from Beers of Type)
 */
public class BeerInfo2 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_info2);
        Bundle bn = getIntent().getExtras();
        final int idtemp = bn.getInt("idbeer2");
        final String idvalue2 = Integer.toString(idtemp);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {

                    URL url = new URL("http://cs1.whitworth.edu/nbrews/NBrewerys.php?BeerID=" + idvalue2);

                    SAXParserFactory factory = SAXParserFactory.newInstance();
                    SAXParser parser = factory.newSAXParser();
                    final BeerEntryHandler handler = new BeerEntryHandler();
                    parser.parse(url.openStream(), handler);


                    final Handler h = new Handler(Looper.getMainLooper()) {
                        @Override
                        public void handleMessage(Message m) {
                            String name2 = handler.get_entries().get(0).get_Craft_Beer_Name();
                            TextView bname2 = (TextView) BeerInfo2.this.findViewById(R.id.craftname2);
                            bname2.setText(name2);


                            String brewname2 = handler.get_entries().get(0).get_Craft_Beer_Brewer();
                            TextView brewertx2 = (TextView) BeerInfo2.this.findViewById(R.id.brewer2);
                            brewertx2.setText(brewname2);


                            String release2 = handler.get_entries().get(0).get_Craft_Beer_BrewRelease();
                            TextView rel2 = (TextView) BeerInfo2.this.findViewById(R.id.date2);
                            rel2.setText(release2);

                            String acbv2 = handler.get_entries().get(0).get_Craft_Beer_ABV();
                            TextView byvolume2 = (TextView) BeerInfo2.this.findViewById(R.id.ABV2);
                            byvolume2.setText(acbv2 + " ABV");

                            String bdescrip2 = handler.get_entries().get(0).get_Craft_Beer_Description();
                            TextView beerdescription2 = (TextView) BeerInfo2.this.findViewById(R.id.beerdescription2);
                            beerdescription2.setText(bdescrip2);


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
        getMenuInflater().inflate(R.menu.menu_beer_info2, menu);
        return true;
    }

    /**
     * OnClick function for home button on page (pulls up home screen)
     *
     * @param v
     */
    public void beerinfo2homeOnClick(View v) {
        Button b = (Button) v;
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    /**
     * OnClick function for back button on page (pulls up previous screen)
     *
     * @param v
     */
    public void beerinfo2backOnClick(View v) {
        Button b = (Button) v;
        startActivity(new Intent(getApplicationContext(), TypesofBeer.class));

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
