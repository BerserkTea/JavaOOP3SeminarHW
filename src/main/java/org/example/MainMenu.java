package org.example;

import java.util.Scanner;

public class MainMenu {

    /**
     * Инициализация и запуск меню для игры
     */
    public static void startProgramMenu() {
        LogGame logGame = new LogGame();
        boolean workMainMenu = true;
        while (workMainMenu) {
            System.out.println("______________________________________________________\n" +
                    "Добро пожаловать в игру \"Быки и Коровы\"\n" +
                    "Введите интересующий вас пункт меню и нажмите Enter:\n" +
                    "1. Играть используя цифры\n" +
                    "2. Играть используя английский алфавит\n" +
                    "3. Играть с русский алфавит\n" +
                    "4. Показать правила\n" +
//                    "5. Показать лог игры\n" +
                    "0. Завершение игры\n");

            Scanner scanner = new Scanner(System.in);
            String item = scanner.next();
            logGame.addToLog(item);
            switch (item) {
                case "1":
                    System.out.println("Вы выбрали: Играть используя цифры, " +
                            "введите колличество символов для генерации и нажмите Enter\n" +
                            "А так же введите число попыток и нажмите Enter");
                    startPlay(collectValue(), collectValue(), new NumberGame());
                    break;

                case "2":
                    System.out.println("Вы выбрали: Играть используя английский алфавит, " +
                            "введите колличество символов для генерации и нажмите Enter\n" +
                            "А так же введите число попыток и нажмите Enter");
                    startPlay(collectValue(), collectValue(), new EngAlphabetGame());
                    break;

                case "3":
                    System.out.println("Вы выбрали: Играть используя русский алфавит, " +
                            "введите колличество символов для генерации и нажмите Enter\n" +
                            "А так же введите число попыток и нажмите Enter");
                    startPlay(collectValue(), collectValue(), new RusAlphabetGame());
                    break;

                case "4":
                    System.out.println("Быки и коровы — логическая игра, в ходе которой за несколько попыток один\n" +
                            " из игроков должен определить, что задумал другой игрок. Варианты игры могут зависеть\n" +
                            " от типа отгадываемой последовательности — это могут быть числа, цвета, пиктограммы или слова.\n" +
                            " После каждой попытки задумавший игрок выставляет «оценку», указывая количество угаданного\n" +
                            "без совпадения с их позициями (количество «коров») и полных совпадений (количество «быков»).\n" +
                            " Роли участников игры не равнозначны — угадывающий должен анализировать сделанные попытки и \n" +
                            "полученные оценки, то есть его роль активна. Его партнёр лишь сравнивает очередной вариант с\n" +
                            " задуманным и выставляет оценку по формальным правилам, то есть его роль пассивна.\n" +
                            "Для уравновешивания ролей одновременно играют две встречные партии.\n" +
                            "Первоначально игра была задумана для двух игроков,\n" +
                            " но с появлением компьютерных версий стал популярен вариант,\n" +
                            " когда игрок отгадывает число, задуманное программой, то есть играет в одиночку.\n");
                    break;

//                case "5":
//                    System.out.println("Вы выбрали : Показать лог игры");
//                    break;

                case "0":
                    System.out.println("Выход из игры");
                    workMainMenu = false;
                    break;
                default:
                    System.out.println("\"ошибка\" = " + "ошибка");
                    break;
            }
        }
    }

    /**
     * Метод реализует запуск выбранной игры, и передает параметры
     * @param sizeWord
     * @param maxTry
     * @param whitchGame
     */
    public static void startPlay(int sizeWord, int maxTry, Game whitchGame) {
        System.out.println("------------Игра началась!------------\n"+
                "Загаданное слова состоит из " + sizeWord + " символов, и у вас " + maxTry + " попыт(ки/ок)"+
                " для досрочного завершения введите \"exit\", для просмотра \"log\"," +
                " для просмотра загаданного слова \"show\"");
        whitchGame.start(sizeWord, maxTry);
        while (whitchGame.getGameStatus() != GameStatus.WIN
                && whitchGame.getGameStatus() != GameStatus.LOSE
                && whitchGame.getGameStatus() != GameStatus.STOP) {
            Scanner scan = new Scanner(System.in);
            Answer answer = whitchGame.intValue(scan.nextLine());
            System.out.println("ПОДСКАЗОЧКА: Колличество коров и быков: " + answer + "\n"
                    + " для досрочного завершения введите \"exit\", для просмотра \"log\"," +
                    " для просмотра загаданного слова \"show\"");
        }
        System.out.println(whitchGame.getGameStatus());
    }

    public static int collectValue() {
        Scanner scanner = new Scanner(System.in);
        return (scanner.nextInt());
    }
}

