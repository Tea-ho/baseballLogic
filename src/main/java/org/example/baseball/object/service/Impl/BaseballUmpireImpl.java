package org.example.baseball.object.service.Impl;
import org.example.baseball.object.dto.BallDto;
import org.example.baseball.object.dto.ResultDto;
import org.example.baseball.object.service.BaseballUmpire;

public class BaseballUmpireImpl implements BaseballUmpire {
    private int attempts;

    public ResultDto judgment(BallDto ballDto) {
        int countStrikes = countStrikes(ballDto);
        int countBalls = countBalls(ballDto);
        attempts++;
        return new ResultDto(countStrikes, countBalls, attempts);
    }

    private int countStrikes(BallDto ballDto) {
        int countStrikes = 0;
        for (int i = 0; i < 3; i++) {
            if (ballDto.getComNumbers()[i] == ballDto.getUserNumbers()[i]) {
                countStrikes++;
            }
        }
        return countStrikes;
    }

    private int countBalls(BallDto ballDto) {
        int countBalls = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ballDto.getComNumbers()[i] == ballDto.getUserNumbers()[j] && i != j) {
                    countBalls++;
                }
            }
        }
        return countBalls;
    }
}

