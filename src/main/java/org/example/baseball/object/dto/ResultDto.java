package org.example.baseball.object.dto;

public class ResultDto {
    private final int countStrikes;
    private final int countBalls;
    private final int attempts;
    private boolean result;

    public ResultDto(int countStrikes, int countBalls, int attempts) {
        this.countStrikes = countStrikes;
        this.countBalls = countBalls;
        this.attempts = attempts;
        if(countStrikes == 3){
            this.result = true;
        }
    }

    public ResultDto(int countStrikes, int countBalls, int attempts, boolean result) {
        this.attempts = attempts;
        this.countBalls = countBalls;
        this.countStrikes = countStrikes;
        this.result = result;
    }

    public int getCountStrikes() {
        return countStrikes;
    }

    public int getCountBalls() {
        return countBalls;
    }

    public int getAttempts() {
        return attempts;
    }

    public boolean isResult() {
        return result;
    }
}
