package com.sj.days;

import com.sj.time.CalendarUtils;

import java.util.Calendar;

/*
 * https://www.gov.cn/zhengce/content/202411/content_6986382.htm
国务院办公厅关于2025年部分节假日安排的通知
国办发明电〔2024〕12号
 * */
public class HolidayCalendarByGov2025 extends HolidayCalendarByGov {
    void adjustCalendar() {
        // 一、元旦：1月1日（周三）放假1天，不调休。
        dateInfoMap.put(CalendarUtils.getDate(2025, 1, 1), false);

        // 二、春节：1月28日（农历除夕、周二）至2月4日（农历正月初七、周二）放假调休，共8天。
        dateInfoMap.put(CalendarUtils.getDate(2025, 1, 28), false);
        dateInfoMap.put(CalendarUtils.getDate(2025, 1, 29), false);
        dateInfoMap.put(CalendarUtils.getDate(2025, 1, 30), false);
        dateInfoMap.put(CalendarUtils.getDate(2025, 1, 31), false);
        dateInfoMap.put(CalendarUtils.getDate(2025, 2, 1), false);
        dateInfoMap.put(CalendarUtils.getDate(2025, 2, 2), false);
        dateInfoMap.put(CalendarUtils.getDate(2025, 2, 3), false);
        dateInfoMap.put(CalendarUtils.getDate(2025, 2, 4), false);
        // 1月26日（周日）、2月8日（周六）上班。
        dateInfoMap.put(CalendarUtils.getDate(2025, 1, 26), true);
        dateInfoMap.put(CalendarUtils.getDate(2025, 2, 8), true);

        // 三、清明节：4月4日（周五）至6日（周日）放假，共3天。
        dateInfoMap.put(CalendarUtils.getDate(2025, 4, 4), false);
        dateInfoMap.put(CalendarUtils.getDate(2025, 4, 5), false);
        dateInfoMap.put(CalendarUtils.getDate(2025, 4, 6), false);

        // 四、劳动节：5月1日（周四）至5日（周一）放假调休，共5天。
        dateInfoMap.put(CalendarUtils.getDate(2025, 5, 1), false);
        dateInfoMap.put(CalendarUtils.getDate(2025, 5, 2), false);
        dateInfoMap.put(CalendarUtils.getDate(2025, 5, 3), false);
        // 4月27日（周日）上班。
        dateInfoMap.put(CalendarUtils.getDate(2025, 4, 27), true);

        // 五、端午节：5月31日（周六）至6月2日（周一）放假，共3天。
        dateInfoMap.put(CalendarUtils.getDate(2025, 5, 31), false);
        dateInfoMap.put(CalendarUtils.getDate(2025, 6, 1), false);
        dateInfoMap.put(CalendarUtils.getDate(2025, 6, 2), false);

        // 六、国庆节、中秋节：10月1日（周三）至8日（周三）放假调休，共8天。
        dateInfoMap.put(CalendarUtils.getDate(2025, 10, 1), false);
        dateInfoMap.put(CalendarUtils.getDate(2025, 10, 2), false);
        dateInfoMap.put(CalendarUtils.getDate(2025, 10, 3), false);
        dateInfoMap.put(CalendarUtils.getDate(2025, 10, 4), false);
        dateInfoMap.put(CalendarUtils.getDate(2025, 10, 5), false);
        dateInfoMap.put(CalendarUtils.getDate(2025, 10, 6), false);
        dateInfoMap.put(CalendarUtils.getDate(2025, 10, 7), false);
        dateInfoMap.put(CalendarUtils.getDate(2025, 10, 8), false);
        // 9月28日（周日）、10月11日（周六）上班。
        dateInfoMap.put(CalendarUtils.getDate(2025, 9, 28), true);
        dateInfoMap.put(CalendarUtils.getDate(2025, 10, 11), true);

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
        return CalendarUtils.getDate(2025, 12, 28);
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
                System.out.println(dayWR);
            }
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }
    }
}
