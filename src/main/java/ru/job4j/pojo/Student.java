package ru.job4j.pojo;

public class Student {
    private String fullName;
    private String dataJoin;
    private int group;

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getDataJoin() {
        return dataJoin;
    }

    public void setDataJoin(String dataJoin) {
        this.dataJoin = dataJoin;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
