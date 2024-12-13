package christmas.model;

import static christmas.model.MenuType.APPETIZER;
import static christmas.model.MenuType.BEVERAGE;
import static christmas.model.MenuType.DESSERT;
import static christmas.model.MenuType.MAIN;

import christmas.error.CIllegalArgumentException;
import christmas.error.ErrorMessages;
import java.util.Arrays;

public enum Menu {
    SOUP(APPETIZER, "양송이수프", 6000),
    TAPAS(APPETIZER, "타파스", 5500),
    SALAD(APPETIZER, "시저샐러드", 8000),

    STEAK(MAIN, "티본스테이크", 55000),
    BARBECUE_RIBS(MAIN, "바비큐립", 54000),
    PASTA(MAIN, "해산물파스타", 35000),

    CHOCO_CAKE(DESSERT, "초코케이크", 15_000),
    ICE_CREAM(DESSERT, "아이스크림", 5_000),

    ZERO_COKE(BEVERAGE, "제로콜라", 3_000),
    RED_WINE(BEVERAGE, "레드와인", 60_000),
    CHAMPAGNE(BEVERAGE, "샴페인", 25_000);

    private final MenuType menuType;
    private final String menuName;
    private final int price;

    Menu(final MenuType menuType, final String menuName, final int price) {
        this.menuType = menuType;
        this.menuName = menuName;
        this.price = price;
    }

    public static Menu findByMenuName(String inputMenuName) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.menuName.equals(inputMenuName))
                .findAny()
                .orElseThrow(() -> new CIllegalArgumentException(ErrorMessages.INVALID_ORDER));
    }

    public int getPrice() {
        return price;
    }

    public MenuType getMenuType() {
        return menuType;
    }

    public String getMenuName() {
        return menuName;
    }
}
