package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int a) {
        return a - x;
    }

    public int divide(int b) {
        return b / x;
    }

    public int multiply(int r) {
        return r * x;
    }

    public  int sumAllOperation(int c) {
        return sum(c) + divide(c) + minus(c) + multiply(c);
    }

    public static void main(String[] args) {
        Calculator s = new Calculator();
        System.out.println(Calculator.sum(5));
        System.out.println(Calculator.minus(12));
        System.out.println(s.divide(20));
        System.out.println(s.sumAllOperation(9));

    }

}
