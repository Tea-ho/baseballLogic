package org.example.baseball.function;

import org.example.baseball.inter.InputOutputHandler;

import java.util.Scanner;

public class BaseballGameInputOutputHandler implements InputOutputHandler {
    private Scanner scanner;

    public BaseballGameInputOutputHandler() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String getInput() {
        return scanner.nextLine();
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void closeScanner() {
        scanner.close();
    }
}
