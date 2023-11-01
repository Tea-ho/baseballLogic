package org.example.baseball.function;

public class BaseballGameTypeCasting {
    // parsingInput 메소드: 문자로 인식된거 숫자로 변환 작업
    protected static int[] parsingInput(String input) {
        // 1. 받을 공간 생성
        int[] numbers = new int[3];
        // 2. 숫자 변환 작업 (문자 아스키코드 번호 및 연산자 특징 활용)
        for (int i = 0; i < 3; i++) {
            numbers[i] = input.charAt(i) - '0';
        }
        return numbers;
    }
}
