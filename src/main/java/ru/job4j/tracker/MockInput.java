package ru.job4j.tracker;

public class MockInput implements Input {
    @Override
    public String askStr(String question) {
        return null;
    }

    @Override
    public int askint(String question) {
        return 0;
    }
}
