package menu.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int RANDOM_START = 1;
    private static final int RANDOM_END = 5;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(RANDOM_START, RANDOM_END);
    }
}
