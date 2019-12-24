package com.sj.lib.calander;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalendarFactory {
    private static CalendarFactory mInstance;
    public Map<Calendar, Boolean> calendarMap = new HashMap<Calendar, Boolean>();

    public static CalendarFactory getInstance() {
        if (mInstance == null) {
            mInstance = new CalendarFactory();
        }
        mInstance.generateCalendarMap();

        return mInstance;
    }

    public Map<Calendar, Boolean> generateCalendarMap() {
        List<HolidayCalendarByGov> calendarByGovList = new ArrayList<HolidayCalendarByGov>();

        calendarByGovList.add(new HolidayCalendarByGov2019());
        calendarByGovList.add(new HolidayCalendarByGov2020());

        for (HolidayCalendarByGov calendarByGov : calendarByGovList) {
            calendarByGov.adjustCalendar();
            calendarMap.putAll(calendarByGov.dateInfoMap);
        }

        return calendarMap;
    }
}
