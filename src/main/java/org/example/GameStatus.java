package org.example;

public enum GameStatus {
    INIT("ИНИЦИАЛИЗАЦИЯ"),
    START("НАЧАЛАСЬ"),
    WIN("ВЫИГРАЛИ"),
    LOSE("ПРОИГРАЛИ"),
    STOP("ОСТАНОВЛЕНА");
    private String ruValue;

    GameStatus(String ruValue){
        this.ruValue=ruValue;
    }
    public String getRuValue(){
        return ruValue;
    }
}
