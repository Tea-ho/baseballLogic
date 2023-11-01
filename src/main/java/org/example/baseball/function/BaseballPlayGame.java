package org.example.baseball.function;

import inter.InputOutputHandler;
import inter.RandomNumberGenerator;

public class BaseballPlayGame {
    // playGame 메소드: 게임 작동부
    // 리팩토링: 입출력은 우선 인터페이스로 빼자
    public static void playGame() {

        // 1. 스캐너 생성
        InputOutputHandler inputOutputHandler = new BaseballInputOutputHandler();

        // 2. 컴퓨터 숫자 / 유저 숫자 받을 공간 만들기
        RandomNumberGenerator computerNumberGenerator = new BaseballComNumberGenerator();
        int[] computerNumbers = computerNumberGenerator.generateRandomNumbers();
        int[] userNumbers;

        // 3. 맞추기 시도 카운트
        int attempts = 0;

        // 4. 게임 안내
        inputOutputHandler.printMessage("숫자 야구 게임 스타트, 1부터 9까지의 서로 다른 숫자로 이루어진 3자리 수 맞추기 게임");

        // 5. 게임 동작
        while (true) {
            // 5-1. 입력 (잘못된 키도 우선 입력 받고 아래에서 유효성 검사 진행)
            inputOutputHandler.printMessage("3자리 숫자를 입력: ");
            String input = inputOutputHandler.getInput();

            // 5-2. 유효성 검사 처리
            if ( !BaseballValidate.checkLength(input) || !BaseballValidate.isUnique(input) || !BaseballValidate.checkRange(input) ) {
                inputOutputHandler.printMessage("잘못된 입력: 1부터 9까지의 서로 다른 숫자로 이루어진 3자리 수 입력");
                continue;
            }

            // 5-3. 유저 번호
            userNumbers = BaseballTypeCasting.parsingInput(input);
            attempts++;

            // 5-4. 결과 판독
            int[] result = BaseballResultHandler.compareNumbers(computerNumbers, userNumbers);

            if (result[0] == 3) {
                inputOutputHandler.printMessage("정답! 시도 횟수: " + attempts);
                break;
            } else {
                inputOutputHandler.printMessage("결과: " + result[0] + " 스트라이크, " + result[1] + " 볼");
            }
        }

        // 6. 스캐너 닫자
        inputOutputHandler.closeScanner();
    }
}
