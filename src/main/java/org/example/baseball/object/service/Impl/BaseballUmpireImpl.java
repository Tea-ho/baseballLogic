package org.example.baseball.object.service.Impl;
import org.example.baseball.object.dto.BallDto;
import org.example.baseball.object.dto.ResultDto;
import org.example.baseball.object.service.BaseballUmpire;

public class BaseballUmpireImpl implements BaseballUmpire {
    private int attempts;

    public ResultDto judgment(BallDto ballDto) {
        int strikeCount = countStrikes(ballDto);
        int ballCount = countBalls(ballDto);
        attempts++;
        return new ResultDto(strikeCount, ballCount, attempts);
    }

    private int countStrikes(BallDto ballDto) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (ballDto.getComNumbers()[i] == ballDto.getUserNumbers()[i]) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int countBalls(BallDto ballDto) {
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ballDto.getComNumbers()[i] == ballDto.getUserNumbers()[j] && i != j) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }
}

