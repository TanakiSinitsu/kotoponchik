package com.example.tatiana.udacityquiz;

/**
 * Created by tatiana on 25.04.16.
 */
public class Question {
    private String questionText;
    private String answer1;
    private String answer2;
    private String answer3;
    private int rightAnswer;

    public Question(String questionText, String answer1, String answer2, String answer3, int rightAnswer) {
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.rightAnswer = rightAnswer;
        this.questionText = questionText;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }
}
