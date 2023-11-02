package org.example.baseball.object;

import inter.InputOutputHandler;

public class BaseballBatter {
    private InputOutputHandler inputOutputHandler;

    public BaseballBatter(InputOutputHandler inputOutputHandler) {
        this.inputOutputHandler = inputOutputHandler;
    }

    public String getInput() {
        inputOutputHandler.printMessage("3자리 숫자를 입력: ");
        return inputOutputHandler.getInput();
    }
}