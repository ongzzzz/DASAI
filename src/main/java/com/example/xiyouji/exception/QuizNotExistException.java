package com.example.xiyouji.exception;

public class QuizNotExistException extends RuntimeException {

    private final static String message = "Story Not Exist";
    public QuizNotExistException() {
        super(message);
    }
}
