package org.example.baseball.object.service.Impl;

import inter.InputOutputHandler;
import org.example.baseball.object.service.BaseballBatter;
import org.example.baseball.object.service.Validator;

public class BaseballBatterImpl implements BaseballBatter, Validator<String> {
    private InputOutputHandler inputOutputHandler; // 의존성 주입
    public BaseballBatterImpl(InputOutputHandler inputOutputHandler) {
        this.inputOutputHandler = inputOutputHandler;
    }

    @Override
    public int[] hitBall() {
        inputOutputHandler.printMessage("3자리 숫자를 입력: ");
        String input = inputOutputHandler.getInput();

        if( !validate(input) ){
            return null;
        }

        // 예외처리로 끝내도 됨 (그냥 진행하고 싶어서 null로 반환함)
/*        if (!validate(input)) {
            throw new IllegalArgumentException("잘못된 입력: 1부터 9까지의 서로 다른 숫자로 이루어진 3자리 수 입력");
        }*/
        return parseBallType(input);
    }

    private int[] parseBallType(String input) {
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = input.charAt(i) - '0';
        }
        return numbers;
    }

    @Override
    public boolean validate(String input) {
        return checkLength(input, 3) && isUnique(input) && checkRange(input);
    }

     private boolean isUnique(String input) {
        char[] digits = input.toCharArray();
        for (int i = 0; i < 2; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (digits[i] == digits[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkLength(String input, int length){
        if (input.length() != length) {
            return false;
        }
        return true;
    }

    private boolean checkRange(String input){
        for (char digit : input.toCharArray()) {
            if ( digit < '1' || digit > '9' ) {
                return false;
            }
        }
        return true;
    }
}