package christmas.model.order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.model.Menu;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrderTest {

    @Test
    void Order객체가_올바르게_생성() {
        // given
        final Menu menu = Menu.findByMenuName("티본스테이크");
        final int quantity = 6;

        // when
        final Order order = new Order(menu, 6);

        // then
        assertThat(order.getMenu()).isEqualTo(menu);
        assertThat(order.getQuantity()).isEqualTo(quantity);
    }

    @Test
    void 메뉴의_타입이_음료일때_true_출력() {
        // given
        final Menu menu = Menu.findByMenuName("레드와인");
        final int quantity = 2;
        final Order order = new Order(menu, quantity);
        // when
        final boolean isBeverage = order.isBeverage();
        // then
        assertThat(isBeverage).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 101})
    void 주문수량이_올바르지_않으면_예외(int input) {
        // given
        final Menu menu = Menu.findByMenuName("레드와인");

        // when

        // then
        assertThatThrownBy(() -> new Order(menu, input)).isInstanceOf(IllegalArgumentException.class);
    }

}
