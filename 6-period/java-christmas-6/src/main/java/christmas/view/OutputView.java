package christmas.view;

import christmas.dto.OrderDto;
import christmas.dto.OrdersDto;
import christmas.model.Badge;
import christmas.model.Benefit;
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

    public static void printBenefitInfo(Benefit benefit, int totalAmount) {
        System.out.println("\n<혜택 내역>");
        if (totalAmount < 10_000) {
            System.out.println("없음");
            return;
        }
        if (benefit.christmasDiscount() != 0) {
            System.out.println(String.format("크리스마스 디데이 할인: -%,d원", benefit.christmasDiscount()));
        }
        if (benefit.isWeekday() && benefit.weekDiscount() != 0) {
            System.out.println(String.format("평일 할인: -%,d원", benefit.weekDiscount()));
        }
        if (!benefit.isWeekday() && benefit.weekDiscount() != 0) {
            System.out.println(String.format("주말 할인: -%,d원", benefit.weekDiscount()));
        }
        if (benefit.isSpecialDay()) {
            System.out.println("특별 할인: -1,000원");
        }
        if (benefit.canPresent()) {
            System.out.println(String.format("증정 이벤트: -25,000원"));
        }
    }

    public static void printTotalBenefitAmount(final int totalBenefitAMount) {
        System.out.println("\n<총혜택 금액>");
        System.out.printf("-%,d원%n", totalBenefitAMount);
    }

    public static void printTotalAmountAfterDiscount(final int totalAmount, final int totalAmountAfterDiscount) {
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.printf("%,d원%n", totalAmount - totalAmountAfterDiscount);
    }

    public static void printBadge(final Badge badge) {
        System.out.println("\n<12월 이벤트 배지>");
        if (badge.getPrice() == 0) {
            System.out.println("없음");
            return;
        }
        System.out.println(badge.getType());
    }
}
