package com.sj.days;

import com.sj.days.HolidayCalendarByGov2019;
import com.sj.time.CalendarUtils;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertNotNull;

public class HolidayByGovTest {

    private HolidayCalendarByGov holidayByGov;

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void adjustCalendar() {
        holidayByGov.dump();
    }

    @Test
    public void testcase_Maps() {
        Calendar calendar = CalendarUtils.getDate(2025, 1, 1);
//        CalendarUtils.dump(calendar);

        Boolean isWorkDay = holidayByGov.dateInfoMap.get(calendar);
        assertNotNull(isWorkDay);
    }

    @Test
    public void testcase_CalendarByGov() throws Exception {
        holidayByGov = new HolidayCalendarByGov2025();
        holidayByGov.adjustCalendar();
        holidayByGov.dump();
    }
}