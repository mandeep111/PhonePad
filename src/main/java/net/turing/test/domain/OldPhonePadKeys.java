package net.turing.test.domain;

import java.util.List;

public class OldPhonePadKeys {
    private final List<Key> keys = List.of(
            new Key('2', "ABC"),
            new Key('3', "DEF"),
            new Key('4', "GHI"),
            new Key('5', "JKL"),
            new Key('6', "MNO"),
            new Key('7', "PQRS"),
            new Key('8', "TUV"),
            new Key('9', "WXYZ")
    );

    public boolean contains(char c) {
        return keys.stream().anyMatch(key -> key.getId() == c);
    }

    public Key getKey(char c) {
        return keys.stream()
                .filter(key -> key.getId() == c)
                .findFirst()
                .orElse(null);
    }
}
