package com.sj.lib.calander;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CalendarUtilsTest {

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

    @Test
    public void testcase_genDate() throws Exception {
        Calendar cal1 = CalendarUtils.genDate(2019, 1, 1);
        Calendar cal2 = CalendarUtils.genDate(2019, 1, 1);
//        boolean res = cal1.getTimeInMillis() == cal2.getTimeInMillis();
//        System.out.println(res);
        CalendarUtils.dump(cal1);
        CalendarUtils.dump(cal2);

        assertEquals(cal1, cal2);
    }

    @Test
    public void testcase05_time() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());

        long dayTime = CalendarUtils.genDate(calendar).getTimeInMillis();
        long dayDate = CalendarUtils.genTime(calendar);

        System.out.println(new Date(dayTime));
        System.out.println(new Date(dayDate));
    }
}