package com.sj.days;

import com.sj.time.CalendarUtils;

import java.util.Calendar;

/*
 * http://www.gov.cn/zhengce/content/2021-11/25/content_5564127.htm
 * */
public class HolidayCalendarByGov2021 extends HolidayCalendarByGov {
    void adjustCalendar() {
        // 元旦节
        dateInfoMap.put(CalendarUtils.getDate(2021, 1, 1), false);
        dateInfoMap.put(CalendarUtils.getDate(2021, 1, 2), false);
        dateInfoMap.put(CalendarUtils.getDate(2021, 1, 3), false);

        // 春节
        dateInfoMap.put(CalendarUtils.getDate(2021, 2, 11), false);
        dateInfoMap.put(CalendarUtils.getDate(2021, 2, 12), false);
        dateInfoMap.put(CalendarUtils.getDate(2021, 2, 13), false);
        dateInfoMap.put(CalendarUtils.getDate(2021, 2, 14), false);
        dateInfoMap.put(CalendarUtils.getDate(2021, 2, 15), false);
        dateInfoMap.put(CalendarUtils.getDate(2021, 2, 16), false);
        dateInfoMap.put(CalendarUtils.getDate(2021, 2, 17), false);
        dateInfoMap.put(CalendarUtils.getDate(2021, 2, 7), true);
        dateInfoMap.put(CalendarUtils.getDate(2021, 2, 20), true);
        
        // 清明节
        dateInfoMap.put(CalendarUtils.getDate(2021, 4, 3), false);
        dateInfoMap.put(CalendarUtils.getDate(2021, 4, 4), false);
        dateInfoMap.put(CalendarUtils.getDate(2021, 4, 5), false);

        // 劳动节
        dateInfoMap.put(CalendarUtils.getDate(2021, 5, 1), false);
        dateInfoMap.put(CalendarUtils.getDate(2021, 5, 2), false);
        dateInfoMap.put(CalendarUtils.getDate(2021, 5, 3), false);
        dateInfoMap.put(CalendarUtils.getDate(2021, 5, 4), false);
        dateInfoMap.put(CalendarUtils.getDate(2021, 5, 5), false);
        dateInfoMap.put(CalendarUtils.getDate(2021, 4, 25), true);
        dateInfoMap.put(CalendarUtils.getDate(2021, 5, 8), true);

        // 端午节
        dateInfoMap.put(CalendarUtils.getDate(2021, 6, 12), false);
        dateInfoMap.put(CalendarUtils.getDate(2021, 6, 13), false);
        dateInfoMap.put(CalendarUtils.getDate(2021, 6, 14), false);

        // 中秋节
        dateInfoMap.put(CalendarUtils.getDate(2021, 9, 19), false);
        dateInfoMap.put(CalendarUtils.getDate(2021, 9, 20), false);
        dateInfoMap.put(CalendarUtils.getDate(2021, 9, 21), false);
        dateInfoMap.put(CalendarUtils.getDate(2021, 9, 18), true);

        // 国庆节
        dateInfoMap.put(CalendarUtils.getDate(2021, 10, 1), false);
        dateInfoMap.put(CalendarUtils.getDate(2021, 10, 2), false);
        dateInfoMap.put(CalendarUtils.getDate(2021, 10, 3), false);
        dateInfoMap.put(CalendarUtils.getDate(2021, 10, 4), false);
        dateInfoMap.put(CalendarUtils.getDate(2021, 10, 5), false);
        dateInfoMap.put(CalendarUtils.getDate(2021, 10, 6), false);
        dateInfoMap.put(CalendarUtils.getDate(2021, 10, 7), false);
        dateInfoMap.put(CalendarUtils.getDate(2021, 9, 26), true);
        dateInfoMap.put(CalendarUtils.getDate(2021, 10, 9), true);

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
        return CalendarUtils.getDate(2021, 12, 28);
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
