package com.example.task3;

public class Quiz {
    private String question;
    private String button1;
    private String button2;
    private String button3;
    private String button4;
    private String answer;

    public Quiz(String question, String button1, String button2, String button3, String button4, String answer) {
        this.question = question;
        this.button1 = button1;
        this.button2 = button2;
        this.button3 = button3;
        this.button4 = button4;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getButton1() {
        return button1;
    }

    public void setButton1(String button1) {
        this.button1 = button1;
    }

    public String getButton2() {
        return button2;
    }

    public void setButton2(String button2) {
        this.button2 = button2;
    }

    public String getButton3() {
        return button3;
    }

    public void setButton3(String button3) {
        this.button3 = button3;
    }

    public String getButton4() {
        return button4;
    }

    public void setButton4(String button4) {
        this.button4 = button4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
