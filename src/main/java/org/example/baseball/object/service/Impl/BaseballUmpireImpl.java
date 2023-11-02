package org.example.baseball.object.service.Impl;
import org.example.baseball.object.service.BaseballUmpire;

public class BaseballUmpireImpl implements BaseballUmpire {

    private int ballCount;
    private int strikeCount;
    private int attempts;


    @Override
    public boolean judgment(int[] comNumbers, int[] userNumbers) {

        ballCount = 0;
        strikeCount = 0;
        attempts++;

        for (int i = 0; i < 3; i++) {
            // 2-1. 스트라이크: 위치 + 내용 같은 경우
            if ( comNumbers[i] == userNumbers[i] ) {
                strikeCount++; // 스트라이크 업업
            } else {
                for (int j = 0; j < 3; j++) {
                    // 2-2. 볼: 위치는 다른데 내용만 같은 경우
                    if ( comNumbers[i] == userNumbers[j] ) {
                        ballCount++; // 볼 업업
                    }
                }
            }
        }

        if( strikeCount == 3 ){
            return true;
        }
        return false;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getAttempts() {
        return attempts;
    }
}