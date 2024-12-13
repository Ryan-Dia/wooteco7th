package christmas.view;

import christmas.dto.OrderDto;
import christmas.dto.OrdersDto;
import christmas.model.VisitDay;

public final class OutputView {
    private OutputView() {
    }

    public static void printStartMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }


    public static void printOrderMenu(OrdersDto ordersDto, VisitDay visitDay) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!%n", visitDay.getVisitDay());
        System.out.println("\n<주문 메뉴>");

        for (OrderDto order : ordersDto.orders()) {
            System.out.printf("%s %s개%n", order.menu().getMenuName(), order.quantity());
        }
    }

    public static void printTotalAmountBeforeDiscount(int totalAmount) {
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.printf("%,d원%n", totalAmount);
    }

    public static void printPresentation(boolean canPresent) {
        System.out.println("\n<증정 메뉴>");
        if (canPresent) {
            System.out.println("샴페인 1개");
            return;
        }
        System.out.println("없음");
    }
}
