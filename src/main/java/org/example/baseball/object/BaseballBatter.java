package org.example.baseball.object;

import inter.InputOutputHandler;

public class BaseballBatter {
    private InputOutputHandler inputOutputHandler; // 의존성 주입

    public BaseballBatter(InputOutputHandler inputOutputHandler) {
        this.inputOutputHandler = inputOutputHandler;
    }

    public String hit() {
        inputOutputHandler.printMessage("3자리 숫자를 입력: ");
        return inputOutputHandler.getInput();
    }
}