package christmas.utils;

import christmas.error.ErrorMessages;

public final class NumberValidator {

    private NumberValidator() {
    }

    public static <T extends Number & Comparable<T>> void validateRange(final T number, final T min, final T max,
                                                                        final ErrorMessages errorMessage) {
        if (isOutOfRange(number, min, max)) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    private static <T extends Number & Comparable<T>> boolean isOutOfRange(final T number, final T min, final T max) {
        return number.compareTo(min) < 0 || number.compareTo(max) > 0;
    }
}
