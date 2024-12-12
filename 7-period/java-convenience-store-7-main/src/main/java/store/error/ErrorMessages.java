package store.error;

public enum ErrorMessages {
    EMPTY_INPUT("빈 값을 입력할 수 없습니다."),
    INVALID_FORMAT("올바르지않은형식으로입력했습니다. 다시입력해 주세요."),
    INVALID_ITEM("존재하지않는상품입니다. 다시입력해 주세요."),
    EXCEED_AMOUNT("재고수량을초과하여구매할수없습니다. 다시입력해주세요."),
    INVALID_INPUT("잘못된입력입니다. 다시입력해주세요.");


    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessages(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
