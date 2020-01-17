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
}
