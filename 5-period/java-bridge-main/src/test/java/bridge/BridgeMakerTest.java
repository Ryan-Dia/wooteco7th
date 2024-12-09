package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {

    @Test
    void 길이에_맞는_올바른_다리를_생성(){
        // given
        final BridgeMaker bridgeMaker = new BridgeMaker(()->1);

        // when
        List<String> result = bridgeMaker.makeBridge(3);

        // then
        assertThat(result).isEqualTo(Arrays.asList("U", "U", "U"));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 21})
    void 삼미만_이십초과의_숫자를_입력시_예외_발생 (int input){
        // given
        final BridgeMaker bridgeMaker = new BridgeMaker(()->1);

        // when
        // then
        assertThatThrownBy(() -> bridgeMaker.makeBridge(2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
