package org.example.baseball.object.service.Impl;

import inter.InputOutputHandler;
import org.example.baseball.object.dto.RuleDto;
import org.example.baseball.object.service.BaseballBatter;

public class BaseballBatterImpl implements BaseballBatter {
    private InputOutputHandler inputOutputHandler;
    private BaseballValidatorImpl validator;
    public BaseballBatterImpl(InputOutputHandler inputOutputHandler) {
        this.inputOutputHandler = inputOutputHandler;
        this.validator = new BaseballValidatorImpl();
    }

    @Override
    public int[] hitBall(RuleDto rule) {
        inputOutputHandler.printMessage("3자리 숫자를 입력: ");
        String input = inputOutputHandler.getInput();
        if( !validator.validate(input) ){
            return null;
        }
        return parseBallType(input, rule.getRuleNumbers());
    }

    private int[] parseBallType(String input, int ruleNums) {
        int[] numbers = new int[ruleNums];
        for (int i = 0; i < ruleNums; i++) {
            numbers[i] = input.charAt(i) - '0';
        }
        return numbers;
    }
}