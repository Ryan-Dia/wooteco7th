package menu.model.coach;

import menu.error.CIllegalArgumentException;
import menu.error.ErrorMessages;

public class Coach {
    private static final int NAME_LENGTH_MIN = 2;
    private static final int NAME_LENGTH_MAX = 4;
    private static final String REGEX = "^[가-힣]+";
    private final String name;

    public Coach(final String name) {
        validateNameLength(name);
        validateLanguage(name);
        this.name = name;
    }

    private static void validateLanguage(final String name) {
        if (!name.matches(REGEX)) {
            throw new CIllegalArgumentException(ErrorMessages.INVALID_COACH_NAME_FORMAT);
        }
    }

    private static void validateNameLength(final String name) {
        if (name.length() < NAME_LENGTH_MIN || name.length() > NAME_LENGTH_MAX) {
            throw new CIllegalArgumentException(ErrorMessages.INVALID_COACH_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }
}
