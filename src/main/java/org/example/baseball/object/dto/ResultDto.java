package org.example.baseball.object.dto;

public class ResultDto {
    private final int strikeCount;
    private final int ballCount;
    private final int attempts;
    private boolean result;

    public ResultDto(int strikeCount, int ballCount, int attempts) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
        this.attempts = attempts;
        if(strikeCount == 3){
            this.result = true;
        }
    }

    public ResultDto(int strikeCount, int ballCount, int attempts, boolean result) {
        this.attempts = attempts;
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
        this.result = result;
    }

    public int getAttempts() {
        return attempts;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean isResult() {
        return result;
    }

}
