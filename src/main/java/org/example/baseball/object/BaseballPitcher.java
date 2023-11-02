package org.example.baseball.object;

import java.util.Random;

public class BaseballPitcher {
    private int[] numbers;

    public int[] getBallNumbers() {
        return numbers;
    }

    public void throwBallNumbers() {
        // 컴퓨터 번호 3개 무작위 생성 (중복 미허용)
        numbers = new int[3];
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            numbers[i] = random.nextInt(9) + 1;
            for (int j = 0; j < i; j++) {
                if (numbers[i] == numbers[j]) {
                    i--;
                    break;
                }
            }
        }
    }
}
