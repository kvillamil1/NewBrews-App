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

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


/**
 * Functions for Bar/Restaurant Info page
 */
public class BarResPage extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_res_page);
        Bundle bn = getIntent().getExtras();
        final int idtemp = bn.getInt("idbar");
        final String idvalue = Integer.toString(idtemp);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {

                    URL url = new URL("http://cs1.whitworth.edu/nbrews/NBrewerys.php?RestNum=" + idvalue);

                    SAXParserFactory factory = SAXParserFactory.newInstance();
                    SAXParser parser = factory.newSAXParser();
                    final RestEntryHandler handler = new RestEntryHandler();
                    parser.parse(url.openStream(), handler);


                    final Handler h = new Handler(Looper.getMainLooper()) {
                        @Override
                        public void handleMessage(Message m) {
                            String name = handler.get_types().get(0).getTypeName();
                            TextView rname = (TextView) BarResPage.this.findViewById(R.id.name);
                            rname.setText(name);


                            String pnum = handler.get_types().get(0).getRestPhone();
                            String num = String.format("%s.%s.%s", pnum.substring(0, 3), pnum.substring(3, 6),
                                    pnum.substring(6, 10));
                            TextView rphone = (TextView) BarResPage.this.findViewById(R.id.phone);
                            rphone.setText(num);


                            String formraddress = handler.get_types().get(0).getRestAddress() + " "
                                    + handler.get_types().get(0).getRestCity() + ", "
                                    + handler.get_types().get(0).getRestState() + " "
                                    + handler.get_types().get(0).getRestZip();
                            TextView raddress = (TextView) BarResPage.this.findViewById(R.id.address);
                            raddress.setText(formraddress);


                            String descrip = handler.get_types().get(0).getRestDescription();
                            TextView rdescription = (TextView) BarResPage.this.findViewById(R.id.description);
                            rdescription.setText(descrip);

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
        getMenuInflater().inflate(R.menu.menu_bar_res_page, menu);
        return true;
    }

    /**
     * OnClick function for home button on page (pulls up home screen)
     *
     * @param v
     */
    public void brhomeOnClick(View v) {
        Button b = (Button) v;
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    /**
     * OnClick function for back button on page (pulls up previous screen)
     *
     * @param v
     */
    public void brbackOnClick(View v) {
        Button b = (Button) v;
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
