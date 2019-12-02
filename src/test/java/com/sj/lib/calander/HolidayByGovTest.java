package com.sj.lib.calander;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class HolidayByGovTest {

    private HolidayCalendarByGov2019 holidayByGov;

    @org.junit.Before
    public void setUp() throws Exception {
        holidayByGov = new HolidayCalendarByGov2019();
        holidayByGov.adjustCalendar();
//        holidayByGov.dump();
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
        Calendar calendar = CalendarUtils.genDate(2019, 1, 1);
//        CalendarUtils.dump(calendar);

        Boolean isWorkDay = holidayByGov.dateCategoryMap.get(calendar);
        assertNotNull(isWorkDay);
    }
}