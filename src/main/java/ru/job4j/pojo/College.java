package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setDataJoin("22.07.2006");
        student.setGroup(2);
        student.setFullName("Sidorov Ivan Genadievych");
        System.out.println("Full name: " + student.getFullName());
        System.out.println("Group: " + student.getGroup());
        System.out.println("Data join: " + student.getDataJoin());
    }
}
