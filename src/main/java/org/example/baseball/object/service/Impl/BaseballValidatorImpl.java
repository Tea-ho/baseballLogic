package org.example.baseball.object.service.Impl;

import org.example.baseball.object.service.Validator;

public class BaseballValidatorImpl implements Validator<String> {
    @Override
    public boolean validate(String input) {
        return checkLength(input, 3) && isUnique(input) && checkRange(input);
    }

    private boolean checkLength(String input, int length){ // 길이 조건만 바뀌면 인수 변경해주면됨
        if (input.length() != length) {
            return false;
        }
        return true;
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

    private boolean checkRange(String input){
        for (char digit : input.toCharArray()) {
            if ( digit < '1' || digit > '9' ) {
                return false;
            }
        }
        return true;
    }
}
