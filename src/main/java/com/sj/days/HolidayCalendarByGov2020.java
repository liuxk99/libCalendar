package com.sj.days;

import com.sj.time.CalendarUtils;

import java.util.Calendar;

/*
 * http://www.gov.cn/zhengce/content/2019-11/21/content_5454164.htm
 * */
public class HolidayCalendarByGov2020 extends HolidayCalendarByGov {
    void adjustCalendar() {
        // 元旦节
        dateInfoMap.put(CalendarUtils.getDate(2020, 1, 1), false);

        // 春节
        dateInfoMap.put(CalendarUtils.getDate(2020, 1, 24), false);
        dateInfoMap.put(CalendarUtils.getDate(2020, 1, 25), false);
        dateInfoMap.put(CalendarUtils.getDate(2020, 1, 26), false);
        dateInfoMap.put(CalendarUtils.getDate(2020, 1, 27), false);
        dateInfoMap.put(CalendarUtils.getDate(2020, 1, 28), false);
        dateInfoMap.put(CalendarUtils.getDate(2020, 1, 29), false);
        dateInfoMap.put(CalendarUtils.getDate(2020, 1, 30), false);

        // 武汉肺炎疫情
        dateInfoMap.put(CalendarUtils.getDate(2020, 1, 31), false);
        dateInfoMap.put(CalendarUtils.getDate(2020, 2, 1), false);
        dateInfoMap.put(CalendarUtils.getDate(2020, 2, 2), false);

        dateInfoMap.put(CalendarUtils.getDate(2020, 1, 19), true);

        // 清明节
        dateInfoMap.put(CalendarUtils.getDate(2020, 4, 5), true);
        dateInfoMap.put(CalendarUtils.getDate(2020, 4, 5), true);
        dateInfoMap.put(CalendarUtils.getDate(2020, 4, 6), true);

        // 劳动节
        dateInfoMap.put(CalendarUtils.getDate(2020, 5, 1), false);
        dateInfoMap.put(CalendarUtils.getDate(2020, 5, 2), false);
        dateInfoMap.put(CalendarUtils.getDate(2020, 5, 3), false);
        dateInfoMap.put(CalendarUtils.getDate(2020, 5, 4), false);
        dateInfoMap.put(CalendarUtils.getDate(2020, 5, 5), false);

        dateInfoMap.put(CalendarUtils.getDate(2020, 4, 26), true);
        dateInfoMap.put(CalendarUtils.getDate(2020, 5, 9), true);

        // 端午节
        dateInfoMap.put(CalendarUtils.getDate(2020, 6, 25), false);
        dateInfoMap.put(CalendarUtils.getDate(2020, 6, 26), false);
        dateInfoMap.put(CalendarUtils.getDate(2020, 6, 27), false);

        dateInfoMap.put(CalendarUtils.getDate(2020, 6, 28), true);

        // 中秋节
        // 国庆节
        dateInfoMap.put(CalendarUtils.getDate(2020, 10, 1), false);
        dateInfoMap.put(CalendarUtils.getDate(2020, 10, 2), false);
        dateInfoMap.put(CalendarUtils.getDate(2020, 10, 3), false);
        dateInfoMap.put(CalendarUtils.getDate(2020, 10, 4), false);
        dateInfoMap.put(CalendarUtils.getDate(2020, 10, 5), false);
        dateInfoMap.put(CalendarUtils.getDate(2020, 10, 6), false);
        dateInfoMap.put(CalendarUtils.getDate(2020, 10, 7), false);

        dateInfoMap.put(CalendarUtils.getDate(2020, 10, 8), false);

        dateInfoMap.put(CalendarUtils.getDate(2020, 9, 27), true);
        dateInfoMap.put(CalendarUtils.getDate(2020, 10, 10), true);

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
        return CalendarUtils.getDate(2019, 12, 29);
    }

    @Override
    Calendar getLastDay() {
        return CalendarUtils.getDate(2020, 12, 28);
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
