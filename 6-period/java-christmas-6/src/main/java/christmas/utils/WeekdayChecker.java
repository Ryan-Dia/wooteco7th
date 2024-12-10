package christmas.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekdayChecker {
    private static boolean isWeekday(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SUNDAY ||
                dayOfWeek == DayOfWeek.MONDAY ||
                dayOfWeek == DayOfWeek.TUESDAY ||
                dayOfWeek == DayOfWeek.WEDNESDAY ||
                dayOfWeek == DayOfWeek.THURSDAY;
    }

    public static String check(int day){
        LocalDate date = LocalDate.of(2023, 12, day);
        if (isWeekday(date)) {
            return "평일";
        } else {
            return "주말";
        }
    }
}
