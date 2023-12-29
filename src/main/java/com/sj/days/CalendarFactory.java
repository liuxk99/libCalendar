package com.sj.days;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalendarFactory {
    private static CalendarFactory mInstance;
    public Map<Calendar, Boolean> calendarMap = new HashMap<Calendar, Boolean>();

    public CalendarFactory() {
        generateCalendarMap();
    }

    public static CalendarFactory getInstance() {
        if (mInstance == null) {
            mInstance = new CalendarFactory();
        }

        return mInstance;
    }

    public Map<Calendar, Boolean> generateCalendarMap() {
        List<HolidayCalendarByGov> calendarByGovList = new ArrayList<HolidayCalendarByGov>();

        calendarByGovList.add(new HolidayCalendarByGov2019());
        calendarByGovList.add(new HolidayCalendarByGov2020());
        calendarByGovList.add(new HolidayCalendarByGov2021());
        calendarByGovList.add(new HolidayCalendarByGov2022());
        calendarByGovList.add(new HolidayCalendarByGov2023());
        calendarByGovList.add(new HolidayCalendarByGov2024());

        for (HolidayCalendarByGov calendarByGov : calendarByGovList) {
            calendarByGov.adjustCalendar();
            calendarMap.putAll(calendarByGov.dateInfoMap);
        }

        return calendarMap;
    }
}
