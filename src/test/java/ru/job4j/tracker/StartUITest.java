package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.action.*;
import ru.job4j.action.User;
import ru.job4j.input.Input;
import ru.job4j.input.Mock;
import ru.job4j.output.Console;
import ru.job4j.output.Output;
import ru.job4j.output.Stub;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {

    @Test
    void whenCreateItem() {
        Output output = new Console();
        Input input = new Mock(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        User[] actions = {
                new Create(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Output output = new Console();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input input = new Mock(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        User[] actions = {
                new Replace(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    void whenDeleteItem() {
        Output output = new Console();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input input = new Mock(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        User[] actions = {
                new Delete(output),
                new Exit(output)};
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    void whenExit() {
        Output output = new Stub();
        Input input = new Mock(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        User[] actions = {
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }

    @Test
    void whenFindAll() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("first item"));
        Item second = tracker.add(new Item("second item"));
        Input input = new Mock(
                new String[]{"0", "1"}
        );
        Output output = new Stub();
        User[] actions = new User[]{
                new FindAll(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод всех заявок ===" + ln
                        + first + ln
                        + second + ln
                        + "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("first item"));
        Input input = new Mock(
                new String[]{"0", String.valueOf(first.getId()), "1"}
        );
        Output output = new Stub();
        User[] actions = new User[]{
                new FindById(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод заявки по id ===" + ln
                        + first + ln
                        + "Меню:" + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    public void whenFindItemsByNameTestOutputIsSuccessfully() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("first item"));
        Item second = tracker.add(new Item("first item"));
        Item third = tracker.add(new Item("another item"));
        Input input = new Mock(
                new String[]{"0", String.valueOf(first.getName()), "1"}
        );
        Output output = new Stub();
        User[] actions = new User[]{
                new FindByName(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод заявок по имени ===" + ln
                        + first + ln
                        + second + ln
                        + "Меню:" + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }
}