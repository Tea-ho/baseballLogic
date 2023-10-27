package org.example;

import java.util.Random;
import java.util.Scanner;

public class BaseballGame {

    public static void main(String[] args) { //
        playGame();
    }

    // playGame 메소드: 게임 작동부
    public static void playGame() {

        // 1. 스캐너 생성
        Scanner scanner = new Scanner(System.in);

        // 2. 컴퓨터 숫자 / 유저 숫자 받을 공간 만들기
        int[] computerNumbers = makeRandomNumbers();
        int[] userNumbers;

        // 3. 맞추기 시도 카운트
        int attempts = 0;

        // 4. 게임 안내
        System.out.println("숫자 야구 게임 스타트, 1부터 9까지의 서로 다른 숫자로 이루어진 3자리 수 맞추기 게임");

        // 5. 게임 동작
        while (true) {
            // 5-1. 입력 (잘못된 키도 우선 입력 받고 아래에서 유효성 검사 진행)
            System.out.print("3자리 숫자를 입력: ");
            String input = scanner.nextLine();

            // 5-2. 유효성 검사 처리
            if ( !isValid(input) ) {
                System.out.println("잘못된 입력: 1부터 9까지의 서로 다른 숫자로 이루어진 3자리 수 입력");
                continue;
            }

            // 5-3. 유저 번호
            userNumbers = parsingInput(input);
            attempts++;

            // 5-4. 결과 판독
            int[] result = compareNumbers(computerNumbers, userNumbers);

            if (result[0] == 3) {
                System.out.println("정답! 시도 횟수! " + attempts);
                break;
            } else {
                System.out.println("결과: " + result[0] + " 스트라이크, " + result[1] + " 볼");
            }
        }

        // 6. 스캐너 닫자
        scanner.close();
    }

    // makeRandomNumbers 메소드: 컴퓨터 번호 3개 랜덤 생성
    public static int[] makeRandomNumbers() {

        int[] numbers = new int[3];
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            numbers[i] = random.nextInt(9) + 1;
            for (int j = 0; j < i; j++) {
                if (numbers[i] == numbers[j]) {
                    i--;
                    break;
                }
            }
        }
        return numbers;
    }

    // isValid 메소드: 입력숫자 유효성 체크
    public static boolean isValid(String input) {
        // 1. 자리수 체크
        if (input.length() != 3) {
            return false;
        }
        // 2. 1~9 사이 확인
        for (char digit : input.toCharArray()) {
            if ( digit < '1' || digit > '9' ) {
                return false;
            }
        }
        return isUnique(input);
    }

    // isUnique 메소드: 1, 2번 항목 적합 시 isUnique 검사 진행[여기서는 변수 필요함]
    // 기능: 입력받은 수에서 중복된 수 없는지 검사
    public static boolean isUnique(String input) {
        // 1. 배열 생성 후 초기화
        char[] digits = input.toCharArray();
        // 2. 중복 검사
        for (int i = 0; i < 2; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (digits[i] == digits[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // parsingInput 메소드: 문자로 인식된거 숫자로 변환 작업
    public static int[] parsingInput(String input) {
        // 1. 받을 공간 생성
        int[] numbers = new int[3];
        // 2. 숫자 변환 작업 (문자 아스키코드 번호 및 연산자 특징 활용)
        for (int i = 0; i < 3; i++) {
            numbers[i] = input.charAt(i) - '0';
        }
        return numbers;
    }

    // compareNumbers 메소드: 결과 비교
    public static int[] compareNumbers(int[] computerNumbers, int[] userNumbers) {
        // 1. 결과 담을 공간: index 0 - 스트라이크, 1 - 볼
        int[] result = new int[2];

        // 2. 비교 작업
        for (int i = 0; i < 3; i++) {
            // 2-1. 스트라이크: 위치 + 내용 같은 경우
            if ( computerNumbers[i] == userNumbers[i] ) {
                result[0]++; // 스트라이크 업업
            } else {
                for (int j = 0; j < 3; j++) {
                    // 2-2. 볼: 위치는 다른데 내용만 같은 경우
                    if ( computerNumbers[i] == userNumbers[j] ) {
                        result[1]++; // 볼 업업
                    }
                }
            }
        }
        // 3. 결과 반환
        return result;
    }
}
