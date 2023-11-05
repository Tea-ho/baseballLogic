package org.example.baseball.object.service;

public interface Validator<T> { // 유효성 인자 넓게 받자
    boolean validate(T input);
}
