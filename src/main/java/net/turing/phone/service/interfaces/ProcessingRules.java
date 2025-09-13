package net.turing.phone.service.interfaces;

public interface ProcessingRules {
    boolean isFlushCharacter(char c);
    boolean isBackspaceCharacter(char c);
    boolean isValidDigit(char c, KeyMap keyMap);
}
