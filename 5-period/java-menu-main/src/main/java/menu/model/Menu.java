package menu.model;

import java.util.Arrays;
import java.util.List;
import menu.error.CIllegalArgumentException;
import menu.error.ErrorMessages;

public enum Menu {
    JAPAN("일식", List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KORAN("한식", List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINA("중식", List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN("아시안", List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN("양식", List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    private final String category;
    private final List<String> dishes;

    Menu(final String category, final List<String> dishes) {
        this.category = category;
        this.dishes = dishes;
    }

    public static boolean hasMenu(String menuName) {
        return Arrays.stream(Menu.values()).anyMatch(menu -> menu.dishes.contains(menuName));
    }

    public static List<String> findDishesByCategory(String category) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.category.equals(category))
                .map(Menu::getDishes)
                .findAny()
                .orElseThrow(() -> new CIllegalArgumentException(ErrorMessages.INVALID_CATEGORY));
    }

    public List<String> getDishes() {
        return dishes;
    }

    public String getCategory() {
        return category;
    }
}
