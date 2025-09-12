package net.turing.test.domain;

import java.util.HashMap;
import java.util.Map;

public class OldPhonePadKeys {
    private final Map<Character, Key> keys = new HashMap<>();

    public OldPhonePadKeys() {
        keys.put('2', new Key('2', "ABC"));
        keys.put('3', new Key('3', "DEF"));
        keys.put('4', new Key('4', "GHI"));
        keys.put('5', new Key('5', "JKL"));
        keys.put('6', new Key('6', "MNO"));
        keys.put('7', new Key('7', "PQRS"));
        keys.put('8', new Key('8', "TUV"));
        keys.put('9', new Key('9', "WXYZ"));
    }

    public boolean contains(char c) {
        return keys.containsKey(c);
    }

    public Key getKey(char c) {
        return keys.get(c);
    }
}
