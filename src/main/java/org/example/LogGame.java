package org.example;

import java.util.ArrayList;
import java.util.List;

public class LogGame {
    List<String> logList = new ArrayList<>();

    public LogGame() {
    }

    public void addToLog(String stringToLog){
        this.logList.add(stringToLog);
    }

    public void getLogList() {
        for (String s : logList) {
            System.out.println(s);
        }
    }

}
