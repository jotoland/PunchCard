package com.vetealinfierno.punchcard;

import java.util.ArrayList;

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
    private Day today;
    private ArrayList<Integer> empBrkInSecList;
    private ArrayList<Time> empBrkTStpList;
    // TODO Do we need this ??
    //private List<Integer> empShifts;
    //endregion

    //region Constructor ####
    // No modifier is package-private (default)
    Employee() {
        Name = "Doug Funny";
        clockIn = new Time();
        clockOut = new Time();
        empBrkStart = new Time();
        empBrkEnd = new Time();
        today = new Day();
        empBrkInSecList = new ArrayList<>(MAX_BREAKS);
        empBrkTStpList = new ArrayList<>(MAX_BREAKS);
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

    public ArrayList<Integer> getEmpBrkInSecList(){
        return empBrkInSecList;
    }

    public ArrayList<Time> getEmpBrkTStpList() {
        return empBrkTStpList;
    }

    public int getBrkTSpListSize() {
        return empBrkTStpList.size();
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
        if (getBrkTSpListSize() == MAX_BREAKS) {
            return;
        }
    }

    public void setEmpBrkEnd(Time empBrkEnd) {
        this.empBrkEnd = empBrkEnd;
        captureBrk(this.empBrkStart, this.empBrkEnd);
    }
    //endregion

    //region Private Methods: Breaks ####
    private void captureBrk(Time brkStart, Time brkEnd) {
        Time brkIntervalTStp = new Time();
        brkIntervalTStp.setEmpHour(brkEnd.getHour() - brkStart.getHour());
        brkIntervalTStp.setEmpMin(brkEnd.getMin() -  brkStart.getMin());
        brkIntervalTStp.setEmpSec(brkEnd.getSec() - brkStart.getSec());
        // TODO implement a TYPE of breaks, like lunch and general or what not...
        this.empBrkTStpList.add(brkIntervalTStp);
        this.empBrkInSecList.add(getIntervalInSeconds(brkIntervalTStp.getHour(), brkIntervalTStp.getMin(), brkIntervalTStp.getSec()));
    }

    private int getIntervalInSeconds(int hour, int min, int sec) {
        return (hour * 3600 + min * 60 + sec);
    }
    //endregion

}
