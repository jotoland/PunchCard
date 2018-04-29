package com.vetealinfierno.punchcard;


// Employee is for each user, stores name, timeIN/Out and breaks
public class Employee {
    //region Private Vars ####
    private String Name;
    private Time clockIn;
    private Time clockOut;
    private Time empBreak;
    private Day today;
    //endregion

    //region Constructor ####
    public Employee() {
        Name = "";
        clockIn = new Time();
        clockOut = new Time();
        empBreak = new Time();
        today = new Day();
    }
    //endregion

    public Day Today() {
        return today;
    }


    public String getName() {
        return Name;
    }

    public Time getClockIn() {
        return clockIn;
    }

    public Time getClockOut() {
        return clockOut;
    }

    public Time getEmpBreak() {
        return empBreak;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setClockIn(Time clockIn) {
        this.clockIn = clockIn;
    }

    public void setClockOut(Time clockOut) {
        this.clockOut = clockOut;
    }

    public void setEmpBreak(Time empBreak) {
        this.empBreak = empBreak;
    }
}
