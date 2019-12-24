package com.sj.lib.calander;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class DateInfoTest {

    private HolidayCalendarByGov holidayCalendarByGov;

    @org.junit.Before
    public void setUp() throws Exception {
        holidayCalendarByGov = new HolidayCalendarByGov2019();
        holidayCalendarByGov.adjustCalendar();
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void toString1() {
        DateInfo category = new DateInfo(2019, 12, 1, false);
        System.out.println(category.toString());

    }

    @Test
    public void testcase_001() throws Exception {
        Calendar calendar = Calendar.getInstance();
        boolean isWorkday = false;
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (Calendar.MONDAY <= dayOfWeek && dayOfWeek <= Calendar.FRIDAY) {
            isWorkday = true;
        }

        DateInfo dateInfo = new DateInfo(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH), isWorkday);
        System.out.println(dateInfo.toString());

        calendar.add(Calendar.DAY_OF_YEAR, 1);
        dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (Calendar.MONDAY <= dayOfWeek && dayOfWeek <= Calendar.FRIDAY) {
            isWorkday = true;
        }
        dateInfo = new DateInfo(calendar, isWorkday);
        System.out.println(dateInfo.toString());
    }

    @Test
    public void testcase_002() throws Exception {
        List<DateInfo> dateInfoList = new ArrayList<DateInfo>();

        HolidayCalendarByGov holidayCalendarByGov = new HolidayCalendarByGov2019();
        holidayCalendarByGov.adjustCalendar();

        Calendar calendar = holidayCalendarByGov.getFirstDay();
        Calendar lastDay = holidayCalendarByGov.getLastDay();
        lastDay.add(Calendar.DAY_OF_YEAR, 1);

        while (calendar.before(lastDay)) {
            Boolean isWorkDay = holidayCalendarByGov.dateInfoMap.get(calendar);
            if (isWorkDay != null) {
                dateInfoList.add(new DateInfo(calendar, isWorkDay));
            } else {
                dateInfoList.add(new DateInfo(calendar));
            }
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }

        for (DateInfo dateInfo : dateInfoList) {
            System.out.println(dateInfo.toString());
        }
    }

    @Test
    public void testcase_Maps() {
        Calendar calendar = CalendarUtils.genDate(2019, 1, 1);
//        CalendarUtils.dump(calendar);

        Boolean isWorkDay = holidayCalendarByGov.dateInfoMap.get(calendar);
        assertNotNull(isWorkDay);

        DateInfo dateInfo = new DateInfo(calendar, isWorkDay);
        System.out.println(dateInfo.toString());
    }

    @Test
    public void testcase004_Maps() {
        HolidayCalendarByGov holidayCalendarByGov = new HolidayCalendarByGov2020();
        holidayCalendarByGov.adjustCalendar();

        Calendar calendar = CalendarUtils.genDate(2020, 1, 1);
        Boolean isWorkDay = holidayCalendarByGov.dateInfoMap.get(calendar);
        assertNotNull(isWorkDay);

        Calendar cal = holidayCalendarByGov.getFirstDay();
        Calendar endDay = holidayCalendarByGov.getLastDay();
        endDay.add(Calendar.DAY_OF_YEAR, 1);
        while (cal.before(endDay)) {
            DateInfo dateInfo = new DateInfo(cal, holidayCalendarByGov.dateInfoMap.get(cal));
            System.out.println(dateInfo.toString());

            cal.add(Calendar.DAY_OF_YEAR, 1);
        }
    }
}