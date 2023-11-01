package org.example.baseball.function;

public class BaseballGameValidate {
    // isValid 메소드: 입력숫자 유효성 체크
    // 유효성 검사는 상황에 따라 항목 자체가 변경될 수 있으니 그대로 유지
    protected static boolean isValid(String input) {
        // 1. 자리수 체크
        if (input.length() != 3) {
            return false;
        }
        // 2. 1~9 사이 확인
        for (char digit : input.toCharArray()) {
            if ( digit < '1' || digit > '9' ) {
                return false;
            }
        }
        return isUnique(input);
    }

    // isUnique 메소드: 1, 2번 항목 적합 시 isUnique 검사 진행[여기서는 변수 필요함]
    // 기능: 입력받은 수에서 중복된 수 없는지 검사
    protected static boolean isUnique(String input) {
        // 1. 배열 생성 후 초기화
        char[] digits = input.toCharArray();
        // 2. 중복 검사
        for (int i = 0; i < 2; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (digits[i] == digits[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
