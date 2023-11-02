package org.example.baseball.object.service.Impl;
import org.example.baseball.object.dto.BallDto;
import org.example.baseball.object.dto.ResultDto;
import org.example.baseball.object.service.BaseballUmpire;

public class BaseballUmpireImpl implements BaseballUmpire {

    private int attempts;

    public ResultDto judgment(BallDto ballDto) {

        int strikeCount = 0;
        int ballCount = 0;
        attempts++;

        for (int i = 0; i < 3; i++) {
            if (ballDto.getComNumbers()[i] == ballDto.getUserNumbers()[i]) {
                System.out.println("check strike");
                strikeCount++; // 스트라이크
            } else {
                for (int j = 0; j < 3; j++) {
                    if (ballDto.getComNumbers()[i] == ballDto.getUserNumbers()[j] && i != j) {
                        System.out.println("check ball");
                        ballCount++; // 볼
                    }
                }
            }
        }

        return new ResultDto(strikeCount, ballCount, attempts);
    }
}
