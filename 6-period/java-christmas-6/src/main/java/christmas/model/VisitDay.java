package christmas.model;

import christmas.error.ErrorMessages;
import christmas.utils.NumberValidator;

public class VisitDay {
    private final int visitDay;

    public VisitDay(final int visitDay) {
        validate(visitDay);
        this.visitDay = visitDay;
    }

    private void validate(int visitDay) {
        NumberValidator.validateRange(visitDay, 1, 31, ErrorMessages.INVALID_ORDER);
    }

    public int getVisitDay() {
        return visitDay;
    }
}
