package org.example.baseball.object;

import inter.InputOutputHandler;

public class BaseballGame { // 게임 객체는 투수와 타자, 심판, 그리고 조이스틱(입출력)으로 구성되고 각각의 객체는 협력이 불가피한 관계 (최종결과(횟수)는 상태 체크)
    private BaseballPitcher pitcher; // 투수: 컴퓨터 (의존성 주입)
    private BaseballBatter batter; // 타자: 사용자 (의존성 주입)
    private BaseballUmpire umpire; // 심판: 유효성 검사 역할 (의존성 주입)
    private int attempts; // 횟수: 최종결과 (상태변수)
    private InputOutputHandler inputOutputHandler; // 입출력 장치: 조이스틱 (의존성 주입)

    public BaseballGame(BaseballPitcher pitcher, BaseballBatter batter, BaseballUmpire umpire, InputOutputHandler inputOutputHandler) {
        this.pitcher = pitcher;
        this.batter = batter;
        this.umpire = umpire;
        this.attempts = 0;
        this.inputOutputHandler = inputOutputHandler;
    }

    public void playGame() {
        inputOutputHandler.printMessage("숫자 야구 게임 스타트, 1부터 9까지의 서로 다른 숫자로 이루어진 3자리 수 맞추기 게임");

        // 투수 공 생성(난수)
        pitcher.throwBallNumbers();

        while (true) {
            // 사용자 방망이질 (입력장치를 통해 숫자 입력)
            String input = batter.hit();

            // 심판이 유효성 체크
            if (!umpire.validate(input)) {
                inputOutputHandler.printMessage("잘못된 입력: 1부터 9까지의 서로 다른 숫자로 이루어진 3자리 수 입력");
                continue;
            }

            // 심판이 유효한 볼인지 최종 확인
            int[] userNumbers = umpire.parseBallType(input);
            attempts++; // 횟수 증가

            // 심판이 결과 판독
            int[] result = umpire.judgment(pitcher.getBallNumbers(), userNumbers);

            // 전광판 객체로 하나 빼야되나..
            if (result[0] == 3) {
                inputOutputHandler.printMessage("정답! 시도 횟수: " + attempts); // 최종 결과
                break;
            } else {
                inputOutputHandler.printMessage("결과: " + result[0] + " 스트라이크, " + result[1] + " 볼"); // 힌트 안내
            }
        }
    }
}