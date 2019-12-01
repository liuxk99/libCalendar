package com.sj.lib.calander;

import java.util.Calendar;

public class DateCategory {
    int year;
    int month;
    int day;

    // 是否为工作日
    boolean isWorkday = false;

    final static String WORKDAY = "WorkDay";
    final static String RESTDAY = "Rest Day";

    public DateCategory(int year, int month, int day, boolean isWorkday) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.isWorkday = isWorkday;
    }

    public DateCategory(Calendar calendar, boolean isWorkday) {
        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH) + 1;
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
        this.isWorkday = isWorkday;
    }

    public DateCategory(Calendar calendar) {
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
        final String category = isWorkday ? WORKDAY : RESTDAY;
        return String.format("%04d/%02d/%02d", year, month, day) + ": " + category;
    }
}
