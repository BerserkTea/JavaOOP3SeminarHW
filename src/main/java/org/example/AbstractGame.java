package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class AbstractGame implements Game {
    Integer sizeWord;
    Integer maxTry;

    String computerWord;
    GameStatus gameStatus = GameStatus.INIT;

    abstract ArrayList<String> generateCharList();

    @Override
    public void start(Integer sizeWord, Integer maxTry) {
        this.sizeWord = sizeWord;
        this.maxTry = maxTry;
        gameStatus = GameStatus.START;
        computerWord = generateWord();

    }

    private String generateWord() {
        List<String> alphabet = generateCharList();
        Random random = new Random();
        String res = "";
        for (int i = 0; i < sizeWord; i++) {
            int randomIndex = random.nextInt(alphabet.size());
            res += alphabet.get(randomIndex);
            alphabet.remove(res);
        }
        return res;
    }
    LogGame logGame = new LogGame();
    @Override
    public Answer intValue(String value) {
        value = value.toUpperCase();
        int cow = 0;
        int bull = 0;

        logGame.addToLog(value);
        System.out.println("value = " + value);
        switch (value) {
            case ("LOG"):
                System.out.println("История введенных значений: ");
                logGame.getLogList();
                break;
            case ("EXIT"):
                gameStatus = GameStatus.STOP;
                break;
            case ("SHOW"):
                System.out.println("computerWord = " + computerWord);
                break;
            default:
                if (value.length() <= computerWord.length()) {
                    for (int i = 0; i < value.length(); i++) {
                        if (value.charAt(i) == computerWord.charAt(i)) {
                            cow++;
                            bull++;
                        } else if (computerWord.contains(String.valueOf(value.charAt(i)))) {
                            cow++;
                        }
                        if (bull == computerWord.length()) {
                            gameStatus = GameStatus.WIN;
                        }
                        if (maxTry == 1 && gameStatus != GameStatus.WIN) {
                            gameStatus = GameStatus.LOSE;
                        }
                    }
                    maxTry--;
                } else {
                    System.out.println("!!!!!!!!!!!ВНИМАНИЕ!!!!!!!!!!!!!!!!!\nВы ввели некорректное значение," +
                            " оно превышает загаданное по колличеству символов. " +
                            "Введите снова (Попытки не потратились)");
                    return new Answer(bull, cow, maxTry);
                }
                break;
        }
        return new Answer(bull, cow, maxTry);
    }

    @Override
    public GameStatus getGameStatus() {
        return gameStatus;
    }
}