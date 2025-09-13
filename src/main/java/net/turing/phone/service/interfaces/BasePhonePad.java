package net.turing.phone.service.interfaces;

public abstract class BasePhonePad implements PhonePad {
    protected final InputProcessor processor;

    protected BasePhonePad(InputProcessor processor) {
        this.processor = processor;
    }

    @Override
    public String processInput(String input) {
        return processor.process(input);
    }
}
