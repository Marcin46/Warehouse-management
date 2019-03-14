package com.company;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Item i1 = new Item("opona", 7, 4, ItemCondition.USED);
        Item i2 = new Item("wydech", 15, 3, ItemCondition.NEW);
        Item i3 = new Item("felga", 5, 2, ItemCondition.REFRUBISHED);
        Item i4 = new Item("radio", 1, 5, ItemCondition.USED);
        Item i5 = new Item("rama", 50, 1, ItemCondition.NEW);
        Item i6 = new Item("drzwi", 30, 8, ItemCondition.NEW);
        Item i7 = new Item("fotel", 20, 4, ItemCondition.USED);

        FulfillmentCenter magazyn = new FulfillmentCenter("Magazyn", 20);

        //ADD
        magazyn.addProduct(i1);
        magazyn.addProduct(i2);
        magazyn.addProduct(i3);
        magazyn.addProduct(i4);
        magazyn.addProduct(i5);
        magazyn.addProduct(i6);
        magazyn.addProduct(i7);
        magazyn.summary();

        //REMOVE
        magazyn.removeProduct(i6);
        magazyn.summary();

        //SEARCH
        magazyn.search("felga").print();
        System.out.println();

        //SEARCHPARTIAL
        magazyn.searchPartial("a");
        System.out.println();

        //COUNTBYCOND
        System.out.println("Ilość nowych elementów: " + magazyn.countByCondition(ItemCondition.NEW));
        System.out.println();

        //SORTBYNAME
        magazyn.sortByName();
        magazyn.summary();

        //SORTBYAMOUNT
        magazyn.sortByAmount();
        magazyn.summary();

        //MAX
        magazyn.max().print();
        System.out.println();

        FullfillCenterContainer baza = new FullfillCenterContainer();
        baza.addCenter("magazyn1", 30);
        baza.addCenter("magazyn2", 40);
        baza.addCenter("magazyn3", 50);
        baza.addCenter("magazyn4", 60);
        baza.summary();

        baza.removeCenter("magazyn4");
        baza.summary();



        List<FulfillmentCenter> emptyList = new LinkedList<>();
        emptyList = baza.isEmpty();
        System.out.println(emptyList);

    }
}
