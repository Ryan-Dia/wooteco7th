package christmas.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekdayChecker {
    public static boolean check(int day) {
        return isWeekday(day);

    }

    public static boolean isWeekday(int day) {
        LocalDate date = LocalDate.of(2023, 12, day);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SUNDAY ||
                dayOfWeek == DayOfWeek.MONDAY ||
                dayOfWeek == DayOfWeek.TUESDAY ||
                dayOfWeek == DayOfWeek.WEDNESDAY ||
                dayOfWeek == DayOfWeek.THURSDAY;
    }
}
