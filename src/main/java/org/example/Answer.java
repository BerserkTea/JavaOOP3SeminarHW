package org.example;

public class Answer {
    int bull;
    int cow;

    public Answer(int bull, int cow, int maxTry) {
        this.bull = bull;
        this.cow = cow;
        this.maxTry = maxTry;
    }

    int maxTry;

    @Override
    public String toString() {
        return " Быки - " + bull + ", Коровы - " + cow + " , осталось попыток - " + maxTry;
    }
}
