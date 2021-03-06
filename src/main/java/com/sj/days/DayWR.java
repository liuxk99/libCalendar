package com.sj.days;

import java.util.Calendar;

public class DayWR {
    private int year;
    private int month;
    private int day;

    // 是否为工作日
    private boolean isWorkday = false;

    final static String WORKDAY = "WorkDay";
    final static String RESTDAY = "Rest Day";

    final static String WORKDAY_NARROW = "W[工]";
    final static String RESTDAY_NARROW = "R[休]";

    public DayWR(int year, int month, int day, boolean isWorkday) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.isWorkday = isWorkday;
    }

    public DayWR(Calendar calendar, boolean isWorkday) {
        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH) + 1;
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
        this.isWorkday = isWorkday;
    }

    public DayWR(Calendar calendar) {
        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH) + 1;
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (Calendar.MONDAY <= dayOfWeek && dayOfWeek <= Calendar.FRIDAY){
            isWorkday = true;
        }
    }

    @Override
    public String toString() {
        final String category = isWorkday ? WORKDAY_NARROW : RESTDAY_NARROW;
        return String.format("%04d/%02d/%02d", year, month, day) + ": " + category;
    }
}
