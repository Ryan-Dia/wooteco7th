package christmas.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Order {
    private static final String REGEX = "^([가-힣]+-\\d{1,2})(,[가-힣]+-\\d{1,2})*$";
    private final Map<String, Integer> order = new HashMap<>();
    private final int totalAmount;



    public Order(String[] input) {
        for (String menuInfo : input) {
            final String[] info = menuInfo.split("-");
            String menu = info[0];
            int price = Integer.parseInt(info[1]);
            Menus.have(menu);
            if(order.get(menu) != null) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요. - 중복");
            }
            order.put(menu, price);
        }
        validateOrder();
        this.totalAmount = calculateTotalAmount();
    }

    private int calculateTotalAmount() {
        return Menus.calculateTotalAmount(order.entrySet());
    }

    private void validateOrder() {
        NotOnlyBeverage();
        validateCount();
    }

    private void validateCount() {
        for (int count : order.values()) {
            if (count < 1 || count >20) {
                throw new IllegalArgumentException("[ERROR] 메뉴는 1개이상 또는 20개 이하로 주문할 수 있습니다.");
            }
        }
    }

    private void NotOnlyBeverage() {
        final Set<String> menuNames = order.keySet();
        final boolean isOnlyBeverage = menuNames.stream().allMatch(menuName -> Menus.isBeverage(menuName.toString()));
        if(isOnlyBeverage) {
            throw new IllegalArgumentException("[ERROR] 음료만 주문할 수 없습니다.");
        }
    }

    public static Order of(String input) {
        return new Order(parse(input));
    }

    private static String[] parse(String input) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(input);
        if(!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요. - 형식");
        }
        return input.split(",");
    }

    public Map<String, Integer> getOrder() {
        return order;
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}
