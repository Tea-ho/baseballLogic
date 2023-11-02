package org.example.baseball.object.service;

import org.example.baseball.object.dto.BallDto;
import org.example.baseball.object.dto.ResultDto;

public interface BaseballUmpire {
    ResultDto judgment(BallDto ballDto);
}
