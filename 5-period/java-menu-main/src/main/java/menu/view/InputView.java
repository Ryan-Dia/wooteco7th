package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.error.ErrorMessages;

public final class InputView {
    private InputView() {
    }

    public static String readCoachName() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input = Console.readLine().strip();

        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_INPUT.getMessage());
        }

        return input;
    }
}
