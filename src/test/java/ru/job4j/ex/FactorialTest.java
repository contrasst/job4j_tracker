package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {

    @Test
    void whenException() {
        Factorial factorial = new Factorial();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> {
            factorial.calc(-1);
        });
        assertThat(exception.getMessage()).isEqualTo("Number could not be less than 0");
    }

    @Test
    void calcWork() {
        Factorial fact = new Factorial();
        int result = fact.calc(3);
        int expected = 6;
        assertThat(result).isEqualTo(expected);
    }
}