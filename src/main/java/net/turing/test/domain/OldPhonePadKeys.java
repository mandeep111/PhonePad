package net.turing.test.domain;

import java.util.Map;

public class OldPhonePadKeys {
    private final Map<Character, String> keyMap = Map.of(
            '2', "ABC",
            '3', "DEF",
            '4', "GHI",
            '5', "JKL",
            '6', "MNO",
            '7', "PQRS",
            '8', "TUV",
            '9', "WXYZ"
    );

    public boolean contains(char c) {
        return keyMap.containsKey(c);
    }

    public String getKey(char c) {
        return keyMap.get(c);
    }
}
