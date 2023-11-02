package org.example.baseball.object.service.Impl;

import inter.InputOutputHandler;
import org.example.baseball.object.service.BaseballBatter;

public class BaseballBatterImpl implements BaseballBatter {
    private InputOutputHandler inputOutputHandler; // 의존성 주입
    private BaseballValidatorImpl validator; // 의존성 주입
    public BaseballBatterImpl(InputOutputHandler inputOutputHandler) {
        this.inputOutputHandler = inputOutputHandler;
    }

    @Override
    public int[] hitBall() {
        inputOutputHandler.printMessage("3자리 숫자를 입력: ");
        String input = inputOutputHandler.getInput();

        if( !validator.validate(input) ){
            return null;
        }
        return parseBallType(input);
    }

    private int[] parseBallType(String input) {
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = input.charAt(i) - '0';
        }
        return numbers;
    }
}