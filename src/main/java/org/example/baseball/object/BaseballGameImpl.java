package org.example.baseball.object;

import inter.InputOutputHandler;
import org.example.baseball.object.dto.BallDto;
import org.example.baseball.object.dto.ResultDto;
import org.example.baseball.object.dto.RuleDto;
import org.example.baseball.object.service.Impl.BaseballBatterImpl;
import org.example.baseball.object.service.Impl.BaseballPitcherImpl;
import org.example.baseball.object.service.Impl.BaseballUmpireImpl;

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
        RuleDto rule = new RuleDto(3);
        int[] comNumbers = pitcher.throwBall(rule);

        while (true) {

            int[] userNumbers = batter.hitBall(rule);
            if( userNumbers == null){
                inputOutputHandler.printMessage("잘못된 입력: 1부터 9까지의 서로 다른 숫자로 이루어진 3자리 수 입력");
                continue;
            }

            BallDto ballDto = new BallDto( comNumbers, userNumbers );
            ResultDto result = umpire.judgment(ballDto);

            if( result.isResult() ){
                inputOutputHandler.printMessage("정답! 시도 횟수: " + result.getAttempts());
                inputOutputHandler.closeScanner();
                break;
            } else{
                inputOutputHandler.printMessage("결과: " + result.getCountStrikes() + " 스트라이크, " + result.getCountBalls()+ " 볼");
            }
        }
    }
}