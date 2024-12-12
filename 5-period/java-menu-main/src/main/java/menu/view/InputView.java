package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.error.ErrorMessages;

public final class InputView {
    private InputView() {
    }

    public static String read() {
        System.out.println("");
        String input = Console.readLine().strip();

        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_INPUT.getMessage());
        }

        return input;
    }
}
