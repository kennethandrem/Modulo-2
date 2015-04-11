package com.kennethandre.modulo_2;

import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;


public class Orden extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden);

        Resources resources = getResources();

        TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("mitab1");
        tabSpec.setContent(R.id.tabContenedor1);
        tabSpec.setIndicator("", resources.getDrawable(android.R.drawable.ic_btn_speak_now));
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("mitab2");
        tabSpec.setContent(R.id.tabContenedor2);
        tabSpec.setIndicator("TAB2", resources.getDrawable(android.R.drawable.ic_dialog_map));
        tabHost.addTab(tabSpec);

        tabHost.setCurrentTab(0);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_orden, menu);
        return true;
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

