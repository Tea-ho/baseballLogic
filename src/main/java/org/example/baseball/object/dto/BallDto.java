package org.example.baseball.object.dto;

public class BallDto {
    private final int[] comNumbers;
    private final int[] userNumbers;

    public BallDto(int[] comNumbers, int[] userNumbers) {
        this.comNumbers = comNumbers.clone();
        this.userNumbers = userNumbers.clone();
    }

    public int[] getComNumbers() {
        return comNumbers.clone();
    }

    public int[] getUserNumbers() {
        return userNumbers.clone();
    }
}
