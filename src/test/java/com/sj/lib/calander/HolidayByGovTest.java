package com.sj.lib.calander;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class HolidayByGovTest extends TestCase {

    private HolidayByGov2019 holidayByGov;

    @Test
    public void adjustCalendar() {
        holidayByGov.dump();
    }

    @Test
    public void testcase_Maps() {
        Calendar calendar = CalendarUtils.genDate(2019, 1, 1);
        CalendarUtils.dump(calendar);
        assertTrue(holidayByGov.dateCategoryMap.containsKey(calendar));

        Boolean isWorkDay = holidayByGov.dateCategoryMap.get(calendar);
        assertNotNull(isWorkDay);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        holidayByGov = new HolidayByGov2019();
        holidayByGov.adjustCalendar();
        holidayByGov.dump();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testcase_Calendars() throws Exception {
        Calendar cal1 = CalendarUtils.genDate(2019, 1, 1);
        Calendar cal2 = CalendarUtils.genDate(2019, 1, 1);
        assertEquals(cal1, cal2);

        CalendarUtils.dump(cal1);
        CalendarUtils.dump(cal2);
    }
}