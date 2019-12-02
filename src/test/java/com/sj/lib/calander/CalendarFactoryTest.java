package com.sj.lib.calander;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;

public class CalendarFactoryTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testcase_001() throws Exception {
        CalendarFactory calendarFactory = CalendarFactory.getInstance();
        Map<Calendar, Boolean> map = calendarFactory.generateCalendarMap();

        Calendar firstDay = CalendarUtils.genDate(2019, 1, 1);
        Calendar lastDay = CalendarUtils.genDate(2019, 12, 1);

        assertTrue(map.containsKey(firstDay));
        assertTrue(map.containsKey(lastDay));
    }
}