package menu.error;

public enum ErrorMessages {
    EMPTY_INPUT("빈 값을 입력할 수 없습니다."),
    INVALID_COACH_NAME_LENGTH("이름은 최소 2글자 최대 4글자까지 입력이 가능합니다."),
    INVALID_COACH_NAME_FORMAT("한글만 입력할 수 있습니다."),
    INEDIBLE_COUNT("못 먹는 메뉴는 최소 0개, 최대 2개까지 설정이 가능합니다."),
    INVALID_INEDIBLE("메뉴에 없는 못 먹는 메뉴 입니다."),
    INVALID_CATEGORY("존재하지 않는 카테고리입니다."),
    INVALID_MENU("존재하지 않는 메뉴입니다.");


    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessages(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
