package org.example.baseball.object.service.Impl;

import inter.InputOutputHandler;

public class BaseballGameImpl {
    private BaseballPitcherImpl pitcher;
    private BaseballBatterImpl batter;
    private BaseballUmpireImpl umpire;
    private InputOutputHandler inputOutputHandler;

    public BaseballGameImpl(BaseballPitcherImpl pitcher, BaseballBatterImpl batter, BaseballUmpireImpl umpire, InputOutputHandler inputOutputHandler) {
        this.pitcher = pitcher;
        this.batter = batter;
        this.umpire = umpire;
        this.inputOutputHandler = inputOutputHandler;
    }

    public void playGame() {
        inputOutputHandler.printMessage("숫자 야구 게임 스타트, 1부터 9까지의 서로 다른 숫자로 이루어진 3자리 수 맞추기 게임");
        int[] comNumbers = pitcher.throwBall();

        while (true) {
            int[] userNumbers = batter.hitBall();

            if( userNumbers == null){
                continue;
            }

            if( umpire.judgment(comNumbers, userNumbers) ){
                inputOutputHandler.printMessage("정답! 시도 횟수: " + umpire.getAttempts());
                inputOutputHandler.closeScanner();
                break;
            } else{
                inputOutputHandler.printMessage("결과: " + umpire.getStrikeCount() + " 스트라이크, " + umpire.getBallCount()+ " 볼");
            }
        }
    }
}