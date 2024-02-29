package ru.job4j.tracker;

import ru.job4j.action.*;
import ru.job4j.action.User;
import ru.job4j.input.Input;
import ru.job4j.output.Console;
import ru.job4j.output.Output;

public class StartUI {
    private final Output output;

    public StartUI(Output output) {
        this.output = output;
    }

    public void init(Input input, Tracker tracker, User[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Выбрать: ");
            User action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(User[] actions) {
         output.println("Меню:");
        for (int index = 0; index < actions.length; index++) {
            output.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Output output = new Console();
        Input input = new ru.job4j.input.Console();
        Tracker tracker = new Tracker();
        User[] actions = {
                new Create(output),
                new FindAll(output),
                new Replace(output),
                new Delete(output),
                new FindById(output),
                new FindByName(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
    }
}
