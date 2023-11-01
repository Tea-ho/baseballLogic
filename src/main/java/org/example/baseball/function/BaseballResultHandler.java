package org.example.baseball.function;

public class BaseballResultHandler {
    // compareNumbers 메소드: 결과 비교
    protected static int[] compareNumbers(int[] computerNumbers, int[] userNumbers) {
        // 1. 결과 담을 공간: index 0 - 스트라이크, 1 - 볼
        int[] result = new int[2];

        // 2. 비교 작업
        for (int i = 0; i < 3; i++) {
            // 2-1. 스트라이크: 위치 + 내용 같은 경우
            if ( computerNumbers[i] == userNumbers[i] ) {
                result[0]++; // 스트라이크 업업
            } else {
                for (int j = 0; j < 3; j++) {
                    // 2-2. 볼: 위치는 다른데 내용만 같은 경우
                    if ( computerNumbers[i] == userNumbers[j] ) {
                        result[1]++; // 볼 업업
                    }
                }
            }
        }
        // 3. 결과 반환
        return result;
    }
}
