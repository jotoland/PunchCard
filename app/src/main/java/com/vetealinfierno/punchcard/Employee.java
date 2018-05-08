package com.vetealinfierno.punchcard;


// Employee is for each user, stores name, timeIN/Out and breaks
public class Employee {

    //region Private Vars ####
    private String Name;
    private Time clockIn;
    private Time clockOut;
    private Time empBrkStart;
    private Time empBrkEnd;
    private Day today;
    //endregion

    //region Constructor ####
    public Employee() {
        Name = "";
        clockIn = new Time();
        clockOut = new Time();
        empBrkStart = new Time();
        empBrkEnd = new Time();
        today = new Day();
    }
    //endregion

    //region Public Getters ####
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

    public Time getEmpBrkStart() {
        return empBrkStart;
    }

    public Time getEmpBrkEnd() { return empBrkEnd; }
    //endregion

    //region Public Setters ####
    public void setName(String name) {
        Name = name;
    }

    public void setClockIn(Time clockIn) {
        this.clockIn = clockIn;
    }

    public void setClockOut(Time clockOut) {
        this.clockOut = clockOut;
    }

    public void setEmpBrkStart(Time empBrkStart) {
        this.empBrkStart = empBrkStart;
    }

    public void setEmpBrkEnd(Time empBrkEnd) { this.empBrkEnd = empBrkEnd; }
    //endregion
}
