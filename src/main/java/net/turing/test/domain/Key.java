package net.turing.test.domain;

public class Key {
    private final char id;
    private final String letters;

    public Key(char id, String letters) {
        this.id = id;
        this.letters = letters;
    }

    public char getId() {
        return id;
    }

    public char getLetter(int pressCount) {
        return letters.charAt((pressCount - 1) % letters.length());
    }
}
