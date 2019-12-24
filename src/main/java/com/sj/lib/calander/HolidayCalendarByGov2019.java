package com.sj.lib.calander;

import java.util.Calendar;

/*
* http://www.gov.cn/zhengce/content/2018-12/06/content_5346276.htm
* */
public class HolidayCalendarByGov2019 extends HolidayCalendarByGov {
    void adjustCalendar() {
        // 元旦节
        dateInfoMap.put(CalendarUtils.genDate(2018, 12, 29), true);
        dateInfoMap.put(CalendarUtils.genDate(2019, 1, 1), false);

        // 春节
        dateInfoMap.put(CalendarUtils.genDate(2019, 2, 2), true);
        dateInfoMap.put(CalendarUtils.genDate(2019, 2, 3), true);

        dateInfoMap.put(CalendarUtils.genDate(2019, 2, 4), false);
        dateInfoMap.put(CalendarUtils.genDate(2019, 2, 5), false);
        dateInfoMap.put(CalendarUtils.genDate(2019, 2, 6), false);
        dateInfoMap.put(CalendarUtils.genDate(2019, 2, 7), false);
        dateInfoMap.put(CalendarUtils.genDate(2019, 2, 8), false);
        dateInfoMap.put(CalendarUtils.genDate(2019, 2, 9), false);
        dateInfoMap.put(CalendarUtils.genDate(2019, 2, 10), false);

        // 清明节
        dateInfoMap.put(CalendarUtils.genDate(2019, 4, 5), false);

        // 劳动节
        dateInfoMap.put(CalendarUtils.genDate(2019, 5, 1), false);

        // 端午节
        dateInfoMap.put(CalendarUtils.genDate(2019, 6, 7), false);

        // 中秋节
        dateInfoMap.put(CalendarUtils.genDate(2019, 9, 13), false);

        // 国庆节
        dateInfoMap.put(CalendarUtils.genDate(2019, 10, 1), false);
        dateInfoMap.put(CalendarUtils.genDate(2019, 10, 2), false);
        dateInfoMap.put(CalendarUtils.genDate(2019, 10, 3), false);
        dateInfoMap.put(CalendarUtils.genDate(2019, 10, 4), false);
        dateInfoMap.put(CalendarUtils.genDate(2019, 10, 5), false);
        dateInfoMap.put(CalendarUtils.genDate(2019, 10, 6), false);
        dateInfoMap.put(CalendarUtils.genDate(2019, 10, 7), false);

        dateInfoMap.put(CalendarUtils.genDate(2019, 9, 29), true);
        dateInfoMap.put(CalendarUtils.genDate(2019, 10, 12), true);

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
//                DateInfo dateInfo = new DateInfo(calendar, isWorkDay);
//                System.out.println("dateInfo: " + dateInfo);
                Calendar date = (Calendar) calendar.clone();
                dateInfoMap.put(date, isWorkDay);
            }
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }
    }

    @Override
    Calendar getFirstDay() {
        return CalendarUtils.genDate(2018, 12, 29);
    }

    @Override
    Calendar getLastDay() {
        return CalendarUtils.genDate(2019, 12, 28);
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
                DateInfo dateInfo = new DateInfo(calendar, isWorkDay);
                System.out.println(dateInfo.toString());
            }
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }
    }
}
