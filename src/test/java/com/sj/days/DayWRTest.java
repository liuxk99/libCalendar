package com.sj.days;

import com.sj.days.DayWR;
import com.sj.days.HolidayCalendarByGov;
import com.sj.days.HolidayCalendarByGov2019;
import com.sj.days.HolidayCalendarByGov2020;
import com.sj.time.CalendarUtils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class DayWRTest {

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
        DayWR category = new DayWR(2019, 12, 1, false);
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

        DayWR dayWR = new DayWR(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH), isWorkday);
        System.out.println(dayWR.toString());

        calendar.add(Calendar.DAY_OF_YEAR, 1);
        dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (Calendar.MONDAY <= dayOfWeek && dayOfWeek <= Calendar.FRIDAY) {
            isWorkday = true;
        }
        dayWR = new DayWR(calendar, isWorkday);
        System.out.println(dayWR.toString());
    }

    @Test
    public void testcase_002() throws Exception {
        List<DayWR> dayWRList = new ArrayList<DayWR>();

        HolidayCalendarByGov holidayCalendarByGov = new HolidayCalendarByGov2019();
        holidayCalendarByGov.adjustCalendar();

        Calendar calendar = holidayCalendarByGov.getFirstDay();
        Calendar lastDay = holidayCalendarByGov.getLastDay();
        lastDay.add(Calendar.DAY_OF_YEAR, 1);

        while (calendar.before(lastDay)) {
            Boolean isWorkDay = holidayCalendarByGov.dateInfoMap.get(calendar);
            if (isWorkDay != null) {
                dayWRList.add(new DayWR(calendar, isWorkDay));
            } else {
                dayWRList.add(new DayWR(calendar));
            }
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }

        for (DayWR dayWR : dayWRList) {
            System.out.println(dayWR.toString());
        }
    }

    @Test
    public void testcase_Maps() {
        Calendar calendar = CalendarUtils.getDate(2019, 1, 1);
//        CalendarUtils.dump(calendar);

        Boolean isWorkDay = holidayCalendarByGov.dateInfoMap.get(calendar);
        assertNotNull(isWorkDay);

        DayWR dayWR = new DayWR(calendar, isWorkDay);
        System.out.println(dayWR.toString());
    }

    @Test
    public void testcase004_Maps() {
        HolidayCalendarByGov holidayCalendarByGov = new HolidayCalendarByGov2020();
        holidayCalendarByGov.adjustCalendar();

        Calendar calendar = CalendarUtils.getDate(2020, 1, 1);
        Boolean isWorkDay = holidayCalendarByGov.dateInfoMap.get(calendar);
        assertNotNull(isWorkDay);

        Calendar cal = holidayCalendarByGov.getFirstDay();
        Calendar endDay = holidayCalendarByGov.getLastDay();
        endDay.add(Calendar.DAY_OF_YEAR, 1);
        while (cal.before(endDay)) {
            DayWR dayWR = new DayWR(cal, holidayCalendarByGov.dateInfoMap.get(cal));
            System.out.println(dayWR.toString());

            cal.add(Calendar.DAY_OF_YEAR, 1);
        }
    }

    @Test
    public void testcase005_Maps() {
        HolidayCalendarByGov holidayCalendarByGov = new HolidayCalendarByGov2021();
        holidayCalendarByGov.adjustCalendar();

        Calendar calendar = CalendarUtils.getDate(2021, 1, 1);
        Boolean isWorkDay = holidayCalendarByGov.dateInfoMap.get(calendar);
        assertNotNull(isWorkDay);

        Calendar cal = holidayCalendarByGov.getFirstDay();
        Calendar endDay = holidayCalendarByGov.getLastDay();
        endDay.add(Calendar.DAY_OF_YEAR, 1);
        while (cal.before(endDay)) {
            DayWR dayWR = new DayWR(cal, holidayCalendarByGov.dateInfoMap.get(cal));
            System.out.println(dayWR.toString());

            cal.add(Calendar.DAY_OF_YEAR, 1);
        }
    }
}