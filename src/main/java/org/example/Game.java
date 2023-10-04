package org.example;

public interface Game {
    void start(Integer sizeWord, Integer maxTry);

    Answer intValue(String value);

    GameStatus getGameStatus();
}
