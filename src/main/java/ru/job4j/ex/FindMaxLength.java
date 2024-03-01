package ru.job4j.ex;

public class FindMaxLength {
    public static void main(String[] args) {
        String[] shops = {"Ebay", null, "Amazon", null, "Ozon"};
        int max = 0;
        for (int index = 0; index < shops.length; index++) {
            String element = shops[index];
            if (element != null) {
                System.out.println(element + " has a size : " + element.length());
            } else if (element.length() > max) {
                max = element.length();
            }
        }
        System.out.println("Max length : " + max);
    }
}