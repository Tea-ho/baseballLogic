package org.example.baseball.object.service.Impl;

import org.example.baseball.object.service.BaseballPitcher;

import java.util.Random;

public class BaseballPitcherImpl implements BaseballPitcher {
    @Override
    public int[] throwBall() {
        int[] numbers = generateRandomNumbers(3, 1, 9);
        return numbers;
    }

    // 로직은 숨기고, 게임 규칙 변경되면 숫자만 변경할 수 있도록
    private int[] generateRandomNumbers(int count, int min, int max) {
        int[] numbers = new int[count];
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            numbers[i] = random.nextInt(max - min + 1) + min;
            for (int j = 0; j < i; j++) {
                if (numbers[i] == numbers[j]) {
                    i--;
                    break;
                }
            }
        }
        return numbers;
    }
}
