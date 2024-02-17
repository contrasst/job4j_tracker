package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            if (!fall(matches, count)) {
                count -= matches;
                System.out.println("Спичек осталось: " + count);
                turn = !turn;
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }

    private static boolean fall(int matches, int count) {
        boolean result = (matches < 1 || matches > 3) || count < matches;
        if (result) {
            System.out.println("Нужно ввести именно от 1 до 3"
                    + "; кроме того ввод должен быть менее текущего остатка спичек " + count);
        }
        return result;
    }
}