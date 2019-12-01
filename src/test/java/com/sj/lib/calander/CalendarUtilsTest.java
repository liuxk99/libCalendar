package com.sj.lib.calander;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

public class CalendarUtilsTest {
    final
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testcase_001() throws Exception {
        Calendar calendar = Calendar.getInstance();
        dumpDayOfWeek(calendar);

        calendar.add(Calendar.DAY_OF_YEAR, 1);
        dumpDayOfWeek(calendar);
    }

    private void dumpDayOfWeek(Calendar calendar) {
        System.out.println("=> dumpDayOfWeek()");
        {
            System.out.println(calendar.toString());
            int firstDayOfWeek = calendar.getFirstDayOfWeek();
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

            System.out.println("first day of week: " + firstDayOfWeek);
            System.out.println("day of week: " + dayOfWeek);
        }
        System.out.println("<- dumpDayOfWeek()");
    }
}