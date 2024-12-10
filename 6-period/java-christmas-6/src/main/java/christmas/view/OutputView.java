package christmas.view;

import christmas.dto.OrderMenusDto;
import christmas.dto.PresentationDto;
import christmas.model.Discount;
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
        System.out.printf("%,d원%n", totalAmount);
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

    public static void printBenefit(Discount discount) {
        System.out.println("\n<혜택 내역>");
        final int christmas = discount.christmas();
        final int weekEnd = discount.weekEnd();
        final int weekDay = discount.weekDay();
        final int presentation = discount.presentation();
        final int special = discount.special();
        if(christmas != 0) {
            System.out.printf("크리스마스 디데이 할인: -%,d%n", christmas);
        }
        if(weekEnd != 0) {
            System.out.printf("주말 할인: -%,d%n", weekEnd);
        }
        if(weekDay != 0) {
            System.out.printf("평일 할인: -%,d%n", weekDay);
        }
        if(special != 0) {
            System.out.printf("특별 할인: -%,d%n", special);
        }
        if(presentation != 0) {
            System.out.printf("증정 이벤트: -%,d%n", presentation);
        }
        if(special  == 0 && presentation == 0 && weekDay == 0 && weekEnd == 0 && christmas == 0) {
            System.out.println("없음%n");
        }
    }

    public static void printTotalBenefitAmount(int totalAmount) {
        System.out.println("\n<총혜택 금액>");
        if(totalAmount == 0) {
            System.out.println("0원");
            return;
        }
        System.out.printf("-%,d원%n", totalAmount);
    }

    public static void printTotalAmountAfterDiscount(int totalAmount, int totalBenefitAmount) {
        int result = totalAmount - totalBenefitAmount;
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.printf("%,d원%n", result);
    }
}
