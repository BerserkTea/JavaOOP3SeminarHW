package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class EngAlphabetGame extends AbstractGame{
    @Override
    ArrayList<String> generateCharList() {
        return new ArrayList<>(Arrays.asList(
                "A", "B", "C", "D", "F", "G",
                "H", "J", "K", "L", "M", "N", "P",
                "Q", "R", "S", "T", "V", "W",
                "X", "Y", "Z"));
    }
}
