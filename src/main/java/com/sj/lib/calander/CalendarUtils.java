package com.sj.lib.calander;

import java.util.Calendar;

public class CalendarUtils {
    public static void dump(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        int month= calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        System.out.println(String.format("%d %04d/%02d/%02d", dayOfWeek, year, month, day));
    }

    static Calendar genDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        return genDate(calendar, year, month, day);
    }

    private static Calendar genDate(Calendar calendar, int year, int month, int day) {
        Calendar cal = (Calendar) calendar.clone();
        cal.clear();
        cal.set(year, month - 1, day);
        return cal;
    }
}
