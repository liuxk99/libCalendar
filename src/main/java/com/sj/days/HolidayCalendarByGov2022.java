package com.sj.days;

import com.sj.time.CalendarUtils;

import java.util.Calendar;

/*
 * http://www.gov.cn/zhengce/content/2021-11/25/content_5564127.htm
 * */
public class HolidayCalendarByGov2022 extends HolidayCalendarByGov {
    void adjustCalendar() {
        // 元旦节
        dateInfoMap.put(CalendarUtils.getDate(2022, 1, 1), false);
        dateInfoMap.put(CalendarUtils.getDate(2022, 1, 2), false);
        dateInfoMap.put(CalendarUtils.getDate(2022, 1, 3), false);

        // 春节前休假

        // 春节
        dateInfoMap.put(CalendarUtils.getDate(2022, 1, 29), true);
        dateInfoMap.put(CalendarUtils.getDate(2022, 1, 30), true);

        dateInfoMap.put(CalendarUtils.getDate(2022, 1, 31), false);
        dateInfoMap.put(CalendarUtils.getDate(2022, 2, 1), false);
        dateInfoMap.put(CalendarUtils.getDate(2022, 2, 2), false);
        dateInfoMap.put(CalendarUtils.getDate(2022, 2, 3), false);
        dateInfoMap.put(CalendarUtils.getDate(2022, 2, 4), false);
        dateInfoMap.put(CalendarUtils.getDate(2022, 2, 5), false);
        dateInfoMap.put(CalendarUtils.getDate(2022, 2, 6), false);

        // 春节后休假

        // 清明节
        dateInfoMap.put(CalendarUtils.getDate(2022, 4, 2), true);

        dateInfoMap.put(CalendarUtils.getDate(2022, 4, 3), false);
        dateInfoMap.put(CalendarUtils.getDate(2022, 4, 4), false);
        dateInfoMap.put(CalendarUtils.getDate(2022, 4, 5), false);

        // 劳动节
        dateInfoMap.put(CalendarUtils.getDate(2022, 4, 24), true);

        dateInfoMap.put(CalendarUtils.getDate(2022, 4, 30), false);
        dateInfoMap.put(CalendarUtils.getDate(2022, 5, 1), false);
        dateInfoMap.put(CalendarUtils.getDate(2022, 5, 2), false);
        dateInfoMap.put(CalendarUtils.getDate(2022, 5, 3), false);
        dateInfoMap.put(CalendarUtils.getDate(2022, 5, 4), false);

        dateInfoMap.put(CalendarUtils.getDate(2022, 5, 7), true);

        // 端午节
        dateInfoMap.put(CalendarUtils.getDate(2022, 6, 3), false);
        dateInfoMap.put(CalendarUtils.getDate(2022, 6, 4), false);
        dateInfoMap.put(CalendarUtils.getDate(2022, 6, 5), false);

        // 中秋节
        dateInfoMap.put(CalendarUtils.getDate(2022, 9, 10), false);
        dateInfoMap.put(CalendarUtils.getDate(2022, 9, 11), false);
        dateInfoMap.put(CalendarUtils.getDate(2022, 9, 12), false);

        // 国庆节
        dateInfoMap.put(CalendarUtils.getDate(2022, 10, 1), false);
        dateInfoMap.put(CalendarUtils.getDate(2022, 10, 2), false);
        dateInfoMap.put(CalendarUtils.getDate(2022, 10, 3), false);
        dateInfoMap.put(CalendarUtils.getDate(2022, 10, 4), false);
        dateInfoMap.put(CalendarUtils.getDate(2022, 10, 5), false);
        dateInfoMap.put(CalendarUtils.getDate(2022, 10, 6), false);
        dateInfoMap.put(CalendarUtils.getDate(2022, 10, 7), false);

        dateInfoMap.put(CalendarUtils.getDate(2022, 10, 8), true);
        dateInfoMap.put(CalendarUtils.getDate(2022, 10, 9), true);

        Calendar calendar = getFirstDay();
        Calendar lastDay = getLastDay();
        lastDay.add(Calendar.DAY_OF_YEAR, 1);

        while (calendar.before(lastDay)) {
            if (!dateInfoMap.containsKey(calendar)) {
                boolean isWorkDay = false;
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                if (Calendar.MONDAY <= dayOfWeek && dayOfWeek <= Calendar.FRIDAY) {
                    isWorkDay = true;
                }
//                DayWR dateInfo = new DayWR(calendar, isWorkDay);
//                System.out.println("dateInfo: " + dateInfo);
                Calendar date = (Calendar) calendar.clone();
                dateInfoMap.put(date, isWorkDay);
            }
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }
    }

    @Override
    Calendar getFirstDay() {
        return CalendarUtils.getDate(2020, 12, 29);
    }

    @Override
    Calendar getLastDay() {
        return CalendarUtils.getDate(2022, 12, 28);
    }

    @Override
    void dump() {
        Calendar calendar = getFirstDay();
        Calendar lastDay = getLastDay();
        lastDay.add(Calendar.DAY_OF_YEAR, 1);

        while (calendar.before(lastDay)) {
            Boolean isWorkDay = dateInfoMap.get(calendar);
            if (isWorkDay == null) {
                CalendarUtils.dump(calendar);
                System.out.println("Error: date map is not completed!");
            } else {
                DayWR dayWR = new DayWR(calendar, isWorkDay);
                System.out.println(dayWR.toString());
            }
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }
    }
}
