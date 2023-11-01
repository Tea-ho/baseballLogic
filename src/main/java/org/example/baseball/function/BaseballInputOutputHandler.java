package org.example.baseball.function;

import inter.InputOutputHandler;

import java.util.Scanner;

public class BaseballInputOutputHandler implements InputOutputHandler {
    private Scanner scanner;

    public BaseballInputOutputHandler() {
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
