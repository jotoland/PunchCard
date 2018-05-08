package com.vetealinfierno.punchcard;

import java.text.SimpleDateFormat;
import static java.util.Calendar.getInstance;

import java.util.Calendar;
import java.util.Locale;

public class Day {

    //region Private Variables ####
    private Calendar c;
    private String DayOfTheWeek;
    private int Month;
    private int Day;
    private int Year;
    //endregion

    //regionn Constructor ####
    public Day() {
        c = getInstance();
        DayOfTheWeek = sDate().substring(0, sDate().indexOf(','));;
        Month = c.get(Calendar.MONTH);
        Day = c.get(Calendar.DAY_OF_MONTH);
        Year = c.get(Calendar.YEAR);
    }
    //endregion

    //region Private Methods ####
    private String sDate() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("E, MMM dd, yyyy", Locale.getDefault());
        return (sdfDate.format(c.getTime()));
    }
    //endregion

    //region Public Getters ####
    public String getDayOfTheWeek() {
        return DayOfTheWeek;
    }

    public int getMonth() {
        return Month;
    }

    public int getDay() {
        return Day;
    }

    public int getYear() {
        return Year;
    }
    //endregion
}
