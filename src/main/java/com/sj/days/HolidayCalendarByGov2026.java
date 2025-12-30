package com.sj.days;

import com.sj.time.CalendarUtils;

import java.util.Calendar;

/*
 * https://www.gov.cn/zhengce/content/202511/content_7047090.htm
国务院办公厅关于2026年
部分节假日安排的通知
国办发明电〔2026〕7号
 * */
public class HolidayCalendarByGov2026 extends HolidayCalendarByGov {
    void adjustCalendar() {
        // 一、元旦：1月1日（周四）至3日（周六）放假调休，共3天。1月4日（周日）上班。
        dateInfoMap.put(CalendarUtils.getDate(2026, 1, 1), false);
        dateInfoMap.put(CalendarUtils.getDate(2026, 1, 4), true);

        // 二、春节：2月15日（农历腊月二十八、周日）至23日（农历正月初七、周一）放假调休，共9天。
        dateInfoMap.put(CalendarUtils.getDate(2026, 2, 15), false);
        dateInfoMap.put(CalendarUtils.getDate(2026, 2, 16), false);
        dateInfoMap.put(CalendarUtils.getDate(2026, 2, 17), false);
        dateInfoMap.put(CalendarUtils.getDate(2026, 2, 18), false);
        dateInfoMap.put(CalendarUtils.getDate(2026, 2, 19), false);
        dateInfoMap.put(CalendarUtils.getDate(2026, 2, 20), false);
        dateInfoMap.put(CalendarUtils.getDate(2026, 2, 21), false);
        dateInfoMap.put(CalendarUtils.getDate(2026, 2, 22), false);
        dateInfoMap.put(CalendarUtils.getDate(2026, 2, 23), false);
        // 2月14日（周六）、2月28日（周六）上班。
        dateInfoMap.put(CalendarUtils.getDate(2026, 2, 14), true);
        dateInfoMap.put(CalendarUtils.getDate(2026, 2, 28), true);

        // 三、清明节：4月4日（周六）至6日（周一）放假，共3天。
        dateInfoMap.put(CalendarUtils.getDate(2026, 4, 4), false);
        dateInfoMap.put(CalendarUtils.getDate(2026, 4, 5), false);
        dateInfoMap.put(CalendarUtils.getDate(2026, 4, 6), false);

        // 四、劳动节：5月1日（周五）至5日（周二）放假调休，共5天。
        dateInfoMap.put(CalendarUtils.getDate(2026, 5, 1), false);
        dateInfoMap.put(CalendarUtils.getDate(2026, 5, 2), false);
        dateInfoMap.put(CalendarUtils.getDate(2026, 5, 3), false);
        dateInfoMap.put(CalendarUtils.getDate(2026, 5, 4), false);
        dateInfoMap.put(CalendarUtils.getDate(2026, 5, 5), false);
        // 5月9日（周六）上班。
        dateInfoMap.put(CalendarUtils.getDate(2026, 5, 9), true);

        // 五、端午节：6月19日（周五）至21日（周日）放假，共3天。
        dateInfoMap.put(CalendarUtils.getDate(2026, 6, 19), false);
        dateInfoMap.put(CalendarUtils.getDate(2026, 6, 20), false);
        dateInfoMap.put(CalendarUtils.getDate(2026, 6, 21), false);

        // 六、中秋节：9月25日（周五）至27日（周日）放假，共3天。
        dateInfoMap.put(CalendarUtils.getDate(2026, 9, 25), false);
        dateInfoMap.put(CalendarUtils.getDate(2026, 9, 26), false);
        dateInfoMap.put(CalendarUtils.getDate(2026, 9, 27), false);

        // 七、国庆节：10月1日（周四）至7日（周三）放假调休，共7天。
        dateInfoMap.put(CalendarUtils.getDate(2026, 10, 1), false);
        dateInfoMap.put(CalendarUtils.getDate(2026, 10, 2), false);
        dateInfoMap.put(CalendarUtils.getDate(2026, 10, 3), false);
        dateInfoMap.put(CalendarUtils.getDate(2026, 10, 4), false);
        dateInfoMap.put(CalendarUtils.getDate(2026, 10, 5), false);
        dateInfoMap.put(CalendarUtils.getDate(2026, 10, 6), false);
        dateInfoMap.put(CalendarUtils.getDate(2026, 10, 7), false);
        // 9月20日（周日）、10月10日（周六）上班。
        dateInfoMap.put(CalendarUtils.getDate(2026, 9, 20), true);
        dateInfoMap.put(CalendarUtils.getDate(2026, 10, 10), true);

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
        return CalendarUtils.getDate(2026, 12, 28);
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
