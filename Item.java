package com.company;

import java.util.Comparator;

public class Item implements Comparable<Item>, Comparator<Item> {

    String name;
    double weight;
    int count;
    ItemCondition state;

    public Item() {
        this.name = "Item";
        this.state = ItemCondition.NEW;
        this.weight = 0;
        this.count = 0;
    }

    public Item(String name, double weight, int count, ItemCondition state){
        this.name = name;
        this.state = state;
        this.weight = weight;
        this.count = count;
    }

    @Override
    public int compareTo(Item item) {
        return this.name.compareTo(item.name);
    }

    @Override
    public int compare(Item item1, Item item2) {
        return item1.name.compareTo(item2.name);
    }

    void print() {
        System.out.println(this.name + "\t\t  " + this.weight + "\t\t  " + this.count + "  \t\t" + this.state);
    }
}
