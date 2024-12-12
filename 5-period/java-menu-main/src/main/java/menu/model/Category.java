package menu.model;

import java.util.Arrays;
import menu.error.CIllegalArgumentException;
import menu.error.ErrorMessages;

public enum Category {
    JAPAN("일식", 1),
    KORAN("한식", 2),
    CHINA("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5);

    private final String category;
    private final int number;

    Category(final String category, final int number) {
        this.category = category;
        this.number = number;
    }

    //TODO: find 템플릿 만들기
    public static Category findByNumber(int inputNumber) {
        return Arrays.stream(Category.values())
                .filter(category -> category.number == inputNumber)
                .findAny()
                .orElseThrow(() -> new CIllegalArgumentException(ErrorMessages.INVALID_CATEGORY));
    }

    public String getCategory() {
        return category;
    }

    public int getNumber() {
        return number;
    }
}
