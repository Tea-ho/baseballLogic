package org.example.baseball.object.service;

import org.example.baseball.object.dto.BallDto;
import org.example.baseball.object.dto.RuleDto;

public interface BaseballPitcher {
    int[] throwBall(RuleDto rule);
}
