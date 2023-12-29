package com.sj.days;

import com.sj.time.CalendarUtils;

import java.util.Calendar;

/*
 * https://www.gov.cn/zhengce/content/202310/content_6911527.htm
国务院办公厅关于2024年
部分节假日安排的通知
国办发明电〔2024〕7号
 * */
public class HolidayCalendarByGov2024 extends HolidayCalendarByGov {
    void adjustCalendar() {
        // ①元旦节：1月1日放假，与周末连休。
        dateInfoMap.put(CalendarUtils.getDate(2024, 1, 1), false);

        // ②春节：2月10日至17日放假调休，共8天。2月4日（星期日）、2月18日（星期日）上班。鼓励各单位结合带薪年休假等制度落实，安排职工在除夕（2月9日）休息。
        dateInfoMap.put(CalendarUtils.getDate(2024, 2, 10), false);
        dateInfoMap.put(CalendarUtils.getDate(2024, 2, 11), false);
        dateInfoMap.put(CalendarUtils.getDate(2024, 2, 12), false);
        dateInfoMap.put(CalendarUtils.getDate(2024, 2, 13), false);
        dateInfoMap.put(CalendarUtils.getDate(2024, 2, 14), false);
        dateInfoMap.put(CalendarUtils.getDate(2024, 2, 15), false);
        dateInfoMap.put(CalendarUtils.getDate(2024, 2, 16), false);
        dateInfoMap.put(CalendarUtils.getDate(2024, 2, 17), false);
        // 2月4日（星期日）、2月18日（星期日）上班。
        dateInfoMap.put(CalendarUtils.getDate(2024, 2, 4), true);
        dateInfoMap.put(CalendarUtils.getDate(2024, 2, 18), true);

        // ③清明节：4月4日至6日放假调休，共3天。4月7日（星期日）上班。
        dateInfoMap.put(CalendarUtils.getDate(2024, 4, 4), false);
        dateInfoMap.put(CalendarUtils.getDate(2024, 4, 5), false);
        dateInfoMap.put(CalendarUtils.getDate(2024, 4, 6), false);
        // 4月7日（星期日）上班。
        dateInfoMap.put(CalendarUtils.getDate(2024, 4, 7), true);

        // ④劳动节：5月1日至5日放假调休，共5天。4月28日（星期日）、5月11日（星期六）上班。
        dateInfoMap.put(CalendarUtils.getDate(2024, 5, 1), false);
        dateInfoMap.put(CalendarUtils.getDate(2024, 5, 2), false);
        dateInfoMap.put(CalendarUtils.getDate(2024, 5, 3), false);
        // 4月28日（星期日）、5月11日（星期六）上班。
        dateInfoMap.put(CalendarUtils.getDate(2024, 4, 28), true);
        dateInfoMap.put(CalendarUtils.getDate(2024, 5, 11), true);

        // ⑤端午节：6月10日放假，与周末连休。
        dateInfoMap.put(CalendarUtils.getDate(2024, 6, 10), false);

        // ⑥中秋节：9月15日至17日放假调休，共3天。9月14日（星期六）上班。
        dateInfoMap.put(CalendarUtils.getDate(2024, 9, 15), false);
        dateInfoMap.put(CalendarUtils.getDate(2024, 9, 16), false);
        dateInfoMap.put(CalendarUtils.getDate(2024, 9, 17), false);
        // 9月14日（星期六）上班。
        dateInfoMap.put(CalendarUtils.getDate(2024, 9, 14), true);

        // ⑦国庆节：10月1日至7日放假调休，共7天。9月29日（星期日）、10月12日（星期六）上班。
        dateInfoMap.put(CalendarUtils.getDate(2024, 10, 1), false);
        dateInfoMap.put(CalendarUtils.getDate(2024, 10, 2), false);
        dateInfoMap.put(CalendarUtils.getDate(2024, 10, 3), false);
        dateInfoMap.put(CalendarUtils.getDate(2024, 10, 4), false);
        dateInfoMap.put(CalendarUtils.getDate(2024, 10, 5), false);
        dateInfoMap.put(CalendarUtils.getDate(2024, 10, 6), false);
        dateInfoMap.put(CalendarUtils.getDate(2024, 10, 7), false);
        //  9月29日（星期日）、10月12日（星期六）上班。
        dateInfoMap.put(CalendarUtils.getDate(2024, 9, 29), true);
        dateInfoMap.put(CalendarUtils.getDate(2024, 10, 12), true);

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
        return CalendarUtils.getDate(2024, 12, 28);
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
