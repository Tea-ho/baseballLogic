package org.example.baseball.object;

import org.example.baseball.function.BaseballResultHandler;
import org.example.baseball.function.BaseballTypeCasting;
import org.example.baseball.function.BaseballValidate;

public class BaseballUmpire {
    public boolean validate(String input) {
        return BaseballValidate.checkLength(input, 3) && BaseballValidate.isUnique(input) && BaseballValidate.checkRange(input);
    }

    public int[] parseBallType(String input) {
        return BaseballTypeCasting.parsingInput(input);
    }

    public int[] judgment(int[] computerNumbers, int[] userNumbers) {
        return BaseballResultHandler.compareNumbers(computerNumbers, userNumbers);
    }
}