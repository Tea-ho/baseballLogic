package org.example.baseball;

import inter.InputOutputHandler;
import org.example.baseball.function.BaseballInputOutputHandler;
import org.example.baseball.object.service.Impl.BaseballBatterImpl;
import org.example.baseball.object.BaseballGameImpl;
import org.example.baseball.object.service.Impl.BaseballPitcherImpl;
import org.example.baseball.object.service.Impl.BaseballUmpireImpl;

public class StartBaseballGame {
    public static void main(String[] args) {
        InputOutputHandler inputOutputHandler = new BaseballInputOutputHandler();
        BaseballPitcherImpl pitcher = new BaseballPitcherImpl();
        BaseballBatterImpl batter = new BaseballBatterImpl(inputOutputHandler);
        BaseballUmpireImpl umpire = new BaseballUmpireImpl();

        BaseballGameImpl game = new BaseballGameImpl(pitcher, batter, umpire, inputOutputHandler);
        game.playGame();
    }
}