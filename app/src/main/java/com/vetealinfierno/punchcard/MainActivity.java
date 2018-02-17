package com.vetealinfierno.punchcard;
//******** 2/3/18 jGAT
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String[][] timeSheet = new String[100][100];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackBar(view, "Opening Mail");
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //region Options Menu Region ###################################################################
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    //endregion
    public String caveManTime() {
        Calendar c = cal();
        int amPm = c.get(Calendar.AM_PM);
        String sAmPm;
        int hour = c.get(Calendar.HOUR_OF_DAY);
        if (hour > 12) { hour = hour - 12; }
        if (amPm == 1) { sAmPm = "PM"; } else { sAmPm = "AM"; }
        String dayOfWeek = sDate().substring(0, sDate().indexOf(','));
        return (
            dayOfWeek + " " + c.get(Calendar.MONTH) + " / " + c.get(Calendar.DAY_OF_MONTH) + " / " + c.get(Calendar.YEAR)
            + " @ " + hour + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) + "  " + sAmPm
        );
    }

    public Calendar cal() {
        return Calendar.getInstance();
    }

    public String sTime() {
        SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm:ss aaa", Locale.getDefault());
        return (sdfTime.format(cal().getTime()));
    }

    public String sDate() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("E, MMM dd, yyyy", Locale.getDefault());
        return (sdfDate.format(cal().getTime()));
    }

    //region Button Click Region ###################################################################
    public void onClickClockIn(View view) {
        // TODO create time stamp
        snackBar(view, "Clock IN: " + caveManTime());
    }

    public void onClickClockOut(View view) {
        snackBar(view, "Clock OUT: " + caveManTime());
    }
    //endregion

    //region Toast/SnackBar Region #####################################################
    public void print(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void snackBar(View view, String message) {
        Snackbar.make(view, message, 60000)
                .setAction("Action", null).show();
    }
    //endregion

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            print("Camera Click");
        } else if (id == R.id.nav_gallery) {
            print("Gallery Click");
        } else if (id == R.id.nav_slideshow) {
            print("SlideShow Click");
        } else if (id == R.id.nav_manage) {
            print("Manage Click");
        } else if (id == R.id.nav_share) {
            print("Share Click");
        } else if (id == R.id.nav_send) {
            print("Send Click");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
