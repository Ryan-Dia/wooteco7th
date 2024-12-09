package bridge.controller;

import bridge.InputView;
import bridge.OutputView;

public class BridgeController {

    public void run() {
        OutputView.printStartMessage();
        InputView.readBridgeSize();
    }
}
