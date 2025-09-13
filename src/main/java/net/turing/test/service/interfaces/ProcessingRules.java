package net.turing.test.service.interfaces;

public interface ProcessingRules {
    boolean isFlushCharacter(char c);
    boolean isBackspaceCharacter(char c);
    boolean isValidDigit(char c, KeyMap keyMap);
}
