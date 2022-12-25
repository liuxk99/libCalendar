package com.sj.days;

import com.sj.time.CalendarUtils;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public abstract class HolidayCalendarByGov {
    protected Map<Calendar, Boolean> dateInfoMap = new HashMap<Calendar, Boolean>();

    abstract void adjustCalendar();
    abstract Calendar getFirstDay();
    abstract Calendar getLastDay();

    void dump() {
        System.out.println("---");
        for (Calendar calendar : dateInfoMap.keySet()) {
            CalendarUtils.dump(calendar);
        }
        System.out.println("---");
    }

    void dumpHoliday() {
        Calendar calendar = getFirstDay();
        Calendar lastDay = getLastDay();
        lastDay.add(Calendar.DAY_OF_YEAR, 1);

        while (calendar.before(lastDay)) {
            Boolean isWorkDay = dateInfoMap.get(calendar);
            if (isWorkDay == null) {
                CalendarUtils.dump(calendar);
                System.out.println("Error: date map is not completed!");
            } else {
                if (!isWorkDay){
                    DayWR dayWR = new DayWR(calendar, false);
                    System.out.println(dayWR.toString());
                }
            }
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }
    }
}
