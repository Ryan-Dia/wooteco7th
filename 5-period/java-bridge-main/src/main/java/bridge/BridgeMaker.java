package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validateSize(size);
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < size) {
            randomNumbers.add(bridgeNumberGenerator.generate());
        }
        return parseToString(randomNumbers);
    }

    private void validateSize(int size) {
        if(size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 3이상 20이하의 숫자만 입력 가능합니다.");
        }
    }

    private List<String> parseToString(List<Integer> randomNumbers) {
        return randomNumbers.stream()
                .map(number -> number == 1 ? "U" : "D")
                .toList();
    }
}
