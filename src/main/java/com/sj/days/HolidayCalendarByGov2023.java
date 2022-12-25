package com.sj.days;

import com.sj.time.CalendarUtils;

import java.util.Calendar;

/*
 * http://www.gov.cn/zhengce/content/2022-12/08/content_5730844.htm
 * */
public class HolidayCalendarByGov2023 extends HolidayCalendarByGov {
    void adjustCalendar() {
        // ①元旦节：2022年12月31日至2023年1月2日放假调休，共3天。
        // 周末
        dateInfoMap.put(CalendarUtils.getDate(2022, 12, 31), false);
        dateInfoMap.put(CalendarUtils.getDate(2023, 1, 1), false);
        // 周一(调休)
        dateInfoMap.put(CalendarUtils.getDate(2023, 1, 2), false);

        // ②春节：1月21日至27日放假调休，共7天。1月28日（星期六）、1月29日（星期日）上班。
        // 周末
        dateInfoMap.put(CalendarUtils.getDate(2023, 1, 21), false);
        dateInfoMap.put(CalendarUtils.getDate(2023, 1, 22), false);
        // 调休
        dateInfoMap.put(CalendarUtils.getDate(2023, 1, 23), false);
        dateInfoMap.put(CalendarUtils.getDate(2023, 1, 24), false);
        dateInfoMap.put(CalendarUtils.getDate(2023, 1, 25), false);
        dateInfoMap.put(CalendarUtils.getDate(2023, 1, 26), false);
        dateInfoMap.put(CalendarUtils.getDate(2023, 1, 27), false);
        // 周末(调班)
        dateInfoMap.put(CalendarUtils.getDate(2023, 1, 28), true);
        dateInfoMap.put(CalendarUtils.getDate(2023, 1, 29), true);

        // ③清明节：4月5日放假，共1天。
        dateInfoMap.put(CalendarUtils.getDate(2023, 4, 5), false);

        // ④劳动节：4月29日至5月3日放假调休，共5天。4月23日（星期日）、5月6日（星期六）上班。
        // 周末
        dateInfoMap.put(CalendarUtils.getDate(2023, 4, 29), false);
        dateInfoMap.put(CalendarUtils.getDate(2023, 4, 30), false);
        // 劳动节
        dateInfoMap.put(CalendarUtils.getDate(2023, 5, 1), false);
        // 周二周三(调休)
        dateInfoMap.put(CalendarUtils.getDate(2023, 5, 2), false);
        dateInfoMap.put(CalendarUtils.getDate(2023, 5, 3), false);
        // 周日(调班)
        dateInfoMap.put(CalendarUtils.getDate(2023, 4, 23), true);
        dateInfoMap.put(CalendarUtils.getDate(2023, 5, 6), true);

        // ⑤端午节：6月22日至24日放假调休，共3天。6月25日（星期日）上班。
        dateInfoMap.put(CalendarUtils.getDate(2023, 6, 22), false);
        // 周五(调休)
        dateInfoMap.put(CalendarUtils.getDate(2023, 6, 23), false);
        // 周六
        dateInfoMap.put(CalendarUtils.getDate(2023, 6, 24), false);
        // 周日(调班)
        dateInfoMap.put(CalendarUtils.getDate(2023, 6, 25), true);

        // ⑥⑦中秋节、国庆节：9月29日至10月6日放假调休，共8天。10月7日（星期六）、10月8日（星期日）上班。
        // 中秋节
        dateInfoMap.put(CalendarUtils.getDate(2023, 9, 29), false);
        // 周末
        dateInfoMap.put(CalendarUtils.getDate(2023, 9, 30), false);
        dateInfoMap.put(CalendarUtils.getDate(2023, 10, 1), false);
        // 周一→周五(调休)
        dateInfoMap.put(CalendarUtils.getDate(2023, 10, 2), false);
        dateInfoMap.put(CalendarUtils.getDate(2023, 10, 3), false);
        dateInfoMap.put(CalendarUtils.getDate(2023, 10, 4), false);
        dateInfoMap.put(CalendarUtils.getDate(2023, 10, 5), false);
        dateInfoMap.put(CalendarUtils.getDate(2023, 10, 6), false);
        // 周末(调班)
        dateInfoMap.put(CalendarUtils.getDate(2023, 10, 7), true);
        dateInfoMap.put(CalendarUtils.getDate(2023, 10, 8), true);

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
        return CalendarUtils.getDate(2023, 12, 28);
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
