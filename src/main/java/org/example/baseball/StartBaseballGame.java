package org.example.baseball;

import inter.InputOutputHandler;
import org.example.baseball.function.BaseballInputOutputHandler;
import org.example.baseball.function.BaseballPlayGame;
import org.example.baseball.object.BaseballBatter;
import org.example.baseball.object.BaseballGame;
import org.example.baseball.object.BaseballPitcher;
import org.example.baseball.object.BaseballUmpire;

public class StartBaseballGame {
  /*  public static void main(String[] args) {
        BaseballPlayGame.playGame();
    }*/
    public static void main(String[] args) {
        InputOutputHandler inputOutputHandler = new BaseballInputOutputHandler();
        BaseballPitcher pitcher = new BaseballPitcher();
        BaseballBatter batter = new BaseballBatter(inputOutputHandler);
        BaseballUmpire umpire = new BaseballUmpire();

        BaseballGame game = new BaseballGame(pitcher, batter, umpire, inputOutputHandler);
        game.playGame();

        inputOutputHandler.closeScanner();
    }
}