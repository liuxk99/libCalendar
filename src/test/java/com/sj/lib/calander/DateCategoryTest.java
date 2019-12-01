package com.sj.lib.calander;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DateCategoryTest {

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void toString1() {
        DateCategory category = new DateCategory(2019, 12, 1, false);
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

        DateCategory category = new DateCategory(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH), isWorkday);
        System.out.println(category.toString());

        calendar.add(Calendar.DAY_OF_YEAR, 1);
        dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (Calendar.MONDAY <= dayOfWeek && dayOfWeek <= Calendar.FRIDAY) {
            isWorkday = true;
        }
        category = new DateCategory(calendar, isWorkday);
        System.out.println(category.toString());
    }

    @Test
    public void testcase_002() throws Exception {
        List<DateCategory> dateCategoryList = new ArrayList<DateCategory>();

        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 0, 1);

        Calendar lastDay = (Calendar) calendar.clone();
        lastDay.set(2020, 0, 1);

        HolidayByGov holidayByGov = new HolidayByGov2019();
        holidayByGov.adjustCalendar();
        int i = 0;
        while (calendar.before(lastDay)) {
            Boolean isWorkDay = holidayByGov.dateCategoryMap.get(calendar);
            if (isWorkDay != null) {
                dateCategoryList.add(new DateCategory(calendar, isWorkDay));
            } else {
                dateCategoryList.add(new DateCategory(calendar));
            }
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }

        for (DateCategory dateCategory : dateCategoryList) {
            System.out.println(dateCategory.toString());
        }
    }
}