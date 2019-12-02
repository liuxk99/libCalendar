package com.sj.lib.calander;

import java.util.Calendar;

public class HolidayCalendarByGov2019 extends HolidayCalendarByGov {
    void adjustCalendar() {
        // 元旦节
        Calendar calendar = CalendarUtils.genDate(2019, 1, 1);
        dateCategoryMap.put(calendar, false);

        // 春节
        dateCategoryMap.put(CalendarUtils.genDate(2019, 2, 2), true);
        dateCategoryMap.put(CalendarUtils.genDate(2019, 2, 3), true);

        dateCategoryMap.put(CalendarUtils.genDate(2019, 2, 4), false);
        dateCategoryMap.put(CalendarUtils.genDate(2019, 2, 5), false);
        dateCategoryMap.put(CalendarUtils.genDate(2019, 2, 6), false);
        dateCategoryMap.put(CalendarUtils.genDate(2019, 2, 7), false);
        dateCategoryMap.put(CalendarUtils.genDate(2019, 2, 8), false);
        dateCategoryMap.put(CalendarUtils.genDate(2019, 2, 9), false);
        dateCategoryMap.put(CalendarUtils.genDate(2019, 2, 10), false);

        // 清明节
        dateCategoryMap.put(CalendarUtils.genDate(2019, 4, 5), false);

        // 劳动节
        dateCategoryMap.put(CalendarUtils.genDate(2019, 5, 1), false);

        // 端午节
        dateCategoryMap.put(CalendarUtils.genDate(2019, 6, 7), false);

        // 中秋节
        dateCategoryMap.put(CalendarUtils.genDate(2019, 9, 13), false);

        // 国庆节
        dateCategoryMap.put(CalendarUtils.genDate(2019, 10, 1), false);
        dateCategoryMap.put(CalendarUtils.genDate(2019, 10, 2), false);
        dateCategoryMap.put(CalendarUtils.genDate(2019, 10, 3), false);
        dateCategoryMap.put(CalendarUtils.genDate(2019, 10, 4), false);
        dateCategoryMap.put(CalendarUtils.genDate(2019, 10, 5), false);
        dateCategoryMap.put(CalendarUtils.genDate(2019, 10, 6), false);
        dateCategoryMap.put(CalendarUtils.genDate(2019, 10, 7), false);

        dateCategoryMap.put(CalendarUtils.genDate(2019, 9, 29), true);
        dateCategoryMap.put(CalendarUtils.genDate(2019, 10, 12), true);
    }
}
