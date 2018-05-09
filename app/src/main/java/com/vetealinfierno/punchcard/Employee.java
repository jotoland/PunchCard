package com.vetealinfierno.punchcard;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

// Employee is for each user, stores name, timeIN/Out and breaks
public class Employee {

    //region Private Constants ####
    private final int MAX_BREAKS = 10;
    //endregion

    //region Private Vars ####
    private String Name;
    private Time clockIn;
    private Time clockOut;
    private Time empBrkStart;
    private Time empBrkEnd;
    private Time brkIntervalTStp;
    private Day today;
    //private List<Integer> empShifts;  // TODO Do we need this ??
    private HashMap<String, Integer> empBreaks;
    //endregion

    //region Constructor ####
    // No modifier is package-private
    Employee() {
        Name = "Doug Funny";
        clockIn = new Time();
        clockOut = new Time();
        empBrkStart = new Time();
        empBrkEnd = new Time();
        today = new Day();
        empBreaks = new HashMap<>(MAX_BREAKS);
        //empShifts = new ArrayList<>();
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

    public Time getEmpBrkEnd() {
        return empBrkEnd;
    }

    public HashMap<String, Integer> getEmpBrks(){
        return empBreaks;
    }

    public Time getEmpBrkInterval() {
        return brkIntervalTStp;
    }
    //endregion

    //region Public Setters ####
    public void setName(String name) {
        this.Name = name;
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

    public void setEmpBrkEnd(Time empBrkEnd) {
        this.empBrkEnd = empBrkEnd;
        calculateBreakInterval(this.empBrkStart, this.empBrkEnd);
    }

    private void setEmpBreaks(String type, int breakInterval) {
        this.empBreaks.put(type, breakInterval);
    }
    //endregion

    private void calculateBreakInterval(Time brkStart, Time brkEnd) {
        brkIntervalTStp = new Time();
        brkIntervalTStp.setEmpHour(brkEnd.getHour() - brkStart.getHour());
        brkIntervalTStp.setEmpMin(brkEnd.getMin() -  brkStart.getMin());
        brkIntervalTStp.setEmpSec(brkEnd.getSec() - brkStart.getSec());
        // TODO implement a TYPE of breaks, like lunch and general or what not...
        setEmpBreaks("GEN", getIntervalInSeconds(brkIntervalTStp.getHour(), brkIntervalTStp.getMin(), brkIntervalTStp.getSec()));
    }

    private int getIntervalInSeconds(int hour, int min, int sec) {
        return (hour * 3600 + min * 60 + sec);
    }

}
