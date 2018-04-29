package com.vetealinfierno.punchcard;

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

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //region Private variables ####
    private Employee emp;
    //endregion

    //region Protected OnCreate Method ####
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            // This is the email button on the main activity
            @Override
            public void onClick(View view) {
                snackBar(view, "Replace with your own action", true);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // TODO this needs to be done on first use of app, hook up to Firebase or Loca file?
        emp = new Employee();
        emp.setName("Doug Funny");
    }
    //endregion

    //region Public OnNavigationDrawer Methods ####
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    //endregion

    //region Public Toast/SnackBar Methods ####
    public void print(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void snackBar(View view, String message, boolean listner) {
        if(listner) {
            // TODO add a listner
            Snackbar.make(view, message, 60000)
                    .setAction("Action", null).show();
        } else {
            Snackbar.make(view, message, 60000).show();
        }
    }
    //endregion

    public String convertAMPM(int amPm) {
        if (amPm == 1) { return "PM"; } else { return "AM"; }
    }

    public int convertHour(int hour) {
        if (hour > 12) { return hour - 12; } else { return hour; }
    }

    public String caveManTime(boolean isClockIn, boolean empBreak) {
        Calendar c = cal();
        Time empTimeStamp = new Time();
        if(empBreak) {
            //TODO implement employee on break
        } else {
            if(isClockIn) {
                empTimeStamp = emp.getClockIn();

            } else {
                empTimeStamp = emp.getClockOut();
            }
        }
        int hour = convertHour(empTimeStamp.getHour());

        return (
                emp.Today().getDayOfTheWeek() + " " + emp.Today().getMonth() + " / " + emp.Today().getDay() + " / " + emp.Today().getYear()
                        + " @ " + hour + ":" + empTimeStamp.getMin() + ":" + empTimeStamp.getSec() + "  " + convertAMPM(empTimeStamp.getAMpm())
        );
    }

    public Calendar cal() {
        return Calendar.getInstance();
    }

    public Time getTimeStamp() {
        Time timeStamp = new Time();
        timeStamp.setCurrentTime();
        return timeStamp;
    }

    //region Public OnClick Methods ####
    public void onClickClockIn(View view) {
        emp.setClockIn(getTimeStamp());
        snackBar(view, "Clock IN: " + caveManTime(true, false), false);
    }

    public void onClickClockOut(View view) {
        emp.setClockOut(getTimeStamp());
        snackBar(view, "Clock OUT: " + caveManTime(false, false), false);
    }
    //endregion
}
