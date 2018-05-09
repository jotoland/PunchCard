package com.vetealinfierno.punchcard;

import java.util.Calendar;
import static java.util.Calendar.getInstance;

public class Time {

    //region Private Variables ####
    private int Hour;
    private int Min;
    private int Sec;
    private int AMpm;
    private Calendar c;
    //endregion

    //region Constructor ####
    Time() {
        Hour = 0;
        Min = 0;
        Sec = 0;
        AMpm = 0;
        c = getInstance();
    }
    //endregion

    //region Public Getters ####
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
    //endregion

    //region Public Clock Setters ####
    public void setCurrentTime() {
        setHour();
        setMin();
        setSec();
        setAMpm();
    }

    private void setHour() {
        this.Hour = c.get(Calendar.HOUR_OF_DAY);
    }

    private void setMin() {
        this.Min = c.get(Calendar.MINUTE);
    }

    private void setSec() {
        this.Sec = c.get(Calendar.SECOND);
    }

    private void setAMpm() {
        this.AMpm = c.get(Calendar.AM_PM);
    }

    public void setEmpHour(int hour) {
        this.Hour = hour;
    }

    public void setEmpMin(int min) {
        this.Min = min;
    }

    public void setEmpSec(int sec) {
        this.Sec = sec;
    }
    //endregion
}
