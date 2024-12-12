package menu.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import menu.dto.RecommendedMenu;

public final class OutputView {
    private OutputView() {
    }

    public static void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public static void printResult(RecommendedMenu recommendedMenu) {
        final Map<String, List<String>> box = recommendedMenu.recommendedMenu();
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println(String.format("[ 카테고리 | %s ]", String.join(" | ", recommendedMenu.categoryBox())));
        for (Entry<String, List<String>> value : box.entrySet()) {
            System.out.println(String.format("[ %s | %s ]", value.getKey(), String.join(" | ", value.getValue())));
        }
        System.out.println("추천을 완료했습니다.");
    }
}
