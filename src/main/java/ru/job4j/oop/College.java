package ru.job4j.oop;

import java.util.Objects;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        Freshman freshman = (Freshman) student;
        Object object = new Object();
        object = freshman;
    }
 }
