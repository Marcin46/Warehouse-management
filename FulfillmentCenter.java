package com.company;

import java.util.*;


public class FulfillmentCenter implements Comparator<String> {

    String warehouseName;
    static double capacity;
    List<Item> productList;
    static double actualAmount;


    public FulfillmentCenter(String warehouseName, double capacity) {
        this.warehouseName = warehouseName;
        productList = new LinkedList<>();
        this.capacity = capacity;
        actualAmount = 0;
    }


    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }

    void addProduct(Item item) {
        if (item.count + actualAmount <= capacity) {
            if (productList.contains(item)) {
                (search(item.name)).count += item.count;
                actualAmount += item.count;
            }
            else {
                this.productList.add(item);
                actualAmount += item.count;
            }
        }
        else if (capacity != actualAmount)
        {
            item.count = (int) (capacity - actualAmount);
            this.productList.add(item);
            actualAmount += item.count;
        }
        else
            System.err.println("BRAK MIEJSCA");
    }

    void getProduct(Item item) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).equals(item)) {
                if (productList.get(i).count == 1 || productList.get(i).count == 0) {
                    productList.remove(i);
                } else {
                    productList.get(i).count--;
                    actualAmount--;
                }
            }
        }
    }

    void removeProduct(Item item) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).equals(item)) {
                productList.remove(i);
                actualAmount -= item.count;
            }
        }
    }

    Item search(String itemName) {
        int i = 0;
        while ((compare(productList.get(i).name, itemName) != 0)) {
            i++;
            if (i >= productList.size())
                System.err.println("BRAK WYNIKÓW!");
        }
        return productList.get(i);
    }


    List<Item> searchPartial(String itemName) {
        int i = 0;
        List <Item> returnList = new LinkedList<>();
        while ((productList.get(i).name.toLowerCase().contains(itemName.toLowerCase())) == false) {
            i++;
            returnList.add(productList.get(i));
            productList.get(i).print();
            if (i >= productList.size())
                System.err.println("BRAK WYNIKÓW!");
        }
        return returnList;
    }
/*
    void searchPartial(String itemName) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).name.toLowerCase().contains(itemName.toLowerCase())) {
                productList.get(i).print();
            }
        }
    }
*/
    int countByCondition(ItemCondition cond) {
        int number = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).state == ItemCondition.NEW) {
                number++;
            }
        }
        return number;
    }

    void summary() {
        System.out.println("----------------------------------------");
        System.out.println("PRODUKT\t\t  MASA\t\t  ILOŚĆ\t    STAN");
        System.out.println("----------------------------------------");
        for (int i = 0; i < productList.size(); i++) {
            productList.get(i).print();
            System.out.println();
        }
        System.out.println("----------------------------------------\n");
    }

    List sortByName() {
        Collections.sort(productList);
        return productList;
    }

    List sortByAmount() {
        Collections.sort(productList, Collections.reverseOrder(new sortByAmountComparator()));
        return productList;
    }

    Item max() {
        return Collections.max(productList, new sortByAmountComparator());
    }
}