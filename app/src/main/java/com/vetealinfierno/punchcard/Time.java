package com.vetealinfierno.punchcard;

import java.util.Calendar;
import static java.util.Calendar.getInstance;


public class Time {
    private int Hour;
    private int Min;
    private int Sec;
    private int AMpm;
    private Calendar c;


    public Time() {
        Hour = 0;
        Min = 0;
        Sec = 0;
        AMpm = 0;
        c = getInstance();
    }

    public int getHour() {
        return Hour;
    }

    public int getMin() {
        return Min;
    }

    public int getSec() {
        return Sec;
    }

    public int getAMpm() {
        return AMpm;
    }

    public void setCurrentTime() {
        setHour();
        setMin();
        setSec();
        setAMpm();
    }

    public void setHour() {
        Hour = c.get(Calendar.HOUR_OF_DAY);
    }

    public void setMin() {
        Min = c.get(Calendar.MINUTE);
    }

    public void setSec() {
        Sec = c.get(Calendar.SECOND);
    }

    public void setAMpm() {
        AMpm = c.get(Calendar.AM_PM);
    }
}
