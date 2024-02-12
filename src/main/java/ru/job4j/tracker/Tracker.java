package ru.job4j.tracker;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[items.length];
        int count = 0;
        for (Item item : items) {
            if (item != null && item.getName() != null && item.getName().equals(key)) {
                result[count] = item;
                count++;
            }
        }
        Item[] foundItems = new Item[count];
        System.arraycopy(result, 0, foundItems, 0, count);
        return foundItems;
    }

    public Item[] findAll() {
        int count = 0;
        for (Item item : items) {
            if (item != null) {
                count++;
            }
        }
        Item[] nonNull = new Item[count];
        int index = 0;
        for (Item item : items) {
            if (item != null) {
                nonNull[index] = item;
                index++;
            }
        }
        return nonNull;
    }

    public Item findById(int id) {
        Item result = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                result = item;
                break;
            }
        }
        return result;
    }
}