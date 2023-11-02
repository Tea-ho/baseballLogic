package org.example.baseball.function;

public class BaseballValidate {
    
    // 기능: 입력받은 수에서 중복된 수 없는지 검사
    public static boolean isUnique(String input) {
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

    // 자리수 체크
    public static boolean checkLength(String input, int length){
        if (input.length() != length) {
            return false;
        }
        return true;
    }

    // 입력값 범위 체크 (범위: 1~9)
    public static boolean checkRange(String input){
        // 2. 1~9 사이 확인
        for (char digit : input.toCharArray()) {
            if ( digit < '1' || digit > '9' ) {
                return false;
            }
        }
        return true;
    }

}
