package menu.model.coach;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachTest {

    @ParameterizedTest
    @ValueSource(strings = {"토토", "미미", "케케"})
    void 올바른값을_입력했을_때_통과(String input) {
        // given
        final Coach coach = new Coach(input);

        // when

        // then
        assertThat(coach.getName()).isEqualTo(input);
    }

    @Test
    void 한글이_아니면_예외() {
        // given
        // when
        // then
        assertThatThrownBy(() -> new Coach("hi")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"한", "다섯글자용"})
    void 요구되는_글자수가_아니면_예외(String input) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new Coach(input)).isInstanceOf(IllegalArgumentException.class);
    }


}
