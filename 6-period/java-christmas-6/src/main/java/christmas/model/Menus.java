package christmas.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum Menus {
    Appetizer(
            new MenuItem("양송이수프", 6000),
            new MenuItem("타파스", 5500),
            new MenuItem("시저샐러드", 8000)
    ),
    MAIN(
            new MenuItem("티본스테이크", 55000),
            new MenuItem("바비큐립", 54000),
            new MenuItem("해산물파스타", 35000),
            new MenuItem("크리스마스파스타", 25000)
    ),
    DESSERT(
            new MenuItem("초코케이크", 15000),
            new MenuItem("아이스크림", 5000)
    ),
    Beverage(
            new MenuItem("제로콜라", 3000),
            new MenuItem("레드와인", 60000),
            new MenuItem("샴페인", 25000)
    );

    private final MenuItem[] menuItems;

    Menus(MenuItem... menuItem) {
        this.menuItems = menuItem;
    }

    public static boolean have(String menuName) {
        for (Menus value : Menus.values()) {
            final Optional<MenuItem> item = Arrays.stream(value.menuItems)
                    .filter(o -> o.name().equals(menuName))
                    .findAny();
            if (item.isPresent()) {
                return true;
            }
        }
       throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요. - 존재 x");
    }

    public static boolean isBeverage(String menuName) {
        return Arrays.stream(Menus.Beverage.menuItems)
                .anyMatch(beverage -> beverage.name().equals(menuName));
    }

    public static Map<String, Integer> findDesserts(String[] menuNames) {
        Map<String, Integer> desserts = new HashMap<>();
        for (MenuItem item : Menus.DESSERT.menuItems) {
            if(Arrays.stream(menuNames).anyMatch(item.name()::equals)) {
                desserts.put(item.name(), item.price());
            }
        }
        return desserts;
    }

    public static Map<String, Integer> findMainMenuByMenuNames(String[] menuNames) {
        Map<String, Integer> mainMenus = new HashMap<>();
        for (MenuItem item : Menus.MAIN.menuItems) {
            if(Arrays.stream(menuNames).anyMatch(item.name()::equals)) {
                mainMenus.put(item.name(), item.price());
            }
        }
        return mainMenus;
    }

    public static int calculateTotalAmount(String[] menuNames) {
        int totalAmount = 0;
        for (String menuName : menuNames) {
            totalAmount += Arrays.stream(Menus.values())
                    .mapToInt(o -> Arrays.stream(o.menuItems).
                            filter(k -> k.name().equals(menuName)).mapToInt(t->t.price()).sum())
                    .sum();

        }
        return totalAmount;
    }
}
