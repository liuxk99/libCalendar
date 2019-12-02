package com.sj.lib.calander;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalendarFactory {
    private static CalendarFactory mInstance;

    public static CalendarFactory getInstance() {
        if (mInstance == null) {
            mInstance = new CalendarFactory();
        }
        return mInstance;
    }

    public Map<Calendar, Boolean> generateCalendarMap() {
        List<HolidayCalendarByGov> calendarByGovList = new ArrayList<HolidayCalendarByGov>();

        HolidayCalendarByGov cal = new HolidayCalendarByGov2019();
        calendarByGovList.add(cal);

        Map<Calendar, Boolean> map = new HashMap<Calendar, Boolean>();
        for (HolidayCalendarByGov calendarByGov : calendarByGovList) {
            calendarByGov.adjustCalendar();
            map.putAll(calendarByGov.dateInfoMap);
        }

        return map;
    }
}
