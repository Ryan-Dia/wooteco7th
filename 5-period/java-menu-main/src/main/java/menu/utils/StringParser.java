package menu.utils;

import java.util.Arrays;
import java.util.List;

public final class StringParser {

    private static final int SPLIT_LIMIT = -1;

    private StringParser() {
    }

    public static List<String> parseToTokens(final String value, final String delimiter) {
        return Arrays.stream(value.split(delimiter, SPLIT_LIMIT))
                .toList();
    }
}
