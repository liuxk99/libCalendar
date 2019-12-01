package com.sj.lib.calander;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public abstract class HolidayByGov {
    protected Map<Calendar, Boolean> dateCategoryMap = new HashMap<Calendar, Boolean>();

    abstract void adjustCalendar();

    void dump() {
        System.out.println("---");
        for (Calendar calendar : dateCategoryMap.keySet()) {
            CalendarUtils.dump(calendar);
        }
        System.out.println("---");
    }
}
