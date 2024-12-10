package christmas.view;

import christmas.dto.OrderMenusDto;
import christmas.dto.PresentationDto;
import java.util.Map.Entry;

public final class OutputView {
    private OutputView() {}

    public static void printStartMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printOrderMenus(OrderMenusDto orderMenusDto) {
        System.out.println("<주문 메뉴>");
        for (Entry<String, Integer> orderMenu : orderMenusDto.orderMenus().entrySet()) {
            System.out.printf("%s %s개%n", orderMenu.getKey(), orderMenu.getValue());
        }
    }

    public static void printTotalAmount(int totalAmount) {
        System.out.println("\n<할인 전 총 주문 금액>");
        System.out.printf("%,d원", totalAmount);
    }

    public static void printPresentation(PresentationDto presentationDto) {
        int count = presentationDto.count();
        System.out.println("\n<증정 메뉴>");
        if(count ==0) {
            System.out.println("없음");
            return;
        }
        System.out.printf("샴페인 %d개\n", count);
    }
}
