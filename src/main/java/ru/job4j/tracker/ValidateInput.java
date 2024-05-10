package ru.job4j.tracker;


import ru.job4j.input.ConsoleInput;
import ru.job4j.input.Input;
import ru.job4j.output.Output;

public class ValidateInput extends ConsoleInput {
    private final Output output;
    private final Input input;

    public ValidateInput(Output output, Input input) {
        this.output = output;
        this.input = input;
    }

    @Override
    public String askStr(String question) {
        return input.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = 1;
        do {
            try {
                value = super.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                output.println("Пожалуйста, введите конкретные данные");
            }
        } while (invalid);
        return value;
    }
}