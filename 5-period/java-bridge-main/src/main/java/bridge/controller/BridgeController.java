package bridge.controller;

import bridge.BridgeGame;
import bridge.InputView;
import bridge.OutputView;

public class BridgeController {

    private final BridgeGame bridgeGame;

    public BridgeController(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public void run() {
        OutputView.printStartMessage();
        final int bridgeSize = InputView.readBridgeSize();
        bridgeGame.setBridgeGame(bridgeSize);

    }
}
