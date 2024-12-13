package christmas.model;

import christmas.error.ErrorMessages;
import christmas.utils.NumberValidator;
import christmas.utils.WeekdayChecker;
import java.util.List;

public class VisitDay {
    private final int visitDay;
    private final List<Integer> specialDay = List.of(3, 10, 17, 24, 25, 31);

    public VisitDay(final int visitDay) {
        validate(visitDay);
        this.visitDay = visitDay;
    }

    public boolean isWeekDay() {
        return WeekdayChecker.check(visitDay);
    }

    public boolean isSpecialDay() {
        return specialDay.contains(visitDay);
    }

    private void validate(int visitDay) {
        NumberValidator.validateRange(visitDay, 1, 31, ErrorMessages.INVALID_ORDER);
    }

    public int getVisitDay() {
        return visitDay;
    }
}
